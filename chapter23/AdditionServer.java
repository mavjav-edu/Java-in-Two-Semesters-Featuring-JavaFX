import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AdditionServer
{
    public static void main(String[] args)
    {
        final int port = 8901;

        // declare a "general" socket and a server socket
        Socket connection;
        ServerSocket listenSocket;

        // declare low level and high level objects for input
        InputStream inStream;
        DataInputStream inDataStream;

        // declare low level and high level objects for output
        OutputStream outStream;
        DataOutputStream outDataStream;

        // declare other variables
        String client;
        int first, second, sum;
        boolean connected;
        while(true)
        {
            try
            {
                // create a server socket
                listenSocket = new ServerSocket (port);
                System.out.println("Listening on port " + port);

                // listen for a connection from the client
                connection = listenSocket.accept();
                connected = true;
                System.out.println("Connection established");

                // create an input stream from the client
                inStream = connection.getInputStream();
                inDataStream = new DataInputStream(inStream);

                // create an output stream to the client
                outStream = connection.getOutputStream ();
                outDataStream = new DataOutputStream(outStream);

                // wait for a string from the client
                client = inDataStream.readUTF();
                System.out.println("Address of client: " + client);
                while(connected)
                {
                    // read an integer from the client
                    first = inDataStream.readInt();
                    System.out.println("First number received: " + first);

                    // read an integer from the client
                    second = inDataStream.readInt();
                    System.out.println("Second number received: " + second);

                    sum = first + second;
                    System.out.println("Sum returned: " + sum);

                    // send the sum to the client
                    outDataStream.writeInt(sum);
                }
            }

            catch (IOException e)
            {
               
                connected = false;
                 System.out.println("Client disconnected");
            }
        }     
    }
}

