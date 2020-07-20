import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class RedCircle extends Application
{
    @Override
    public void start(Stage stage)
    {
        final double WIDTH = 400;
        final double HEIGHT = 400;
        
        // circle starts in centre of screen
        Circle circle = new Circle(WIDTH/2, HEIGHT/2, 20, Color.RED);
                        
        Text heading = new Text(WIDTH/2 - 50, 20, "Click on the red circle");
        Text message = new Text(WIDTH/2 - 40, HEIGHT - 20 , "");
      
        Group root = new Group(heading, circle, message);
        Scene scene = new Scene(root, WIDTH, HEIGHT, Color.YELLOW);    
                
        /* when the mouse is move or dragged the centre of the circle is
           repositioned so that it is always 50 pixels to the left and 
           50 pixels above the cursor */
                
        scene.setOnMouseMoved(e -> {
                                        circle.setCenterX(e.getX()-50);
                                        circle.setCenterY(e.getY()-50);
                                   }
                              );
                 
        scene.setOnMouseDragged(e -> {
                                        circle.setCenterX(e.getX()-50);
                                        circle.setCenterY(e.getY()-50);
                                     }
                                );
        
        // a message is displayed when the mouse button is depressed
        scene.setOnMousePressed(e -> message.setText("Keep trying!!!"));
        
        // the message is blanked when the mouse button is released
        scene.setOnMouseReleased(e -> message.setText(""));
	
        stage.setScene(scene);
        stage.setTitle("Red Circle");
        stage.show();        
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}

