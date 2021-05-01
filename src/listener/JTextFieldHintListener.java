package listener;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JTextFieldHintListener implements FocusListener 
{
    private String mHintText;
    private JTextField mtextField;

    public JTextFieldHintListener(String hintText, JTextField textField) 
    {
        this.mHintText = hintText;
        this.mtextField = textField;
        mtextField.setText(mHintText);
        textField.setForeground(Color.GRAY);
    }
    @Override
    public void focusGained(FocusEvent e) 
    {
        String temp = mtextField.getText();
        if(temp.equals(mHintText))
        {
            mtextField.setText("");
            mtextField.setForeground(Color.BLACK);
        }
    }
    @Override
    public void focusLost(FocusEvent e)
    {
        String temp = mtextField.getText();
        if(temp.equals(""))
        {
            mtextField.setForeground(Color.GRAY);
            mtextField.setText(mHintText);
        }
    }
}