package component;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class EssentialComponent {

	public static JTextField inputfield = null;
	public static JTextArea displayarea = null;
	public static JTextComponent filepath = null;
	public static JComponent save = null;
    public static JComponent submit = null;
    public static JComponent interrupt = null;

	public static void setInputField(JTextField text_inputfield)
	{
		inputfield = text_inputfield;
	}

	public static void setDisplayArea(JTextArea sort_displayarea)
	{
		displayarea = sort_displayarea;
	}

	public static void setFilePathField(JTextComponent filepath_showfield)
    {
        filepath = filepath_showfield;
    }

    public static void setSaveItem(JComponent saveItem)
    {
        save = saveItem;
	}
	
	public static void setSubmitItem(JComponent submitItem)
    {
        submit = submitItem;
    }

    public static void setInterruptItem(JComponent interruptItem)
    {
        interrupt = interruptItem;
    }
}
