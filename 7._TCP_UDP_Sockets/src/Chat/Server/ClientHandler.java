package Chat.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;

class ClientHandler
{
    private Collection<Client> clientCollection;
    private DatagramSocket socket;

    ClientHandler(DatagramSocket socket)
    {
        this.socket = socket;
        clientCollection = new ArrayList<>();
    }

    // Add client to collection
    void add(Client client)
    {
        clientCollection.add(client);
    }

    // Remove client from collection
    void remove(Client client)
    {
        clientCollection.remove(client);
    }

    // Return client identified by InetAddress and port number
    Client getClient(InetAddress inetAddress, int portNumber)
    {
        for (Client client : clientCollection)
        {
            if (client.getInetAddress().equals(inetAddress) && portNumber == client.getPortNumber())
            {
                return client;
            }
        }
        return null;
    }

    // Return true if client is not in client collection
    boolean clientFirstContact(InetAddress inetAddress, int port)
    {
        return getClient(inetAddress, port) == null;
    }

    // Send message to client
    void sendMessage(String message, Client destinationClient)
    {
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length
                , destinationClient.getInetAddress(), destinationClient.getPortNumber());
        try
        {
            socket.send(packet);
        }
        catch (IOException e)
        {
            System.out.println("Error sending message to " + destinationClient.getUserName());
        }
    }

    // Return client identified by user name
    Client getClientByUserName(String userName)
    {
        for (Client client : clientCollection)
        {
            if (client.getUserName().equals(userName))
                return client;
        }
        return null;
    }

    // Send message to all clients in the collection
    void sendMessageToAll(String message)
    {
        for (Client client : clientCollection)
        {
            sendMessage(message, client);
        }
    }

    // Return true if user name is not in client collection
    boolean userNameFree(String userName)
    {
        return getClientByUserName(userName) == null;
    }

}
