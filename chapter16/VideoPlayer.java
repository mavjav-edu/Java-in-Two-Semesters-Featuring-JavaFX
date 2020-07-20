
import java.io.File;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class VideoPlayer extends Application
{
    @Override
    public void start(Stage stage)
    {
        // create a File object from the video file
        File file = new File("Trees.mp4");

        // create a Media object from the File Object
        Media media = new Media(file.toURI().toString()); 
       
        // create a MediaPlayer object from the Media Object
        MediaPlayer mp = new MediaPlayer(media);
        
        // create a MediaView object from the MediaPlayer Object
        MediaView mv = new MediaView(mp);

        // create the buttons
        Button playFromStartButton = new Button("Play from start");
        Button pauseButton = new Button("Pause");
        Button resumeButton = new Button("Resume");

        // create and configure an HBox to hold the buttons
        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(playFromStartButton, pauseButton, resumeButton);
           
        // add event handlers to the buttons
        playFromStartButton.setOnAction(e -> {   
                                        mp.seek(Duration.millis(0)); 
                                        mp.play();
                                       }
                                  );
           
        pauseButton.setOnAction(e -> mp.pause());
                             
        resumeButton.setOnAction(e-> mp.play());
          
        // create the root container, and add it to the scene and stage
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(mv, buttonBox);

        
        Scene scene = new Scene(root,800,500);
        stage.setScene(scene);
        stage.setTitle("Video Example");
  
        stage.show();   
                
    }
    
        public static void main(String[] args)
    {
        launch(args);
    }
    
}
