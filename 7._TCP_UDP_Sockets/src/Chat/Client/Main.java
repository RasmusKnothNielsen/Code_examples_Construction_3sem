package Chat.Client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main
{
    private final static int PORT_NUMBER = 20202;
    private final static int BUFFER_LENGTH = 1024;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Hello and welcome to the amazing chat client!");

        try (DatagramSocket socket = new DatagramSocket())
        {
            // Get server address from user
            System.out.print("Please enter the address of the chat server: ");
            InetAddress inetAddress = getServerAddress();

            // Register user name with server
            System.out.print("Super! Please state the name you will be known by: ");
            registerUserName(socket, inetAddress, PORT_NUMBER);

            // Start the chat
            System.out.println("Excellent! You have been connected to the chat server.");
            chat(socket, inetAddress, PORT_NUMBER);
        }
        catch (SocketException e)
        {
            System.out.println("Could not get a socket!");
        }
        catch (IOException e)
        {
            System.out.println("There was an error communicating with the server.");
        }
        scanner.close();
    }

    private static InetAddress getServerAddress()
    {
        while (true)
        {
            // Get server name from user
            String serverAddress = scanner.nextLine();
            try
            {
                return InetAddress.getByName(serverAddress);
            }
            catch (UnknownHostException e)
            {
                System.out.println("Could not find that host. Please try again.");
                System.out.print("Enter the address of the chat server: ");
            }
        }
    }

    private static void registerUserName(DatagramSocket socket, InetAddress inetAddress, int port) throws IOException
    {
        // Get user name from user
        String userName = scanner.nextLine();

        boolean joined = false;
        while (!joined)
        {
            joined = joinServer(userName, socket, inetAddress, port);
            if (!joined)
            {
                System.out.print("User name not available. Please enter another name: ");
                userName = scanner.nextLine();
            }
        }
    }

    private static boolean joinServer(String userName, DatagramSocket socket, InetAddress inetAddress, int port)
            throws IOException
    {
        // Send JOIN message to server
        String sendMsg = "JOIN: " + userName;
        DatagramPacket sendPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.length(), inetAddress, port);
        socket.send(sendPacket);

        // Get server response
        DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_LENGTH], BUFFER_LENGTH);
        socket.receive(receivePacket);
        String receiveMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());

        // Check response
        if (receiveMsg.startsWith("JOIN OK"))
            return true;
        if (receiveMsg.startsWith("JOIN ERROR"))
            return false;

        // reply can only be JOIN OK or JOIN ERROR. Other replies indicate some kind of error.
        throw new IOException();
    }

    private static void chat(DatagramSocket socket, InetAddress inetAddress, int port)
    {
        String message;
        String serverMessage;
        DatagramPacket sendPacket = new DatagramPacket(new byte[BUFFER_LENGTH], BUFFER_LENGTH, inetAddress, port);
        boolean run = true;

        // Start the thread that receives messages from the server
        ChatClientThread chatClientThread = new ChatClientThread(socket);
        Thread thread = new Thread(chatClientThread);
        thread.start();

        // Loop to get user input and send it to the server
        while (run)
        {
            // Get user input
            System.out.print(">");
            message = scanner.nextLine().trim();

            // Limit length of user input to 200 characters
            message = message.substring(0, Math.min(message.length(), 200));

            // Check if the user wants to quit.
            if (message.equals("QUIT"))
            {
                run = false;
                serverMessage = "QUIT";
            }
            // If not then prepare a message with the user input
            else
            {
                serverMessage = "MESSAGE: " + message;
            }

            // Send message to server
            sendPacket.setData(serverMessage.getBytes());
            sendPacket.setLength(serverMessage.getBytes().length);
            try
            {
                socket.send(sendPacket);
            }
            catch (IOException e)
            {
                System.out.println("Error sending message to server.");
                break;
            }
        }
    }

}
