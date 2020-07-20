
import javafx.concurrent.Task;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;

public class FaceTask extends Task<Void>
{
    private Arc arc;
    private Stage stage;
    
    public FaceTask(Arc arcIn, Stage stageIn)
    {
        arc = arcIn;
        stage = stageIn;
    }
    
    @Override
    protected Void call()
    {
        while(stage.isShowing())
        {
               arc.setLength(-180); // smiling mouth
               try
               {
                     Thread.sleep(1000); //force the thread to sleep for 1 second
               }
               catch(InterruptedException e)
               {
               } 

               arc.setLength(180);  // frowning mouth
                  
               try
               {
                    Thread.sleep(1000); //force the thread to sleep for 1 second
               }
               catch(InterruptedException e)
               {
               }    
        }
        return null;
   }
}
 
