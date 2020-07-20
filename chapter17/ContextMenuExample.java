
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;

public class ContextMenuExample extends Application
{ 
   @Override
   public void start(Stage stage)
   {
     final double WIDTH = 300;
     final double HEIGHT = 300;
        
     // create a flow pane to be used as the root node
     FlowPane root = new FlowPane();
     root.setAlignment(Pos.CENTER);
        
        
     // create a button and add it to the flow pane
     Button button = new Button("Select background colour");
     root.getChildren().add(button);
       
     // create a context menu 
     ContextMenu popup = new ContextMenu(); 
        
     // define the menu items      
     Menu red = new Menu("Red");
     Menu yellow = new Menu("Yellow");
     Menu green = new Menu("Green");
     
     // add the menu items to the context menu
     popup.getItems().addAll(red, yellow, green);
        
     // add the event listeners: the background of the pane is changed and then the menu is closed
     red.setOnAction(e -> {
                                 root.setBackground(new Background(new BackgroundFill(Color.RED,
                                                                 CornerRadii.EMPTY, Insets.EMPTY)));
                                 popup.hide();
                          }     
                    );
    
     yellow.setOnAction(e -> {
                                 root.setBackground(new Background(new BackgroundFill(Color.YELLOW,
                                                                 CornerRadii.EMPTY, Insets.EMPTY)));
                                 popup.hide();
                             }     
                        );
                
     green.setOnAction(e ->  {
                                 root.setBackground(new Background(new BackgroundFill(Color.GREEN,
                                                                 CornerRadii.EMPTY, Insets.EMPTY)));
                                 popup.hide();
                             }     
                        );
        
     // add the event listener to the button: the menu is shown when the button is pressed
     button.setOnAction(e -> popup.show(root, Side.RIGHT, 10, 10));
 
     // configure the scene and the stage
     Scene scene = new Scene(root, WIDTH, HEIGHT);
     stage.setScene(scene);
     stage.setTitle("Context Menu Example");
     stage.show(); 
  }
    
  public static void main(String[] args)
  {
      launch(args);
  }
}

