
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebBrowser extends Application 
{
  @Override
  public void start(Stage stage) 
  {
        // create and configure a WebView node
        WebView wv = new WebView();
        wv.setMaxSize(500, 400);

        // create the text field where the URL will be entered
        TextField entry = new TextField();
        entry.setMaxWidth(500);

        /* define the behaviour that occurs when the URL has been entered and 
           the Enter key has been pressed */
        entry.setOnKeyTyped(e -> { 
                              String url;
                              if(e.getCharacter().equals("\r"))
                              {
                                        url = entry.getText();
                                        if(!url.startsWith("http"))
                                        {
                                            url = "http://" + url;
                                        }
                                        wv.getEngine().load(url);
                         }

                   });

 
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        root.setMaxSize(500,200);
        root.getChildren().addAll(entry, wv);

        Scene scene = new Scene(root, 550, 550);
     
        stage.setScene(scene);
        stage.setTitle("Browser example");
        stage.show();
  }

  public static void main(String[] args) 
  {
        launch(args);
  }
}

