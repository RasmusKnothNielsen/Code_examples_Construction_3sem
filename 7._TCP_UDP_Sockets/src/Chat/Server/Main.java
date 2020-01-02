package Chat.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main
{
    private final static int PORT_NUMBER = 20202;
    private final static int BUFFER_LENGTH = 1024;

    public static void main(String[] args)
    {
        try (DatagramSocket socket = new DatagramSocket(PORT_NUMBER))
        {
            ClientHandler clientHandler = new ClientHandler(socket);

            DatagramPacket packet = new DatagramPacket(new byte[BUFFER_LENGTH], BUFFER_LENGTH);

            System.out.println("Server ready on port " + PORT_NUMBER);

            while (true)
            {
                try
                {
                    // Get message from client
                    socket.receive(packet);

                    String receivedMsg = new String(packet.getData(), 0, packet.getLength());
                    InetAddress inetAddress = packet.getAddress();
                    int port = packet.getPort();

                    // If host is not in client-list the only message we should check for is JOIN
                    if (clientHandler.clientFirstContact(inetAddress, port))
                    {
                        Client client = new Client(inetAddress, port);

                        System.out.println("New host seen on " + client.toString());

                        if (receivedMsg.startsWith("JOIN: "))
                            parseJoin(receivedMsg, clientHandler, client);
                    }
                    // If host is in the client-list we should check for QUIT and MESSAGE messages
                    else
                    {
                        Client client = clientHandler.getClient(inetAddress, port);

                        System.out.println(client + " -> " + receivedMsg);

                        if (receivedMsg.equals("QUIT"))
                        {
                            System.out.println(client.getUserName() + " quit");
                            clientHandler.remove(client);
                        }
                        else if (receivedMsg.startsWith("MESSAGE: "))
                        {
                            clientHandler.sendMessageToAll("FROM " + client.getUserName() + " MESSAGE "
                                    + receivedMsg.substring(9));
                        }
                    }
                }
                catch (IOException e)
                {
                    System.out.println("Socket send/receive error");
                    break;
                }
            }
        }
        catch (SocketException e)
        {
            System.out.println("Could not open UDP socket");
        }
    }

    private static void parseJoin(String message, ClientHandler clientHandler, Client client)
    {
        String userName = message.substring(6).trim();

        // If username is free then add client to the client-list
        if (clientHandler.userNameFree(userName))
        {
            client.setUserName(userName);
            System.out.println(client.toString() + " connected");
            clientHandler.sendMessageToAll("NEW CLIENT " + client.getUserName());
            clientHandler.add(client);
            clientHandler.sendMessage("JOIN OK", client);
        }
        else
        {
            clientHandler.sendMessage("JOIN ERROR username occupied", client);
        }
    }
}
