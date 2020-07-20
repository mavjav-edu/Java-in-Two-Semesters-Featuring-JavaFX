import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClient extends Application
{
    // declare and initialize the text display area
    private TextArea textWindow = new TextArea();
   
      
    private OutputStream outStream; // for low level output
    private DataOutputStream outDataStream; // for high level output
   
    private ListenerTask listener; // required for the cleint thread
   
    private int port; // to hold the port number of the server
    private  String remoteMachine; // to hold the name chosen by the user
   
    private String name;
  

    @Override
    public void start(Stage stage)   
    {
        getInfo(); // call method that gets user name and server details
        startClientThread(); // start the client thread
            
        TextField inputWindow = new TextField();  
        // configure the behaviour of the input window
        inputWindow.setOnKeyReleased(e -> 
                    {  
                        String text; 

                        if(e.getCode().getName().equals("Enter"))   // if the <Enter> key was pressed
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
        textWindow.setWrapText(true);
        textWindow.setEditable(false); 
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(textWindow, inputWindow);
        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene); 
        stage.setTitle(name);
        stage.show(); 
               

    }
   
    private void startClientThread()  
    {   
        Socket connection;  // declare a "general" socket
        
        try
        {
            // create a connection to the server
            connection = new Socket (remoteMachine, port); 
           
     	    // create output stream to the connection   
	    outStream = connection.getOutputStream();
	    outDataStream = new DataOutputStream (outStream);      	
         	
            // create a thread to listen for messages
            listener = new ListenerTask(textWindow, connection);
            Thread thread = new Thread(listener);
            thread.start(); // start the thread
	}  

        catch(UnknownHostException e)
        {	
            textWindow.setText("Unknown host");
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
     
    // get address of host 
    TextInputDialog textDialog1 = new TextInputDialog();
    textDialog1.setHeaderText("Enter remote host");
    textDialog1.setTitle("Chat Client");
    response = textDialog1.showAndWait();
    remoteMachine = response.get(); 
                 
    // get port number            
    TextInputDialog textDialog2 = new TextInputDialog();
    textDialog2.setHeaderText("Enter port number");
    textDialog2.setTitle("Chat Client");
    response = textDialog2.showAndWait(); 
    port = Integer.valueOf(response.get());
       
    // get user name
    TextInputDialog textDialog3 = new TextInputDialog();
    textDialog3.setHeaderText("Enter user name");
    textDialog3.setTitle("Chat Client");
    response = textDialog3.showAndWait();
    name =  response.get();
      
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

