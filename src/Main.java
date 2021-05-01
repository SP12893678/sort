import javax.swing.UIManager;
import java.lang.Thread;
import gui.*;
public class Main {
    public static void main(String[] args) {
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        // Run Start up Window
        StartWindow startWindow = new StartWindow();
        // Set Main Frame
        MainFrame mainFrame = new MainFrame(800, 450, "Sort Program");  
        mainFrame.Creatobject();
        // Time stop 5s
        try 
        {
            Thread.sleep(5000);
        } catch (InterruptedException ie) 
        {
            ie.printStackTrace();
        }
        // Close Start up Window
        startWindow.closed();
        // Main Frame to run program  
        mainFrame.run();
        DisplayPanel display = new DisplayPanel();
    }
}