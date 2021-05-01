package listener.function;


public class Abort{
    
    public Abort() 
    {
        
    }
    public static void interrupt()
    {
        if(!Submit.is_submit)
        {
            Submit.is_interrupt = true;
        }
    }
}