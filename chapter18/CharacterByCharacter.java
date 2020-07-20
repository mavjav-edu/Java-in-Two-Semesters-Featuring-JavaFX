
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CharacterByCharacter extends Application
{
    private Label viewArea = new Label();
    
    @Override
    public void start(Stage stage)
    {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(viewArea);
        Scene scene = new Scene(root, 400, 100);
        stage.setScene(scene);
        stage.setTitle("Character By Character");
        stage.show();     
        
        readAndWrite();
    }
    
    private void readAndWrite()
    {        
	  // use try-with-resources to ensure file is closed safely
        try(
		FileReader testFile = new FileReader("Poem.txt");
		BufferedReader textStream = new BufferedReader(testFile);
            )
        {
              String str = new String();                   
              final int MAX = 1000;
                                
              int ch; // to hold the integer (Unicode) value of the character
              char c; // to hold the character when type cast from integer
              int counter = 0; // to count the number of characters read so far
              ch = textStream.read(); // read the first character from the file
              c = (char) ch; // type cast from integer to character
              /* continue through the file until either the end of the file is 
              reached (in which case -1 is returned) or the maximum number of 
              characters stipulated have been read */
              while( ch != -1 && counter <= MAX)
              {
                    counter++; // increment the counter
                    str = str + c;
                    ch = textStream.read(); // read the next character
                    c = (char) ch;                         
              }
			
              str = str + "\n";
              viewArea.setText(str);  
	}
		
	catch(IOException ioe)
	{
	    viewArea.setText("There was a problem reading the file\n");
	}
    }

    public static void main(String[] args)
    {
              launch(args);
    }

}

