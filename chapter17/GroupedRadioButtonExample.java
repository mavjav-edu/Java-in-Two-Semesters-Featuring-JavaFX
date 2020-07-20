
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleGroup;

public class GroupedRadioButtonExample extends Application
{ 
    @Override
    public void start(Stage stage)
    {
        final double WIDTH = 350;
        final double HEIGHT = 200;
        
        // declare the radio buttons
        RadioButton adultSingle = new RadioButton("Adult single");
        RadioButton childSingle = new RadioButton("Child single");
        RadioButton adultReturn = new RadioButton("Adult return");
        RadioButton childReturn = new RadioButton("Child return");
        
        // add the radio buttons to a toggle group
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(adultSingle, childSingle, adultReturn, childReturn);
               
        Button submitButton = new Button("Choose your ticket");
        Label message = new Label();
            
        // clicking the button
        submitButton.setOnAction(e-> {  
                                        String yourOrder = "Your have chosen: ";
                                        if(!adultSingle.isSelected()&& !childSingle.isSelected() 
                                          && !adultReturn.isSelected() && !childReturn.isSelected())
                                        {
                                                 yourOrder = "You did not chose a ticket";
                                        }
                                        else
                                        {
                                                 if(adultSingle.isSelected())
                                                 {
                                                        yourOrder = yourOrder + " Adult Single";
                                                 }    
                                                 else if(childSingle.isSelected())
                                                 {  
                                                        yourOrder = yourOrder + " Child Single";
                                                 }
                                                 else if(adultReturn.isSelected()) 
                                                 {
                                                        yourOrder = yourOrder + " Adult Return";
                                                 }
                                                 else if(childReturn.isSelected()) 
                                                 {                                                                                                                                                                 
                                                        yourOrder = yourOrder + " Child Return";
                                                 }
                                        }
                                        message.setText(yourOrder);   
                                     }
                                );
                     
        
        VBox root = new VBox(10);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().addAll(adultSingle, childSingle, adultReturn, childReturn, 
                                                                     submitButton, message);
                
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Grouped Radio Button Example");
        stage.show(); 
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}

