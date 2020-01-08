/*
Computer Science, KEA, Denmark.
3. Semester, Fall 2019.
Mandatory Assignment in Tech2.
Read Network_Assignment2.pdf for more information

@Author: Rasmus Knoth Nielsen.
 */

package Chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

class ReceiverThread extends Thread
{

    private DatagramSocket udpClientSocket;

    public ReceiverThread(DatagramSocket ds) throws SocketException
    {
        this.udpClientSocket = ds;
    }

    public void run()
    {

        // Create a byte buffer/array for the receive Datagram packet
        byte[] receiveData = new byte[1024];

        while (true)
        {
            // Set up a DatagramPacket to receive the data into
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            try
            {
                // Receive a packet from the server (blocks until the packets are received)
                udpClientSocket.receive(receivePacket);

                // Extract the reply from the DatagramPacket
                String serverReply =  new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Format text to comply with protocol
                if (serverReply.startsWith("FROM"))
                {
                    // Get indices of USERNAME and MESSAGE
                    int messageIndex = serverReply.indexOf("MESSAGE");
                    String username = serverReply.substring(5, messageIndex);
                    String message = serverReply.substring(messageIndex + 8);
                    // Pad username with whitespaces up to 20 chars
                    username = String.format("%-20s", username);
                    System.out.println("From user: " + username + "Message: " + message);
                }

                else if (serverReply.startsWith("NEW CLIENT"))
                {
                    // Get the user name
                    String username = serverReply.substring(11);
                    System.out.println(username + " just joined the chat!");
                }

                else if (serverReply.startsWith("JOIN OK"))
                {
                    // Tell the user that he has joined successfully
                    System.out.println("You joined successfully");
                }

                else
                {
                    System.out.println(serverReply);
                }

                Thread.yield();
            }
            catch (IOException ex)
            {
                System.err.println(ex);
            }
        }
    }
}