package listener.function;

import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;

import component.EssentialComponent;
import gui.MainFrame;
import imageicon.imageIcon;

public class SaveAsFile
{
    PrintWriter outputStream = null;
    String filerename = null;
    public SaveAsFile()
    {

    }

    public static void saveAsFile()
    {
        String an = null;
        StringTokenizer str = new StringTokenizer(EssentialComponent.displayarea.getText(), "\n");
        for (; str.hasMoreTokens();)
        {
            an = str.nextToken();
        }
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("/home/me/Documents"));
        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) 
        {
            try 
            {
                FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
                int line_position =  an.indexOf("|");
                if(line_position>=0)
                {
                    fw.write(an.substring(0, line_position-2));
                }
                else
                {
                    fw.write(an);
                }
                fw.close();
            } 
            catch (Exception ex) 
            {
                MainFrame.wrongSound.playSound();
                JOptionPane.showMessageDialog(null,"Wrong","Wrong", JOptionPane.WARNING_MESSAGE,imageIcon.getImageIcon("../res/image/wrong.png", 32, 32));
            }
        }
    }
}
