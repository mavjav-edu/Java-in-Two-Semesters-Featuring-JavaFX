
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TextRepeater extends Application
{
    @Override
    public void start(Stage stage)
    {
        // create and configure a text field for user entry
        TextField textfield = new TextField();
        textfield.setMaxWidth(250);
        
        // create and configure a label to display the output
        Label repeatLabel= new Label();
        repeatLabel.setTextFill(Color.RED);
        repeatLabel.setFont(Font.font("Ariel", 20));
        

        textfield.setOnKeyTyped(e ->                 
                       {  
                             if(e.getCharacter().equals("\r")) // check for the Enter key
                             {                                          
                                  repeatLabel.setText("You typed: " + textfield.getText());
                                  textfield.setText("");
                             }
                             else
                             {
                                  repeatLabel.setText("Last character typed: " + e.getCharacter());
                             }
                       });
             
        // create and configure a VBox to hold our components       
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        
        //add the components to the VBox
        root.getChildren().addAll(textfield, repeatLabel);
       
  
        // create a new scene
        Scene scene = new Scene(root);
        
        //add the scene to the stage, then configure the stage and make it visible
        stage.setScene(scene);
        stage.setTitle("Text Repeater");
        stage.setHeight(150);
        stage.setWidth(350);
        stage.show();        
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}

