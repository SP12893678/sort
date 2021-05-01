package listener.function;
import java.lang.Thread;
public class Skip{
    
    public Skip() 
    {
        
    }
    public static void skip()
    {
        if(!Submit.is_submit)
        {
            Pause.puase();
            try 
            {
                Thread.sleep(1500);
            } catch (InterruptedException ie) 
            {
                ie.printStackTrace();
            }
            Submit.runSort.skip();
        }
    }
}