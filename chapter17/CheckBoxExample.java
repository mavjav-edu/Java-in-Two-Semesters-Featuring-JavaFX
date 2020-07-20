
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxExample extends Application
{ 
    @Override
    public void start(Stage stage)
    {
        final double WIDTH = 400;
        final double HEIGHT = 200;
        
        // create four check boxes
        CheckBox starter = new CheckBox("Starter");
        CheckBox mainCourse = new CheckBox("Main");
        CheckBox dessert = new CheckBox("Dessert");
        CheckBox drink = new CheckBox("Drink");
               
        Button submitButton = new Button("Place your order");  
        Label message = new Label();
            
        // clicking the button
        submitButton.setOnAction(e -> {  
                                        String yourOrder = "Your have ordered: ";
                                            
                                        if(!starter.isSelected()&& !mainCourse.isSelected() 
                                                   && !dessert.isSelected() && !drink.isSelected())
                                        {
                                                yourOrder = "You did not select anything";
                                        }
                                        else
                                        {
                                                if(starter.isSelected())
                                                {
                                                       yourOrder = yourOrder + "     Starter";
                                                }    
                                                if(mainCourse.isSelected())
                                                {  
                                                       yourOrder = yourOrder + "     Main";
                                                }
                                                if(dessert.isSelected()) 
                                                {
                                                       yourOrder = yourOrder + "     Dessert";
                                                }
                                                if(drink.isSelected()) 
                                                {                                                                                                                                                                 
                                                       yourOrder = yourOrder + "     Drink";
                                                }
                                        }
                                             message.setText(yourOrder);   
                                      }
                                 );
                     
        
        VBox root = new VBox(10);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setAlignment(Pos.CENTER_LEFT);
           
        root.getChildren().addAll(starter, mainCourse, dessert, drink, submitButton, message);
            
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        
        stage.setScene(scene);
        stage.setTitle("Check Box Example");
        stage.show(); 
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}

