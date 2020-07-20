import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DialogDemo extends Application
{
    private String name;
    private String colour;
    
    @Override
    public void start(Stage stage)
    {
        name = getUserName(); // get the user name by calling a text input dialog
 
        Label label1 = new Label();
        Label label2 = new Label();
        Button button1 = new Button ("Alert");
        Button button2 = new Button ("Choice");
        
        button1.setOnAction(e -> showAlert()); // show an alert 
             
        // call a choice dialog
        button2.setOnAction(e -> 
                                 {
                                    colour = showChoice();
                                    label2.setText("You chose " + colour);
                                 }
                            );
                  
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label1, button1, button2, label2);
        label1.setFont(Font.font("Ariel", 20));
        label2.setFont(Font.font("Ariel", 20));
        label1.setText("Hello " + name);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Demo");
        stage.setWidth(250);
        stage.setHeight(250);
        stage.show(); 
    }

    
    private String getUserName()
    {        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Enter your name");
        dialog.setTitle("Text Input Dialog");
          
        Optional<String> response = dialog.showAndWait(); 
        return response.get(); 
    }

    
    private void showAlert()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Information Alert");
        alert.setContentText(name + " is a cool name");
        alert.showAndWait();
    }
    
    private String showChoice()
    {
        ChoiceDialog<String> choice = new ChoiceDialog<>("Red", "Yellow", "Blue");
        choice.setContentText("Choose colour");
        choice.setHeaderText("Choice dialog");

        Optional<String> response = choice.showAndWait();
        return response.get();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

} 

