
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.concurrent.Task;

public class Record extends Application
{
    // declare some constants
    private static final int NUMBER_OF_IMAGES = 8; 
    private static final int SLEEP_TIME = 100; 
        
    private Label label = new Label();

    @Override	              
    public void start (Stage stage)
    {              
        VBox root = new VBox();
        root.setBackground(Background.EMPTY);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(label);

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Record");

        stage.show(); 
        begin(stage);
    }
        
    private void begin(Stage stageIn)  // helper method
    {
        // create an image from a file and add it to a label
        ImageView imageView = new ImageView();
        label.setGraphic(imageView);
  
        Thread thread1 = new Thread(new Task<Void>() // anonymous class
        {
            String imageFileName;
            int currentImage = 1;
            Image image;
        
            @Override
            protected Void call() 
            {
                while(stageIn.isShowing())
                {    
                    // create the name of the next image to be used
                    imageFileName = "record" + currentImage + ".jpg";
                    
                    image = new Image(imageFileName); 
                    imageView.setImage(image);
             
                    try
                    {
                        Thread.sleep(SLEEP_TIME);
                    }
                    catch(InterruptedException e)
                    {
                    }
                                          
                    currentImage++; // next image
                    if(currentImage == NUMBER_OF_IMAGES + 1) 
                    {
                        currentImage = 1;
                    }
                } 
                return null;
            }
        });
        thread1.start();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}

