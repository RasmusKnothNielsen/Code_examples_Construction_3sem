package TCPUDP;

import java.io.*;
import java.net.*;

// Transmission Control Protocol
public class TCPServer
{
    public static void main(String args[]) throws Exception
    {
        System.out.println("starting TCP Server main program");
        String sentence;
        String userText;

        // Set to listen on port 5656
        ServerSocket welcomeSocket = new ServerSocket(5656);
        System.out.println("we have a socket");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("waiting for a connection");
        Socket connectionSocket = welcomeSocket.accept();   // Waits until a connection is wanted.
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

        System.out.println("we have a connection");

        while (true)
        {
            sentence = inFromClient.readLine();
            System.out.println("FROM CLIENT: " + sentence);
            if(sentence.startsWith("QUIT"))
              break;

            System.out.print("Please type your text: ");
            userText = inFromUser.readLine();
            outToClient.writeBytes(userText + '\n');
            if(userText.startsWith("QUIT"))
              break;
        }

        connectionSocket.close();
        welcomeSocket.close();
    }

}
