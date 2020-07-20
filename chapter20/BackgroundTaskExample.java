
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public class BackgroundTaskExample extends Application
{
    @Override
    public void start(final Stage primaryStage)
    {       
        // create and configure a text field for user entry
        TextField pushMeTextField = new TextField();
        pushMeTextField.setMaxWidth(250);
        
        // create and configure a label to display the output
        Label pushMeLabel= new Label();
        pushMeLabel.setTextFill(Color.RED);
        pushMeLabel.setFont(Font.font("Ariel", 14));
        
        // create and configure a label which will cause the text to be displayed
        Button pushMeButton = new Button();
        pushMeButton.setText("Type something in the box then push me");
        pushMeButton.setOnAction(e -> pushMeLabel.setText("You entered: " + pushMeTextField.getText()));
             
        // create and configure a VBox to hold our components       
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        
        //add the components to the VBox
        root.getChildren().addAll(pushMeTextField, pushMeButton, pushMeLabel);
       
        // create a new scene
        Scene scene = new Scene(root, 350, 150);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Background Task Example");
        primaryStage.show();     
        createBackgroundTask(primaryStage);        
    }    


    private void createBackgroundTask(Stage stageIn)
    {
        // create and configure the main circle for the face
        Circle face = new Circle(118, 125, 80); // face
        face.setFill(Color.YELLOW);
        face.setStroke(Color.RED);
        
        // create and configure the circle for the right eye
        Circle rightEye = new Circle(80, 100, 10);
        rightEye.setFill(Color.YELLOW);
        rightEye.setStroke(Color.BLUE);
        
        // create and configure the circle for the left eye
        Circle leftEye = new Circle(156, 100, 10);
        leftEye.setFill(Color.YELLOW);
        leftEye.setStroke(Color.BLUE);
        
        // create and configure a smiling mouth
        Arc mouth = new Arc(118, 150, 45, 35, 0, -180);
        mouth.setFill(Color.YELLOW);
        mouth.setStroke(Color.BLUE);
        mouth.setType(ArcType.OPEN);
        
        // create and configure the text
        Text caption = new Text(60, 240, "Animated Face");
        caption.setFont(Font.font ("Verdana", 15));
        caption.setFill(Color.BLUE);
        
        Group root = new Group(face, rightEye, leftEye, mouth, caption);
        
        Scene scene = new Scene(root, Color.YELLOW);
        
        // create and configure a secondary stage
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.setHeight(300);
        secondaryStage.setWidth(250);
        secondaryStage.setTitle("Animated Face");
        
        // position the secondary stage relative to the primary stage
        secondaryStage.setX(stageIn.getX() + 400);
        secondaryStage.setY(stageIn.getY());
                
        secondaryStage.show();
        
        // create a new thread
        Thread thread1 = new Thread(new FaceTask(mouth, secondaryStage));
        thread1.start();
    }

    public static void main(String[] args)
    {
       launch(args);
    }
}

