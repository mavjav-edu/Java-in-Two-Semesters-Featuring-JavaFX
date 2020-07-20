
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;





public class TimeTableQuestion extends Application
{
    public void start(Stage stage)
    {
        Label roomLabel = new Label("Room");
        TextField roomField = new TextField();
        
         Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        
         Label dayLabel = new Label("Day");
         TextField dayField = new TextField();
        
         Label periodLabel = new Label("Period");
         TextField periodField = new TextField();
        
        HBox topRow = new HBox(10);
        topRow.setAlignment(Pos.CENTER);
        topRow.getChildren().addAll(roomLabel, roomField, nameLabel, nameField, dayLabel, dayField, periodLabel, periodField);
        
        Button submit = new Button ("Submit");
        Button delete = new Button ("Delete");
        Button clear = new Button ("Clear");
        
        HBox bottomRow = new HBox(10);
        bottomRow.setAlignment(Pos.CENTER);
        bottomRow.getChildren().addAll(submit, delete, clear);
        
	TitledPane[][] titledPaneArray = new TitledPane[7][5]; 
        VBox[][] box = new VBox[7][5];
	
        for(int i = 0; i <= 6; i++)
        {
            for(int j = 0; j <= 4; j++)
            {
                box[i][j] = new VBox();
                box[i][j].setMinWidth(110);
                box[i][j].setMinHeight(60);
                titledPaneArray[i][j] = new TitledPane("" + (j+1) +"," + (i+1), box[i][j]);
                titledPaneArray[i][j].setCollapsible(false);
            }
        }
        
        Label label1 = new Label("Kans" + "\r" + "EB244");
        Label label2 = new Label("Kans" + "\r" + "EB244");
        Label label3 = new Label("Alexis" + "\r" + "WB205");
        Label label4 = new Label("Alexis" + "\r" + "WB205");
        Label label5 = new Label("Alexis" + "\r" + "WB205");
        Label label6 = new Label("Cobham" + "\r" + "EB146");
        
        box[0][0].getChildren().add(label1);
        box[1][0].getChildren().add(label2);   
        box[2][2].getChildren().add(label3);
        box[3][2].getChildren().add(label4);    
        box[4][2].getChildren().add(label5);
        box[4][4].getChildren().add(label6);     
    
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(1);
        grid.setHgap(1);
        
        for(int i = 0; i <= 6; i++)
        {
            for(int j = 0; j <= 4; j++ )
            {
                grid.add(titledPaneArray[i][j], i, j);
             
            }
        }

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(topRow, bottomRow, grid);
        Scene scene = new Scene(root, 850, 600);
        stage.setScene(scene);
        stage.setTitle("Timetable");
   
        stage.show();     
    }
        
    public static void main(String[] args)
    {
        launch(args);
    }
}
