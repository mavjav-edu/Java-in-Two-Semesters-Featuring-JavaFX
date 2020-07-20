

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class OblongGUI extends Application
{
    // create an object of the Oblong class as an attribute
    private Oblong testOblong = new Oblong(0, 0);
    
    @Override
    public void start(Stage stage)
    {        
        // create and configure text fields for input
        TextField lengthField = new TextField();
        lengthField.setMaxWidth(50);
        
        TextField heightField = new TextField();
        heightField.setMaxWidth(50);
        
        
        // create and configure a non-editable text area to display the results
        TextArea display = new TextArea();
        display.setEditable(false);
        display.setMinSize(210,50);
        display.setMaxSize(210,50);
        
        
        // create and configure Labels for the text fields
        Label lengthLabel = new Label("Length");
        lengthLabel.setTextFill(Color.RED);
        lengthLabel.setFont(Font.font("Arial", 20));
       
        Label heightLabel= new Label("Height");
        heightLabel.setTextFill(Color.RED);
        heightLabel.setFont(Font.font("Arial", 20));
         
       
        // create and configure a button to perform the calculations
        Button calculateButton = new Button();
        calculateButton.setText("Calculate");
        calculateButton.setOnAction( e -> 
                   {   
                       // check that fields are not empty
                       if(lengthField.getText().isEmpty() || heightField.getText().isEmpty())
                       {
                              display.setText("Length and height must be entered");
                       }
                       else
                       {    
                           //convert text input to doubles and set the length and height of the Oblong  
                           testOblong.setLength(Double.parseDouble(lengthField.getText()));
                           testOblong.setHeight(Double.parseDouble(heightField.getText()));
                                 
                           // use the methods of Oblong to calculate the area and perimeter
                           display.setText("The area is: " + testOblong.calculateArea()
                                                                + "\n" + "The perimeter is: " 
                                                                   + testOblong.calculatePerimeter());
                        }                                                          
                   }
                                    );
        
		 // create and configure an HBox for the labels and text inputs                              
        HBox inputComponents = new HBox(10);
        inputComponents.setAlignment(Pos.CENTER);
        inputComponents.getChildren().addAll(lengthLabel, lengthField, heightLabel, heightField);
                 
        // create and configure a vertical container to hold all the components
        VBox root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(inputComponents, calculateButton, display);
           
        // create a new scene and add it to the stage
        Scene scene = new Scene(root, 350, 250);
        stage.setScene(scene);
        stage.setTitle("Oblong GUI");
        stage.show();        
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}

