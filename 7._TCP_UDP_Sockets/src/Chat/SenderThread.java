/*
Computer Science, KEA, Denmark.
3. Semester, Fall 2019.
Mandatory Assignment in Tech2.
Read Network_Assignment2.pdf for more information

@Author: Rasmus Knoth Nielsen.
 */

package  Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

class SenderThread extends Thread
{

    private InetAddress serverIPAddress;
    private DatagramSocket udpClientSocket;
    private int serverPort;
    private String username;

    public SenderThread( InetAddress address, int serverPort) throws SocketException
    {
        this.serverIPAddress = address;
        this.serverPort = serverPort;

        // Create client DatagramSocket
        udpClientSocket = new DatagramSocket();
        udpClientSocket.connect(serverIPAddress, serverPort);
    }

    public DatagramSocket getSocket()
    {
        return this.udpClientSocket;
    }

    public void run()
    {
        try
        {
            //send join message with username
            byte[] data = new byte[203];
            data = "".getBytes();
            DatagramPacket blankPacket = new DatagramPacket(data,data.length , serverIPAddress, serverPort);
            udpClientSocket.send(blankPacket);

            // Create input stream
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("\nPreferred username: ");
            username = inFromUser.readLine();
            String sentence = "JOIN: " + username;
            data = sentence.getBytes();
            DatagramPacket joinPacket = new DatagramPacket(data,data.length, serverIPAddress, serverPort);
            udpClientSocket.send(joinPacket);

            while (true)
            {
                // Message to send
                String clientMessage = inFromUser.readLine();

                // Create byte buffer to hold the message to send
                byte[] sendData = new byte[1024];

                // Transform the incoming message to a MESSAGE: statement that comply with protocol
                clientMessage = "MESSAGE: " + clientMessage;

                // Put this message into our empty buffer/array of bytes
                sendData = clientMessage.getBytes();

                // Create a DatagramPacket with the data, IP address and port number
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, serverPort);

                // Send the UDP packet to server
                udpClientSocket.send(sendPacket);
                if (clientMessage.equals("MESSAGE: QUIT"))
                    break;

                Thread.yield();
            }
            System.exit(1);
        }
        catch (IOException ex)
        {
            System.err.println(ex);
        }
    }
}