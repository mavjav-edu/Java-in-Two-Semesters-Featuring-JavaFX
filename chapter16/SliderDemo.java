import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SliderDemo extends Application
{
    @Override
    public void start(Stage stage)
    {
        final double horizSliderWidth = 300;
        final double vertSliderHeight = 300;
        
        // numbers will be formatted to one decimal place
        DecimalFormat df = new DecimalFormat("0.0");
        
        // create and configure the vertical slider
        Slider vertSlider = new Slider(0, 20, 0);
        vertSlider.setMinHeight(vertSliderHeight);
        vertSlider.setShowTickMarks(true);
        vertSlider.setShowTickLabels(true);
        vertSlider.setSnapToTicks(true);
        vertSlider.setMajorTickUnit(5.0);
        vertSlider.setMinorTickCount(10);
        vertSlider.setOrientation(Orientation.VERTICAL); // default is horizontal
        
        // create and configure the horizontal slider
        Slider horizSlider = new Slider(0, 10, 0);
        horizSlider.setMinWidth(horizSliderWidth);
        horizSlider.setShowTickMarks(true);
        horizSlider.setShowTickLabels(true);
        horizSlider.setSnapToTicks(true);
        horizSlider.setMajorTickUnit(1.0);
        horizSlider.setMinorTickCount(4);
        
        // create two lables to keep track of each slider position
        Label horizLabel = new Label("Current value is 0.0");
        Label vertLabel = new Label("Current value is 0.0");
      
        // add a listener to the vertical slider
        vertSlider.valueProperty().addListener((observable, oldValue, newValue)  ->                                                       
                                    vertLabel.setText("Current value is " + df.format(newValue)));
                                                           
        // add a listener to the horizonal slider
        horizSlider.valueProperty().addListener((obsValue, oldValue, newValue)  -> 
                                    horizLabel.setText("Current value is " + df.format(newValue)));
        
        // create and configure a VBox to hold the vertical slider and label
        VBox vertBox = new VBox(10);
        vertBox.setAlignment(Pos.BOTTOM_LEFT);
        vertBox.setMinWidth(horizSliderWidth/3);
        vertBox.getChildren().addAll(vertSlider, vertLabel);
        
        // create and configure a VBox to hold the horizontal slider and label        
        VBox horizBox = new VBox(10);
        horizBox.setAlignment(Pos.BOTTOM_LEFT);
        horizBox.getChildren().addAll(horizSlider, horizLabel);
                
        // create and configure an HBox as root
        HBox root = new HBox(30);
        root.setPadding(new Insets(10, 10, 10, 10));        
        root.getChildren().addAll(horizBox, vertBox);
        
        // create and configure the scene and stage
        Scene scene = new Scene(root, 460, 350);     
        stage.setScene(scene);
        stage.setTitle("Slider Example");
        stage.show(); 
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}

