package  Webserver;

import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.util.StringTokenizer;

public class HTTPserverTCP implements Runnable {

    static final File PATH = new File("");  // Find path to your webpages
    static final String DEFAULT_FILE = "index.html";
    static final String METHOD_NOT_SUPPORTED = "501.txt";
    static final String FILE_NOT_FOUND = "404.html";
    static final int PORT = 8686;

    // Client Connection
    private Socket connection;

    public HTTPserverTCP(Socket socket) {
        connection = socket;
    }

    public static void main(String[] args) throws Exception {

        try {
            ServerSocket serverConnect = new ServerSocket(PORT);
            System.out.println("Server is running.\nListening for connections on port: " + PORT);

            // Listen on port untill user stops server execution
            while (true) {
                // Accept incomming connection
                HTTPserverTCP myServer = new HTTPserverTCP(serverConnect.accept());

                // Create a dedicated thread to manage connection
                Thread thread = new Thread(myServer);
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("Connection error: " + ex.getMessage());
        }
    }

    @Override
    public void run() {
        // initialize objects before we use them
        BufferedReader inFromClient = null;
        PrintWriter outFromServer = null;
        BufferedOutputStream dataOutFromServer = null;
        String fileRequested = null;

        try {
            // Used so we are able to read input from client via the input stream in the socket.
            inFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // Used so we are able to send the header to the client
            outFromServer = new PrintWriter(connection.getOutputStream());
            // Used so we are able to send the requested data to the client
            dataOutFromServer = new BufferedOutputStream(connection.getOutputStream());

            // Get the first line of the request from the client
            String input = inFromClient.readLine();
            // Use the Tokenizer library to tokenize the request into three tokens
            StringTokenizer tokenizedString = new StringTokenizer(input);
            // First token is the request, for example GET
            String method = tokenizedString.nextToken().toUpperCase();
            // Second token is the url requested from the client
            fileRequested = tokenizedString.nextToken().toLowerCase();

            // If the client sends any other request than a GET request
            if (!method.equals("GET")) {
                // we return the 501 error page, since it means that the request is not supported by server
                File file = new File(PATH, METHOD_NOT_SUPPORTED);
                int fileLength = (int) file.length();   // Cast the length to an int
                byte[] fileData = readFileData(file, fileLength);

                // Send HTTP header
                sendHeader(outFromServer, fileRequested, fileLength, getContentType(fileRequested), "HTTP/1.0 501 METHOD NOT SUPPORTED");
                // Send file
                dataOutFromServer.write(fileData, 0, fileLength);
                dataOutFromServer.flush();
                connection.close();

            } else { // The request is a GET request

                if (fileRequested.endsWith("/")) {
                    fileRequested += DEFAULT_FILE;
                }

                File file = new File(PATH, fileRequested);
                int fileLength = (int) file.length();
                byte[] fileData = readFileData(file, fileLength);

                // Send HTTP header
                sendHeader(outFromServer, fileRequested, fileLength, getContentType(fileRequested), "HTTP/1.0 200 OK");
                // Send file
                dataOutFromServer.write(fileData, 0, fileLength);
                dataOutFromServer.flush();
                connection.close();
            }

        } catch (FileNotFoundException fnf) {
            try {
                fileNotFound(outFromServer, dataOutFromServer, fileRequested);
            } catch (IOException ioe) {
                System.out.println("Error with File Not Found exception: " + ioe.getMessage());
            }
        } catch (IOException ex) { // if there is an error with the input, we close everything
            System.out.println("Server error: " + ex.getMessage());
        } finally {
            try {
                inFromClient.close();
                outFromServer.close();
                dataOutFromServer.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println("There was an error in closing the stream: " + ex.getMessage());
            }
        }

    }

    // Method to read data from a html page and save it as a byte array
    private byte[] readFileData(File file, int fileLength) throws IOException {
        FileInputStream fileInput = null;
        byte[] fileData = new byte[fileLength];
        try {
            fileInput = new FileInputStream(file);
            fileInput.read(fileData);
        } finally {
            if (fileInput != null)
                fileInput.close();
        }

        return fileData;
    }

    private void sendHeader(PrintWriter outFromServer, String fileRequested, int fileLength, String contentType, String statuscode) {
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);

        // Send HTTP headers
        outFromServer.println(statuscode);
        outFromServer.println("Server: Knoth Inc Server System: 0.1");
        outFromServer.println("Date: " + month + "/" + date + "/" + year);
        outFromServer.println("Time of day: " + hours + ":" + minutes);
        outFromServer.println("Content-type: " + contentType);
        outFromServer.println("Content-length: " + fileLength);
        outFromServer.println("Connection: close");
        outFromServer.println();
        outFromServer.flush();
    }

    private String getContentType(String fileRequested) {
        if(fileRequested.endsWith(".html")) {
            return "text/html";
        } else if (fileRequested.endsWith(".png")) {
            return "image/png";
        } else if (fileRequested.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (fileRequested.endsWith(".bmp")) {
            return "image/bmp";
        } else if (fileRequested.endsWith(".pdf")) {
            return "application/pdf";
        } else if (fileRequested.endsWith(".doc")) {
            return "application/msword";
        } else if (fileRequested.endsWith(".zip")) {
            return "application/zip";
        } else if (fileRequested.endsWith(".css")) {
            return "text/css";
        } else {
            return "text/plain";
        }
    }

    private void fileNotFound(PrintWriter outFromServer, OutputStream dataOutFromServer, String fileRequested) throws IOException {
        File file = new File(PATH, FILE_NOT_FOUND);
        int fileLength = (int) file.length();
        String content = "text/html";
        byte[] fileData = readFileData(file, fileLength);

        sendHeader(outFromServer, fileRequested, fileLength, content, "HTTP/1.0 404 FILE NOT FOUND");

        dataOutFromServer.write(fileData, 0, fileLength);
        dataOutFromServer.flush();
        dataOutFromServer.close();
    }
}
