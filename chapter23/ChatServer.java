
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatServer extends Application
{ 
    // declare and initialise the text display area
    private TextArea textWindow = new TextArea();
    

    private OutputStream outStream; // for low level output
    private DataOutputStream outDataStream; // for high level output
 
    private ListenerTask listener; // required for the server thread
  
    private final int port = 8901;
    private String name;

    @Override    
    public void start(Stage stage)
    {  
        getInfo(); // call method that gets user name
        startServerThread();  // start the sever thread
        
        TextField inputWindow = new TextField();

        // configure the behaviour of the input window
        inputWindow.setOnKeyReleased(e -> 
                    {  
                        String text;

                        if(e.getCode().getName().equals("Enter"))  // if the <Enter> key was pressed
                        {
                            text = "<" + name + "> " +  inputWindow.getText() + "\n";
                            textWindow.appendText(text); // echo the text
                            inputWindow.setText(""); // clear the input window

                            try
                            {
                                outDataStream.writeUTF(text); // transmit the text  
                            }

                            catch(IOException ie)
                            {  
                            }
                        }
                    }
                                    );

        // configure the visual components
        textWindow.setEditable(false);
        textWindow.setWrapText(true);
        VBox root = new  VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(textWindow, inputWindow);
        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene); 
        stage.setTitle(name);
        stage.show(); 
   }
   
   private void startServerThread()  
   {
        Socket connection; // declare a "general" socket
        ServerSocket listenSocket; // declare a server socket
                  
        try  
        {
            // create a server socket
	        listenSocket = new ServerSocket(port);  	    
   
            // listen for a connection from the client
            connection = listenSocket.accept();		       

	        // create an output stream to the connection   
	        outStream = connection.getOutputStream ();
	        outDataStream = new DataOutputStream(outStream );

	        // create a thread to listen for messages
           listener = new ListenerTask(textWindow, connection);

           Thread thread = new Thread(listener);
           thread.start(); // start the thread  
       }  
	    catch (IOException e)  
	    {		 
	        textWindow.setText("An error has occured");     	  
	    }        
   }  
   
   // method to get information from user  
   private void getInfo()
   {
        Optional<String> response;
  
       // get user name
       TextInputDialog textDialog = new TextInputDialog();
       textDialog.setHeaderText("Enter user name");
       textDialog.setTitle("Chat Server");
       response = textDialog.showAndWait();
       name =  response.get();
          
       // provide information to the user before starting the server thread
       Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Chat Server");
       alert.setHeaderText
              ("Press OK to start server. The dialogue window will appear when a client connects.");
       alert.showAndWait();
   } 
   
   @Override   
   public void stop()
   {
       System.exit(0); // terminate application when the window is closed
   }
   
   public static void main(String[] args)
   {
       launch(args);
   }
}

