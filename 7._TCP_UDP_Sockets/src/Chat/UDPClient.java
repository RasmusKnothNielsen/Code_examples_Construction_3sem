/*
Computer Science, KEA, Denmark.
3. Semester, Fall 2019.
Mandatory Assignment in Tech2.
Read Network_Assignment2.pdf for more information

@Author: Rasmus Knoth Nielsen.
 */

package Chat;

/* TODO User should be prompted for his/hers username instead of using JOIN:
Furthermore, no need for MESSAGE: since every message after ones name, is a message.
 */

import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient
{

    public static void main(String args[]) throws Exception
    {

        properStartUp();

        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter the IP address of the server: ");
        String host = userInput.nextLine();
        System.out.print("\nPlease enter the port number of the server: ");
        int serverPort = userInput.nextInt();

        // Get the IP address of the local machine - we will use this as the address to send the data to
        InetAddress ia = InetAddress.getByName(host);

        SenderThread senderThread = new SenderThread( ia, serverPort);
        senderThread.start();
        ReceiverThread receiverThread = new ReceiverThread(senderThread.getSocket());
        receiverThread.start();

/*
        System.out.println("\nIf you have provided the right credentials, " +
                "you can how send messages to a chat server located at: \n"
                + "Host: " + host + ", Port: " + serverPort + "\n");

        System.out.println("If it is supported by the server, type COMMANDS to get a list of commands");

 */

    }

    public static void properStartUp()
    {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("X                 K.I.C                   X");
        System.out.println("X       WELCOME TO KNOTH INC CHAT         X");
        System.out.println("X                 V.0.1                   X");
        System.out.println("X      Author: Rasmus Knoth Nielsen       X");
        System.out.println("X                                         X");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println();
    }
}