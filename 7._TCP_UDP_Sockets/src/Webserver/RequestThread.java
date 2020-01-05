package Webserver;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

public class RequestThread implements Runnable {

    private static int socketCounter = 0;

    private final static String DOCUMENT_ROOT = "C:\\Users\\knud\\www";
    private final static String HTTP_VERSION = "HTTP/1.0";
    private final static String DEFAULT_PAGE = "index.html";

    private Socket threadSocket;

    public RequestThread(Socket socket) {
        threadSocket = socket;
        socketCounter++;
    }

    @Override
    public void run() {
        System.out.println("Processing socket " + threadSocket);
        processRequest(threadSocket);

        try {
            threadSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There was an error closing socket");
        }

    }

    private void processRequest(Socket socket) {
        BufferedReader input = null;
        DataOutputStream output = null;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to make inputstream");
            return;
        }

        try {
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to make outputstream");
            return;
        }

        String request = null;
        try {
            request = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to read data from client");
            return;
        }

        if (request == null) {
            System.out.println("Got empty/no request from client");
            return;
        }

        StringTokenizer inputTokenizer = new StringTokenizer(request);

        if (!inputTokenizer.hasMoreTokens()) {
            sendStatusLine(400, "Request method missing", output);
            sendConnectionClose(output);
            sendCRLF(output);
            return;
        }
        String requestMethod = inputTokenizer.nextToken();

        if (!inputTokenizer.hasMoreTokens()) {
            sendStatusLine(400, "Request path missing", output);
            sendConnectionClose(output);
            sendCRLF(output);
            return;
        }
        String requestPath = inputTokenizer.nextToken();

        if (!inputTokenizer.hasMoreTokens()) {
            sendStatusLine(400, "Request version missing", output);
            sendConnectionClose(output);
            sendCRLF(output);
            return;
        }
        String requestVersion = inputTokenizer.nextToken();

        if (requestMethod.equals("GET")) {
            processGet(requestPath, requestVersion, input, output);
        } else {
            sendStatusLine(501, "Method not implemented", output);
            sendConnectionClose(output);
            sendCRLF(output);
        }
    }

    private static void sendStatusLine(Integer statusCode, String reasonPhrase, DataOutputStream outputStream) {
        String msg = HTTP_VERSION + " " + statusCode.toString() + " " + reasonPhrase + "\r\n";
        System.out.println(reasonPhrase);
        send(msg, outputStream);
        sendConnectionClose(outputStream);
    }

    private static void sendConnectionClose(DataOutputStream output) {
        sendResponseHeader("Connection", "close", output);
    }

    private static void sendResponseHeader(String headerName, String headerValue, DataOutputStream outputStream) {
        String msg = headerName + ": " + headerValue + "\r\n";
        send(msg, outputStream);
    }

    private static void sendCRLF(DataOutputStream outputStream) {
        send("\r\n", outputStream);
    }

    private static void send(String msg, DataOutputStream outputStream) {
        try {
            outputStream.writeBytes(msg);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to write to client");
            System.out.println(msg);
        }
    }


    private static boolean fileUnderDocumentRoot(File file) {
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return canonicalPath.startsWith(DOCUMENT_ROOT);
    }

    static private void sendNotFound(DataOutputStream output) {
        sendStatusLine(404, "File not found", output);
        sendCRLF(output);
        return;
    }

    static private void sendNotFound(String fileName, DataOutputStream output) {
        sendNotFound(output);
        sendResponseHeader("Content-Type", "text/html", output);
        sendResponseHeader("Content-Length", "123", output);
        sendConnectionClose(output);
        sendCRLF(output);

        return;
    }

    private static void processGet(String requestPath, String requestVersion, BufferedReader input, DataOutputStream output) {
        // favicon.ico
        if (requestPath.endsWith("favicon.ico"))
            return;

        String path = DOCUMENT_ROOT + requestPath;

        File file = new File(path);

        if (!fileUnderDocumentRoot(file)) {
            sendStatusLine(403, "Forbidden", output);
            sendCRLF(output);
            return;
        }


        if (file.isDirectory()) {
            path += "/" + DEFAULT_PAGE;
            file = new File(path);
            if (file.isDirectory()) {
                sendNotFound(output);
                return;
            }
        }

        if (!file.exists()) {
            System.out.print(file.getName() + ": ");
            sendStatusLine(404, "File not found", output);
            return;
        }

        sendFile(file, output);
    }

    private static BufferedInputStream getBufferedInputStream(File file) throws FileNotFoundException {

        BufferedInputStream fileReader;

        if (!file.exists())
            throw new FileNotFoundException();

        try {
            fileReader = new BufferedInputStream(new FileInputStream(file));
            return fileReader;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private static void sendFile(File file, DataOutputStream output) {

        System.out.println("Sending " + file.getName());

        BufferedInputStream fileReader;

        try {
            fileReader = getBufferedInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            sendStatusLine(500, "Could not open file", output);
            sendCRLF(output);
            return;
        }

        sendStatusLine(200, "OK", output);

        String date = new Date().toString();
        sendResponseHeader("Date", date, output);

        String contentType = getMimeTypeByFileName(file.getName());

        sendResponseHeader("Content-Type", contentType, output);

        sendResponseHeader("Content-Length", String.valueOf(file.length()), output);

        sendCRLF(output);

        int count;
        byte[] buffer = new byte[8192];

        try {
            while ((count = fileReader.read(buffer)) > 0) {
                output.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to send file");
            return;
        }

        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendFileMinimal(String fileName, DataOutputStream output) {
        File file = new File(fileName);

        BufferedInputStream fileReader;

        try {
            fileReader = getBufferedInputStream(file);
        } catch (FileNotFoundException e) {
            sendCRLF(output);
            return;
        }

        String contentType = getMimeTypeByFileName(fileName);

        sendResponseHeader("Content-Type", contentType, output);

        sendResponseHeader("Content-Length", String.valueOf(file.length()), output);

        sendCRLF(output);

        int count;
        byte[] buffer = new byte[8192];

        try {
            while ((count = fileReader.read(buffer)) > 0) {
                output.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to send file");
            return;
        }

        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getMimeTypeByFileName(String fileName) {
        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg"))
            return "image/jpeg";
        if (fileName.endsWith(".htm") || fileName.endsWith(".html"))
            return "text/html";
        if (fileName.endsWith(".gif"))
            return "image/gif";
        if (fileName.endsWith(".bmp"))
            return "image/bmp";
        if (fileName.endsWith(".txt"))
            return "text/plain";
        if (fileName.endsWith(".pdf"))
            return "application/pdf";
        if (fileName.endsWith(".doc"))
            return "application/msword";

        return "application/octet-stream";
    }

}
