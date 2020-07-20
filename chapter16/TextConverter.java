
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TextConverter extends Application
{
    @Override
    public void start(Stage stage)
    {
        // create and configure a text field for user entry
        TextField textField = new TextField();
        textField.setMaxWidth(250);
        
        // create and configure a label to display the output
        Label label= new Label();
        label.setTextFill(Color.RED);
        label.setFont(Font.font("Ariel", 20));
        
        // display the contents of textField in upper case
        textField.setOnKeyReleased(e -> label.setText(textField.getText().toUpperCase()));
             
        // create and configure a VBox to hold the components       
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        
        //add the components to the VBox
        root.getChildren().addAll(textField, label);
       
  
        // create a new scene
        Scene scene = new Scene(root);
        
        //add the scene to the stage, then configure the stage and make it visible
        stage.setScene(scene);
        stage.setTitle("Text Converter");
        stage.setHeight(150);
        stage.setWidth(350);
        stage.show();        
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}

