
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class DisplayNumbersInTextAreaUsingService extends Application 
{
    @Override
    public void start(final Stage stage)
    {
        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        TextArea displayArea = new TextArea();
        displayArea.setMaxSize(100, 100);
        displayArea.setEditable(false);
        
      
        NumbersService service = new NumbersService(displayArea);
         
         
        startButton.setOnAction(e ->
                    { 
                       Thread thread1 = new Thread(service.createTask());
                       thread1.start();                
                    }
                                );
        
        stopButton.setOnAction(e -> service.finish());                                 
               
                
        HBox root = new HBox(10); 
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(startButton, stopButton, displayArea);
        
        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene); 
        stage.show();         
    }      
    
     
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
         
