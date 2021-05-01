package listener.function;

import javax.swing.*;

import gui.MainFrame;

import java.io.*;
import java.util.Properties;
import listener.function.Selectsort;

public class Config
{
    private static Properties props;
    public static boolean hasfilepath = false;
    public Config()
    {

    }
    public static void config(String fileop)
    {
        try
        {
            FileReader file = new FileReader(fileop);
            BufferedReader reader = new BufferedReader(file);
            while (reader.readLine()!=null)
            {
                loadProperties(fileop);
                if(getConfig("ioFilter")!=null)
                    Selectsort.selectsort("ioFilter",getConfig("ioFilter"));
                if(getConfig("order")!=null)
                    Selectsort.selectsort("order",getConfig("order"));
                if(getConfig("algorithm")!=null)
                    Selectsort.selectsort("algorithm",getConfig("algorithm"));
                if(getConfig("filepath")!=null)
                	hasfilepath = true;
            }
            reader.close();
        }
        catch (Exception error)
        {
            MainFrame.wrongSound.playSound();
            JOptionPane.showMessageDialog(null, "File not found", "Wrong", JOptionPane.WARNING_MESSAGE);
        }
    }
    private static void loadProperties(String fileop) 
    {
         props = new Properties();
         try 
         {
              props.load(new FileInputStream(fileop));
         } 
         catch (FileNotFoundException e) 
         {
            MainFrame.wrongSound.playSound();
            JOptionPane.showMessageDialog(null, "File not found", "Wrong", JOptionPane.WARNING_MESSAGE);
         } 
         catch (IOException e) 
         {
            MainFrame.wrongSound.playSound();
            JOptionPane.showMessageDialog(null, "IOException", "Wrong", JOptionPane.WARNING_MESSAGE);
         }
    }
    private static String getConfig(String key) 
    {
        return props.getProperty(key);
    }
    
    public static String getFilePath()
    {
    	return getConfig("filepath");
    }
}
