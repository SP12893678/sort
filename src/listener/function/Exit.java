package listener.function;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;
public class Exit
{
    public Exit() 
    {

    }

    public static void exit(JFrame mainFrame) 
    {
        mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
        mainFrame.requestFocus();
    }
}