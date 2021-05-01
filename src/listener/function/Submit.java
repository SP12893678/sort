package listener.function;

import javax.swing.*;

import component.EssentialComponent;
import imageicon.imageIcon;
import sort.*;
import java.util.*;
import gui.MainFrame;

public class Submit
{
    public static Sorting runSort = null;
    public static List<String> sort_text = null;
    public static boolean is_submit = true;
    public static boolean is_pause = false;
    public static boolean is_interrupt = false;
    public Submit() 
    {
        sort_text = null;
        is_submit = true;
        is_pause = false;
        is_interrupt = false;
    }

    public static void submit() 
    { 
        if(is_submit && !is_interrupt && !is_pause)
        {
            ExecutingStatus();
            sort_text = new ArrayList<String>();
            preSorting.Addn_text(EssentialComponent.inputfield.getText(), sort_text);
            if (preSorting.detect_ioFilter(sort_text))
            {
                MainFrame.submitSound.playSound();
                EssentialComponent.displayarea.setText("");
                runSort = new Sorting(EssentialComponent.inputfield.getText());
            }
            else
            {
                MainFrame.wrongSound.playSound();
                JOptionPane.showMessageDialog(null,"Please input the correct type","Wrong", JOptionPane.WARNING_MESSAGE,imageIcon.getImageIcon("../res/image/wrong.png", 32, 32));   
                NormalStatus();
            }
        }
        else
        {
            if(is_pause && !is_interrupt)
            {
                is_pause = false;
                MainFrame.submitSound.playSound();
                runSort.RunSort(runSort.times);
                runSort.showProcess();
            }
        }
    }

    public static void NormalStatus()
    {
        is_submit = true;
        is_interrupt = false;
        MainFrame.clear.setEnabled(true);
        MainFrame.random.setEnabled(true);
    }
    
    public static void ExecutingStatus()
    {
        is_submit = false;
        MainFrame.clear.setEnabled(false);
        MainFrame.random.setEnabled(false);
    }
}