package Chat.Server;

import java.net.InetAddress;

public class Client
{
    private InetAddress inetAddress;
    private int portNumber;
    private String userName;

    public String toString()
    {
        if (userName == null)
            return inetAddress.getHostAddress() + ":" + portNumber;
        else
            return inetAddress.getHostAddress() + ":" + portNumber + " (" + userName + ")";
    }

    // Constructor

    public Client(InetAddress inetAddress, int portNumber)
    {
        this.inetAddress = inetAddress;
        this.portNumber = portNumber;
    }

    // GETTERS + SETTERS

    InetAddress getInetAddress()
    {
        return inetAddress;
    }

    void setInetAddress(InetAddress inetAddress)
    {
        this.inetAddress = inetAddress;
    }

    int getPortNumber()
    {
        return portNumber;
    }

    void setPortNumber(int portNumber)
    {
        this.portNumber = portNumber;
    }

    String getUserName()
    {
        return userName;
    }

    void setUserName(String userName)
    {
        this.userName = userName;
    }
}
