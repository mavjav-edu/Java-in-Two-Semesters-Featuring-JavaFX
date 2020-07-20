
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdditionClient extends Application
{
       private String remoteHost;
       private  int port;
        
       // declare low level and high level objects for input
       private InputStream inStream;
       private DataInputStream inDataStream;
	
       // declare low level and high level objects for output
       private  OutputStream outStream ;
       private DataOutputStream outDataStream;
       
       // declare a socket
       private Socket connection;
       
       @Override
       public void start(Stage stage)
       { 
            getInfo(); // call the method that gets the information about the server 
          
            // declare visual components 
       	  TextField msg = new TextField();
                     
            TextField firstNumber = new TextField();
            Label plus = new Label("+");
            TextField secondNumber = new TextField();
 
            Label equals = new Label("=");
            Label sum = new Label();

            Button calculateButton = new Button("Press to see the sum of the two numbers");
	
            // configure the scene
            msg.setMaxWidth(150);
            firstNumber.setMaxWidth(30);	       
            secondNumber.setMaxWidth(30);
                    
            HBox hBox = new HBox(10);
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(firstNumber, plus, secondNumber, equals, sum);
            VBox root = new VBox(10);
            
            root.setAlignment(Pos.CENTER);
            root.getChildren().addAll(hBox, msg,  calculateButton);

            Scene scene = new Scene(root, 400, 300);
            stage.setScene(scene); 
            stage.setTitle("Addition Client");
           
            // show the stage       
            stage.show(); 
               
            try
            {
                 // attempt to create a connection to the server
                 connection = new Socket(remoteHost, port);
                 msg.setText("Connection established");
			
                 // create an input stream from the server
                 inStream = connection.getInputStream();
                 inDataStream = new DataInputStream(inStream);
		
                 // create an output stream to the server
                 outStream = connection.getOutputStream();
                 outDataStream = new DataOutputStream(outStream);
		
                 // send the host IP to the server
                 outDataStream.writeUTF(connection.getLocalAddress().getHostAddress());
            }

            catch (UnknownHostException e)
            {
	            msg.setText("Unknown host");
            }
            
            catch (IOException ie)
            {
			      msg.setText("Network Exception");
            }

            // specifiy the behaviour of the calculate button
            calculateButton.setOnAction(e ->                        
                         { 
                            try
                            {
                                 // send the two integers to the server 
                                 outDataStream.writeInt(Integer.parseInt(firstNumber.getText()));
                                 outDataStream.writeInt(Integer.parseInt(secondNumber.getText()));

                                 // read and display the result sent back from the server
                                 int result = inDataStream.readInt();
                                 sum.setText("" + result);                                
                             }
                             catch(IOException ie)
                             {                                  
                             }
                          }
                                         );

        }
	     
        private void getInfo()
        {
              Optional<String> response;
              
              // use the TextInputDialog class to allow the user to enter the host address
              TextInputDialog addressDialog = new TextInputDialog();
              addressDialog.setHeaderText("Enter remote host");
              addressDialog.setTitle("Addition Client");
        
              response = addressDialog.showAndWait();
              remoteHost = response.get(); 
             
              // use the TextInputDialog class to allow the user to enter port number
              TextInputDialog portDialog = new TextInputDialog();
              portDialog.setHeaderText("Enter port number");
              portDialog.setTitle("Addition Client");
   
              response = portDialog.showAndWait();
              port = Integer.valueOf(response.get()); 
        }
		
	     public static void main(String[] args)
        {          
                  launch(args);
        }		
}

