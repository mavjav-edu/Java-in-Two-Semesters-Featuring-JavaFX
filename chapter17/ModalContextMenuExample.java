import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModalContextMenuExample extends Application
{ 
    @Override
    public void start(Stage primaryStage)
    {
        final double WIDTH = 300;
        final double HEIGHT = 300;
        
        // create a flow pane to be used as the root node
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
     
        // create a button and add it to the flow pane
        Button button = new Button("Select background colour");
        root.getChildren().add(button);
       
        // create buttons for the menu choices
        Button red = new Button(" Red  ");
        Button yellow = new Button("Yellow");
        Button green = new Button(" Green ");
      
        // create a VBox to hold the buttons
        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(red, yellow, green);
        
        // create a secondary scene
        Scene secondaryScene = new Scene(box,200,150);
      
        // create a secondary stage
        Stage secondaryStage = new Stage();
        
        // add the secondary scene to the secondaryary stage
        secondaryStage.setScene(secondaryScene);

        // set the modality of the secondary stage
        secondaryStage.initModality(Modality.APPLICATION_MODAL);
                             
        // code the button so that the secondary stage is made visible
        button.setOnAction(e ->                  
        {              secondaryStage.setX(primaryStage.getX() + 250);
                                secondaryStage.setY(primaryStage.getY() + 100);
                                secondaryStage.show();
                                        });
             
        // code the menu items
        red.setOnAction(e -> {
                                 root.setBackground(new Background(new BackgroundFill(Color.RED,
                                                                CornerRadii.EMPTY, Insets.EMPTY)));
                                 secondaryStage.hide();
                             }     
                        );
    
        yellow.setOnAction(e -> {
                                 root.setBackground(new Background(new BackgroundFill(Color.YELLOW,
                                                                 CornerRadii.EMPTY, Insets.EMPTY)));
                                 secondaryStage.hide();
                                }     
                           );
                
        green.setOnAction(e -> {
                                 root.setBackground(new Background(new BackgroundFill(Color.GREEN,
                                                                 CornerRadii.EMPTY, Insets.EMPTY)));
                                 secondaryStage.hide();
                               }     
                         );
        
        // create the primary scene and stage
        Scene primaryScene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Modal Context Menu");
        primaryStage.show(); 

        }
    
        public static void main(String[] args)
        {
            launch(args);
        }
}

