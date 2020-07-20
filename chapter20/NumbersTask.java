
import javafx.scene.control.TextArea;
import javafx.concurrent.Task;

public class NumbersTask extends Task<Void>
{
    private boolean go; 
    private TextArea display;
                
    public  NumbersTask(TextArea displayIn)
    {
        display = displayIn;
    }
        
    @Override
    protected Void call() 
    {
        go = true;
        int count = 0;

        while(go)
        {
            display.appendText("" + count);
            try
            {
                Thread.sleep(100); //force the thread to sleep for 100 milliseconds
            }
            catch(InterruptedException e)
            {
            }
                      
            count++;
            if(count > 9) // reset the counter if it has gone over 9
            {
                count = 0;
                display.appendText("\n"); // start a new line
            }
        }
        return null;
    }
                       
     public void finish()
     {
        go = false;    
     }  
}

