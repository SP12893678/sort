package listener.function;


public class Pause{
    
    public Pause() 
    {
        
    }
    public static void puase()
    {
        if(!Submit.is_submit)
        {
            Submit.is_pause = true;
        }
    }
}