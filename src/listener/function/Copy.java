package listener.function;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import component.EssentialComponent;

public class Copy
{
    static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    static StringSelection data;
    
    public Copy()
    {

    }
    public static void copy()
    {
        if(EssentialComponent.inputfield.getSelectedText()!=null)
        {
            data = new StringSelection(EssentialComponent.inputfield.getSelectedText());
            clipboard.setContents(data, data);
        }
        else if(EssentialComponent.displayarea.getSelectedText()!=null)
        {
            data = new StringSelection(EssentialComponent.displayarea.getSelectedText());
            clipboard.setContents(data, data);
        }
        else if(EssentialComponent.filepath.getSelectedText()!=null)
        {
            data = new StringSelection(EssentialComponent.filepath.getSelectedText());
            clipboard.setContents(data, data);
        }
    }
}