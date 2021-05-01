package listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import gui.DisplayPanel;
import gui.MainFrame;
import listener.function.*;
import component.EssentialComponent;
import datainput.*;

public class ListenerSystem implements ActionListener{

    JFrame mainFrame = new JFrame();
    String type,item_name,sort_type;
    public ListenerSystem(String type) 
    {
        this.type = type;
    }
    public ListenerSystem(String type,String sort_type,String item_name) 
    {
        this.type = type;
        this.sort_type = sort_type;
        this.item_name = item_name;
    }
    public ListenerSystem(String type,JFrame mainFrame) 
    {
        this.type = type;
        this.mainFrame = mainFrame;
    }
    public void actionPerformed(ActionEvent e) 
    {
        switch(type)
        {
            case "open":
                if(SelectFile.selectFile())
                {
                	Textfileinput input = new Textfileinput(SelectFile.getFilePath(),EssentialComponent.inputfield);
                	input.dataInput();
                    if(input.is_success() && input.is_setInputField())
                		EssentialComponent.inputfield.setForeground(Color.black);
                }
                break;
            case "config":
                if(SelectFile.selectFile())
                    Config.config(SelectFile.getFilePath());
                if(Config.hasfilepath)
                {
                	Textfileinput input = new Textfileinput(Config.getFilePath(),EssentialComponent.inputfield);
                	input.dataInput();
                    if(input.is_success() && input.is_setInputField())
                		EssentialComponent.inputfield.setForeground(Color.black);
                }
                break;
            case "save":
                SaveFile.saveFile(SelectFile.getFilePath());
                break;
            case "saveAs":
                SaveAsFile.saveAsFile();
                break;
            case "exit":
                Exit.exit(mainFrame);
                break;
            case "redo":
                Redo.redo();
                break; 
            case "undo":
                Redo.redo();
                break;
            case "copy":
                Copy.copy();
                break; 
            case "cut":
                Cut.cut();
                break;
            case "paste":
                Paste.paste();
                break;
            case "select":
                Selectsort.selectsort(sort_type,item_name);
                break;
            case "object":
                object_database newobject = new object_database(mainFrame, EssentialComponent.displayarea);
                break;
            case "clear":
                Clear.clear();
                MainFrame.slide_down.setVisible(false);
                MainFrame.slide_down_bg.setVisible(false);
                break;
            case "random":
            	RandomInput random = new RandomInput(EssentialComponent.inputfield);
            	random.dataInput();
            	if(random.is_success() && random.is_setInputField())
            		EssentialComponent.inputfield.setForeground(Color.black);
            	DisplayPanel.trypan.setData(random.getData());
            	DisplayPanel.trypan.hasData = true;
            	DisplayPanel.trypan.updateUI();
                break;
            case "obtain":
            	DatabaseGet database = new DatabaseGet("./res/database/database.xls",EssentialComponent.inputfield);
            	database.dataInput();
            	if(database.is_success() && database.is_setInputField())
            		EssentialComponent.inputfield.setForeground(Color.black);
                break;
            case "submit":
                Submit.submit();
                break;
            case "abort":
                Abort.interrupt();
                break;
            case "pause":
                Pause.puase();
                break;
            case "skip":
                Skip.skip();
                break;
            default:
                break;
        }
    }
}