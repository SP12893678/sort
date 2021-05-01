package listener.function;
import java.lang.Thread;
import component.EssentialComponent;

public class Redo
{
    public static String previousInput = null;
    public static String nowInput = EssentialComponent.inputfield.getText();
    public static String tmp;
    public static boolean redo = false;
    public Redo()
    {

    }
    public static void redo()
    {
        if(previousInput!=null)
        {
            redo = true;
            tmp = nowInput;
            EssentialComponent.inputfield.setText(previousInput);
            try 
            {
                Thread.sleep(100);
            } 
            catch (InterruptedException ie) 
            {
                ie.printStackTrace();
            }
            nowInput = EssentialComponent.inputfield.getText();
            previousInput = tmp;
            redo = false;
        }  
    }
}