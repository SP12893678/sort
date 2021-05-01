package listener.function;

import java.awt.Color;

import component.EssentialComponent;


public class Clear
{
    public Clear()
    {

    }
    public static void clear()
    {
        EssentialComponent.save.setEnabled(false);
        EssentialComponent.inputfield.setForeground(Color.BLACK);
        EssentialComponent.inputfield.setText("");
        EssentialComponent.displayarea.setText(""); 
        EssentialComponent.filepath.setText("");
        SelectFile.fileop = null;
    }
}