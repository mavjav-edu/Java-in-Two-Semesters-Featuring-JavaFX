
import javafx.scene.control.TextArea;
import javafx.concurrent.Task;
import javafx.concurrent.Service;

public class NumbersService extends Service<Void>
{
        private TextArea display;
        private boolean go; 
               
        public  NumbersService (TextArea displayIn)
        {
              display = displayIn;
        }
      
        @Override
        protected Task<Void> createTask() 
        {                                  
              return new Task<Void> ()
              { 
                    @Override
                    protected Void call() throws Exception
                    {
                        go = true;
                        int count = 0;

                        while(go)
                        {
                            display.appendText("" + count);
                                
                            try
                            {
                                Thread.sleep(100); //force the thread to sleep 
                            }
                            catch(InterruptedException e)
                            {
                            } 

                            count++;
                            if(count > 9) // reset the counter 
                            {
                                count = 0;
                                display.appendText("\n");
                            }
                        }
                        return null;
                    };
                };
        }
                 
        public void finish()
        {
               display.appendText("\n");
               go = false;
        }
}
                          

