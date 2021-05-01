package listener.function;

import imageicon.imageIcon;
import sort.preSorting;
import gui.DisplayPanel;
import gui.MainFrame;
public class Selectsort 
{   
    public Selectsort()
    {

    }
    public static void selectsort(String sort_type,String selected_item)
    {
        int separator_position = MainFrame.using_type.getText().indexOf("|");
        int separator_position2 = MainFrame.using_type.getText().indexOf("|", separator_position+1);
        switch(sort_type)
        {
            case "ioFilter":
                switch(selected_item)
                {
                    case "Number":
                        MainFrame.number.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                        MainFrame.text.setIcon(null);
                        break;
                    case "Text":
                        MainFrame.text.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                        MainFrame.number.setIcon(null);
                        break;
                    default:
                        break;
                }
                MainFrame.using_type.setText(selected_item + MainFrame.using_type.getText().substring(separator_position-1));
                preSorting.selected_ioFilter_item = selected_item;
                break;
            case "order":
                switch(selected_item)
                    {
                        case "Ascending":
                            MainFrame.ascending.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                            MainFrame.descending.setIcon(null);
                            break;
                        case "Descending":
                            MainFrame.descending.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                            MainFrame.ascending.setIcon(null);
                            break;
                        default:
                            break; 
                    }
                MainFrame.using_type.setText(MainFrame.using_type.getText().substring(0,separator_position+2) + selected_item + MainFrame.using_type.getText().substring(separator_position2-1));
                preSorting.selected_order_item = selected_item;
                break;
            case "algorithm":
                switch(selected_item)
                    {
                        case "Insertion":
                            MainFrame.insertsion.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                            MainFrame.selectsion.setIcon(null);
                            MainFrame.bubble.setIcon(null);
                            MainFrame.merge.setIcon(null);
                            MainFrame.quick.setIcon(null);
                            break;
                        case "Selection":
                            MainFrame.selectsion.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                            MainFrame.insertsion.setIcon(null);
                            MainFrame.bubble.setIcon(null);
                            MainFrame.merge.setIcon(null);
                            MainFrame.quick.setIcon(null);
                            break;
                        case "Bubble":
                            MainFrame.bubble.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                            MainFrame.insertsion.setIcon(null);
                            MainFrame.selectsion.setIcon(null);
                            MainFrame.merge.setIcon(null);
                            MainFrame.quick.setIcon(null);
                            break;
                        case "Merge":
                            MainFrame.merge.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                            MainFrame.insertsion.setIcon(null);
                            MainFrame.selectsion.setIcon(null);
                            MainFrame.bubble.setIcon(null);
                            MainFrame.quick.setIcon(null);
                            break;
                        case "Quick":
                            MainFrame.quick.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                            MainFrame.insertsion.setIcon(null);
                            MainFrame.selectsion.setIcon(null);
                            MainFrame.bubble.setIcon(null);
                            MainFrame.merge.setIcon(null);
                            break;
                        default:
                            break;
                    }
                MainFrame.using_type.setText(MainFrame.using_type.getText().substring(0,separator_position2+2) + selected_item);
                preSorting.selected_algorithm_item = selected_item;
                break;
            case "border":
                switch(selected_item)
                {
                    case "Square":
                        MainFrame.square.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                        MainFrame.circle.setIcon(null);
                        MainFrame.oval.setIcon(null);
                        MainFrame.triangle.setIcon(null);
                        DisplayPanel.trypan.type = "Square";
                        DisplayPanel.trypan.updateUI();
                        break;
                    case "Circle":
                        MainFrame.circle.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                        MainFrame.square.setIcon(null);
                        MainFrame.oval.setIcon(null);
                        MainFrame.triangle.setIcon(null);
                        DisplayPanel.trypan.type = "Circle";
                        DisplayPanel.trypan.updateUI();
                        break;
                    case "Oval":
                    	MainFrame.oval.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                        MainFrame.circle.setIcon(null);
                        MainFrame.square.setIcon(null);
                        MainFrame.triangle.setIcon(null);
                        DisplayPanel.trypan.type = "Oval";
                        DisplayPanel.trypan.updateUI();
                        break;
                    case "Triangle":
                    	MainFrame.triangle.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                        MainFrame.circle.setIcon(null);
                        MainFrame.square.setIcon(null);
                        MainFrame.oval.setIcon(null);
                        DisplayPanel.trypan.type = "Triangle";
                        DisplayPanel.trypan.updateUI();
                        break;
                    default:
                        break;
                }
                break;
            case "move_path":
                switch(selected_item)
                {
                    case "Straight":
                        MainFrame.straight.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                        MainFrame.curve.setIcon(null);
                        break;
                    case "Curve":
                        MainFrame.curve.setIcon(imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
                        MainFrame.straight.setIcon(null);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }
}