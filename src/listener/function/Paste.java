package listener.function;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import component.EssentialComponent;

public class Paste
{
    static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    static StringSelection data;
    
    public Paste()
    {

    }
    public static void paste()
    {
        Transferable pasteData = clipboard.getContents(clipboard);
 
        if (pasteData != null) 
        {
            try 
            {
                if (pasteData.isDataFlavorSupported(DataFlavor.stringFlavor)) 
                {
                    String data = (String)(pasteData.getTransferData(DataFlavor.stringFlavor));
                    int index_start = EssentialComponent.inputfield.getSelectionStart();
                    int index_end = EssentialComponent.inputfield.getText().length(); 
                    EssentialComponent.inputfield.setText(EssentialComponent.inputfield.getText().substring(0, index_start)+ data + EssentialComponent.inputfield.getText().substring(index_start, index_end));
                }
            } 
            catch (UnsupportedFlavorException e) 
            {
                e.printStackTrace();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
}