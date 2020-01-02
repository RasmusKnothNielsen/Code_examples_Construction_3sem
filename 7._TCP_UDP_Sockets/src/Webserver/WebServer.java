package Webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class WebServer {


    public static void main(String[] args)
    {
        final int socketNumber = 8080;
        ServerSocket serverSocket;
        Socket socket = null;
        try
        {
            serverSocket = new ServerSocket(socketNumber);
        }
        catch (IOException e)
        {
            System.out.println("Failed to connect to socket " + socketNumber);
            return;
        }
        while (true)
        {
            try
            {
                socket = serverSocket.accept();
                RequestThread requestThread = new RequestThread(socket);
                Thread thread = new Thread(requestThread);
                thread.start();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Failed to accept connection on port " + socketNumber);
            }
        }
    }

}
