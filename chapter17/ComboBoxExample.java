
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxExample extends Application
{ 
    @Override
    public void start(Stage stage)
    {
        final double WIDTH = 400;
        final double HEIGHT = 150;
        
        // declare a String type combo box
        ComboBox<String> box = new ComboBox<>();
         
        // add the choices 
        box.getItems().addAll("Small", "Medium", "Large", "Extra large");
         
        // set the intitial text
        box.setValue("Chooose your size");
                                    
        Label message = new Label();
                
        // display the user's choice
        box.setOnAction(e -> message.setText("You have chosen: " + box.getValue()));
        
        VBox root = new VBox(10);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setAlignment(Pos.TOP_CENTER);
            
        root.getChildren().addAll(box, message);
                
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Combo Box Example");
        stage.show(); 
    }
    
    public static void main(String[] args)
    {
            launch(args);
    }
}

