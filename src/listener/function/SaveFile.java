package listener.function;

import javax.swing.*;

import component.EssentialComponent;

import java.io.*;
import java.util.StringTokenizer;

import imageicon.imageIcon;


public class SaveFile
{
    public static PrintWriter outputStream = null;
    public SaveFile()
    {

    }

    public static void saveFile(String filepath)
    {
        if(filepath != null)
        {
            try
            {
                outputStream = new PrintWriter(new FileOutputStream(filepath));
            }
            catch (FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null,"Error opening the file " + filepath + ".txt.","Wrong", JOptionPane.WARNING_MESSAGE,imageIcon.getImageIcon("../res/image/wrong.png", 32, 32));
                System.exit(0);
            }
            String an = null;
            StringTokenizer str = new StringTokenizer(EssentialComponent.displayarea.getText(), "\n");
            for (;str.hasMoreTokens();)
            {
                an = str.nextToken();
            }
            int line_position =  an.indexOf("|");
            if(line_position>=0)
            {
                outputStream.print(an.substring(0, line_position-2));
            }
            else
            {
                outputStream.print(an);
            }      
            outputStream.close();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"File Path is null!","Wrong", JOptionPane.WARNING_MESSAGE,imageIcon.getImageIcon("../res/image/wrong.png", 32, 32));
        }
    }
}
