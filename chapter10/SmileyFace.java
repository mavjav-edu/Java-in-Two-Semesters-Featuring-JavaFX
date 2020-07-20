import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SmileyFace extends Application
{
    @Override
    public void start(Stage stage)
    {
        // create and configure the main circle for the face
        Circle face = new Circle(125, 125, 80); 
        face.setFill(Color.YELLOW);
        face.setStroke(Color.RED);
        
        // create and configure the circle for the right eye
        Circle rightEye = new Circle(86, 100, 10);
        rightEye.setFill(Color.YELLOW);
        rightEye.setStroke(Color.BLUE);
        
        // create and configure the circle for the left eye
        Circle leftEye = new Circle(162, 100, 10);
        leftEye.setFill(Color.YELLOW);
        leftEye.setStroke(Color.BLUE);
        
        // create and configure a smiling mouth
        Arc mouth = new Arc(125, 150, 45, 35, 0, -180); 
        mouth.setFill(Color.YELLOW);
        mouth.setStroke(Color.BLUE);
        mouth.setType(ArcType.OPEN);
        
        // create and configure the text
        Text caption = new Text(80, 240, "Smiley Face");
        caption.setFill(Color.BLUE);
        caption.setFont(Font.font("Verdana", 15));
        
      
        // create a group that holds all the features            
        Group root = new Group(face, rightEye, leftEye, mouth, caption);
 
        // create and configure a new scene
        Scene scene = new Scene(root, 250, 275, Color.YELLOW);

        // add the scene to the stage, then set the title
        stage.setScene(scene);
        stage.setTitle("Smiley Face");

        // show the stage
        stage.show();        
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}

