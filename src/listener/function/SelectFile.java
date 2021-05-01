package listener.function;

import javax.swing.*;
import java.io.*;

public class SelectFile
{
    public static String fileop = null;
    public SelectFile()
    {

    }
    public static boolean selectFile()
    {
        fileop = null;
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            fileop = selectedFile.getAbsolutePath();
        }
        if (fileop == null || (fileop != null && ("".equals(fileop)))) 
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public static String getFilePath()
    {
        return fileop;
    }
}
