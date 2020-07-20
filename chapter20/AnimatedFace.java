
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.Group;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;

public class AnimatedFace extends Application
{
    @Override
    public void start(final Stage stage)
    {
        Circle face = new Circle(118, 125, 80);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.RED);
        
        Circle rightEye = new Circle(80, 100, 10);
        rightEye.setFill(Color.YELLOW);
        rightEye.setStroke(Color.BLUE);
        
        Circle leftEye = new Circle(156, 100, 10);
        leftEye.setFill(Color.YELLOW);
        leftEye.setStroke(Color.BLUE);
        
        Arc mouth = new Arc(118, 150, 45, 35, 0, -180);
        mouth.setFill(Color.YELLOW);
        mouth.setStroke(Color.BLUE);
        mouth.setType(ArcType.OPEN);
        
        Text caption = new Text(60, 240, "Animated Face");
        caption.setFont(Font.font ("Verdana", 15));
        caption.setFill(Color.BLUE);
        
        Group root = new Group(face, rightEye, leftEye, mouth, caption);
        
        Scene scene = new Scene(root, Color.YELLOW);
       
        stage.setScene(scene);
        stage.setHeight(300);
        stage.setWidth(250);
        stage.setTitle("Animated Face");
        stage.show();     
       
       Thread thread1 = new Thread(new FaceTask(mouth, stage));
       thread1.start();
    }    
    
    public static void main(String[] args)
    {
       launch(args);
    }
    
}

