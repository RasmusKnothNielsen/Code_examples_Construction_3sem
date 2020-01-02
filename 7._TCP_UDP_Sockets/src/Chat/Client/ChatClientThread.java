package Chat.Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// Thread to read messages from the server and display them on the console

public class ChatClientThread implements Runnable
{
    private DatagramSocket socket;

    ChatClientThread(DatagramSocket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        byte[] readBuffer = new byte[1024];
        DatagramPacket readPacket = new DatagramPacket(readBuffer, readBuffer.length);
        while (true)
        {
            // Get message from server
            try
            {
                socket.receive(readPacket);
            }
            catch (IOException e)
            {
                // Exit when the socket is closed by the main thread
                break;
            }
            String receiveMsg = new String(readBuffer, 0, readPacket.getLength());

            // Check for message types
            if (receiveMsg.startsWith("NEW CLIENT "))
            {
                System.out.println(receiveMsg.substring(11) + " joined the chat");
            }
            else if (receiveMsg.startsWith("FROM "))
            {
                String messageToScreen=receiveMsg.replaceFirst("FROM ", "From user: ")
                        .replaceFirst("MESSAGE ","  Message: ");
                System.out.println(messageToScreen);
            }
        }
    }
}
