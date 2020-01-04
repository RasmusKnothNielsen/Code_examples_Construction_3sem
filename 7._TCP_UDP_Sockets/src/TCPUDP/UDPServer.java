package TCPUDP;

import java.io.*;
import java.net.*;

public class UDPServer
{
    public static void main(String[] args) throws Exception
    {
        String receiveMessage;
        String sendMessage;
        byte[] sendData;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket socket = new DatagramSocket(6701);

        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");

        DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);

        while (true)
        {
            socket.receive(receivePacket);
            receiveMessage = new String(receivePacket.getData(),0,receivePacket.getLength());
            System.out.println("Message received: " + receiveMessage);
            if(receiveMessage.startsWith("QUIT"))
              break;

            System.out.println("Please type your message: ");
            sendMessage = inFromUser.readLine();
            sendData = sendMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6710);
            socket.send(sendPacket);
            if(sendMessage.startsWith("QUIT"))
              break;
        }
    }
}



