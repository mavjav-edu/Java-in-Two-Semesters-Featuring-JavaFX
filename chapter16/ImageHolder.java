
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;


public class ImageHolder extends Application
{
    @Override
    public void start(Stage stage)
    {
       Image image = new Image("Trees.jpg");  // create an image from a file
       ImageView imageView = new ImageView(image); // wrap the image in an ImageView node
        
       FlowPane root = new FlowPane();
       root.setAlignment(Pos.CENTER);
       root.getChildren().add(imageView); // add the ImageView object to the container
        
       Scene scene = new Scene(root, 400, 600);
       stage.setScene(scene);
       stage.setTitle("Image Example");
   
       stage.show();     
    }
        
    public static void main(String[] args)
    {
        launch(args);
    }
}
   
  
