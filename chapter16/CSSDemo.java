
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CSSDemo extends Application 
{
  @Override
  public void start(final Stage stage) 
  {
      HBox row1 = new HBox();
      HBox row2 = new HBox();
      HBox row3 = new HBox();
 
      Label nameLabel = new Label("Name");
      TextField nameField = new TextField();
      
      Label addressLabel = new Label("Address");
      TextField addressField = new TextField();
      
      Button backButton = new Button("Back");
      Button saveAndContinueButton = new Button("Save and continue");
      Button saveAndQuitButton = new Button("Save and quit");
      Button quitButton = new Button("Quit");
      Button nextButton = new Button("Next");
            
      row1.getChildren().addAll(nameLabel, nameField);
      row2.getChildren().addAll(addressLabel, addressField);
      row3.getChildren().addAll(backButton, saveAndContinueButton, 
                                               saveAndQuitButton, quitButton, nextButton);
      
      VBox root = new VBox();
      root.getChildren().addAll(row1, row2, row3);
      
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Registration Form");
      
    /*
      // For style sheet
      scene.getStylesheets().add("Example.css");
      backButton.getStyleClass().add("button1");
      nextButton.getStyleClass().add("button1");
      row3.setId("row3"); 
      quitButton.setId("quit");

    */    
      
      stage.show();
  }
   
  public static void main(String[] args) 
  {
        launch(args);
  }
 }

