
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AdditionServerMultiple
{
 
    public static void main(String[] args)
    {    
        final int port = 8901;    
        AdditionServerThread thread;
        Socket socket;
        
        System.out.println("Listening for connections on port: " + port);
        try
        {
            ServerSocket listenSocket = new ServerSocket(port);

            while(true) // continuously listen for connections
            {     
                socket = listenSocket.accept();
                thread = new AdditionServerThread(socket);
                thread.start();
            }
        }
        
        catch(IOException e)
        {       
        }
    }
}
