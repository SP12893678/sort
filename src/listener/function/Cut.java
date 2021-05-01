package listener.function;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import component.EssentialComponent;

public class Cut
{
    static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    static StringSelection data;
    
    public Cut()
    {

    }
    public static void cut()
    {
        if(EssentialComponent.inputfield.getSelectedText()!=null)
        {
            data = new StringSelection(EssentialComponent.inputfield.getSelectedText());
            clipboard.setContents(data, data);
            EssentialComponent.inputfield.setText(EssentialComponent.inputfield.getText().replace(EssentialComponent.inputfield.getSelectedText(),""));
        }
    }
}