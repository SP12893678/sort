package listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.*;
import java.lang.reflect.*;
import java.lang.*;

public class object_database{
	public JDialog in;
	private JList list;
	private DefaultListModel listModel;
	private String input;
	public ArrayList<Object> object = new ArrayList<Object>();
	JTextArea display_sort = new JTextArea();

	public object_database(JFrame mainFrame,JTextArea display_sort){
		this.display_sort=display_sort;
		CreatDialog(mainFrame);
		object_create();
	}
	public void CreatDialog(JFrame mainFrame){
      in = new JDialog(mainFrame, "object", true);
      in.setVisible(false);
      in.setLayout(null);
      in.setSize(450,450);
      in.setDefaultCloseOperation(in.DISPOSE_ON_CLOSE);
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      in.setLocation((int) (screenSize.getWidth() / 2) - 800 / 2, (int) (screenSize.getHeight() / 2) - 450 / 2);
		}

	public void ShowDialog()
	{
		in.setVisible(true);
	}
		
    public void object_create()
    {
			input = JOptionPane.showInputDialog(null, "Please input Objectname:", "object",JOptionPane.PLAIN_MESSAGE);
			String typename=object_name();
			if(!typename.equals("error"))
			{
				CreatObjectOption(typename);
				ShowDialog();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "This object not found.", "Wrong", JOptionPane.WARNING_MESSAGE);
			}
	}
    
	public void CreatObjectOption(String typename)
    {      
        JScrollPane listScrollPane = new JScrollPane();
        listScrollPane.setBounds(10,40,410,190);
        listModel = new DefaultListModel();
        listModel.addElement("please choose");
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        listScrollPane.setViewportView(list);
        in.add(listScrollPane);

        JButton jbutton1 = new JButton("add");
        jbutton1.setBounds(10,280,100,40);
        jbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e){ 
                String new_input = JOptionPane.showInputDialog(null, typename , "object",JOptionPane.PLAIN_MESSAGE);
								add_object(new_input);
								list_reset(listScrollPane);
            }
        });
        in.add(jbutton1);

        JButton jbutton2 = new JButton("modify");
        jbutton2.setBounds(115,280,100,40);
        jbutton2.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String s = (String) list.getSelectedValue();
                int index = list.getSelectedIndex();
								String modify_input = JOptionPane.showInputDialog(null, s , "object",JOptionPane.PLAIN_MESSAGE);
								set_object(index,modify_input);
                list_reset(listScrollPane);
            }
        });
        in.add(jbutton2);

        JButton jbutton3 = new JButton("delete");
        jbutton3.setBounds(220,280,100,40);
        jbutton3.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String s = (String) list.getSelectedValue();
                int index = list.getSelectedIndex();
                JOptionPane.showConfirmDialog(null,"delete "+s+" ?","delete",JOptionPane.OK_CANCEL_OPTION);
                object.remove(index);
                list_reset(listScrollPane);
            }
        });
        in.add(jbutton3);

        String[] Selectway = { "Ascending", "Descending" };
        JComboBox jcomboboxway = new JComboBox(Selectway);
        jcomboboxway.setBounds(new Rectangle(10,245,180,20));
        in.add(jcomboboxway);
    
        String[] SelecteSort = { "Insertion" , "Selection" , "Bubble" , "Merge" };
        JComboBox jcomboboxsort = new JComboBox(SelecteSort);
        jcomboboxsort.setBounds(new Rectangle(210,245,180,20));
        in.add(jcomboboxsort);

				ArrayList<String> priority = object_tokenizer(object_name());
        String[] priorityarray = priority.toArray(new String[priority.size()]);
        JComboBox jcomboboxpriority = new JComboBox(priorityarray);
        jcomboboxpriority.setBounds(new Rectangle(10,350,180,20));
        in.add(jcomboboxpriority);

        JButton jbutton4 = new JButton("OK");
				jbutton4.setBounds(325,280,100,40);
				jbutton4.addActionListener(new java.awt.event.ActionListener(){
					public void actionPerformed(ActionEvent e) {
						String wayitem = (String)jcomboboxway.getSelectedItem();
						String sortitem = (String)jcomboboxsort.getSelectedItem();
						String priorityitem = (String)jcomboboxpriority.getSelectedItem();
						switch(sortitem){
							case "Insertion":
							ObjectInsertionsort objectinsertionsort = new ObjectInsertionsort(object,priorityitem,display_sort);
									switch(wayitem){
										case "Ascending":
											objectinsertionsort.Insertionsort(0);
											break;
										case "Descending":
											objectinsertionsort.Insertionsort(1);
											break;
										default:
											break;
									}
							/*case "Selection":
									ObjectSelectionsort objectselectionsort = new ObjectSelectionsort(objectdata,priorityitem,display_sort);
									switch(wayitem){
											case "Ascending":
													objectselectionsort.Selectionsort(0);
													break;
											case "Descending":
													objectselectionsort.Selectionsort(1);
													break;
											default:
													break;
									}
							case "Bubble":
									ObjectBubblesort objectbubblesort = new ObjectBubblesort(objectdata,priorityitem,display_sort);
									switch(wayitem){
											case "Ascending":
													objectbubblesort.Bubblesort(0);
													break;
											case "Descending":
													objectbubblesort.Bubblesort(1);
													break;
											default:
													break;
									}*/
							default:
									break;
					}
					try
					{
							in.setVisible(false);
					}
					catch (Exception e1) 
					{
							e1.printStackTrace();
					}
					}
				});
        in.add(jbutton4);

        
		}
		public String object_name(){
			try{
				Object o = Class.forName(input).newInstance();
				Class<?> cc = o.getClass();
				Method mm = cc.getMethod("getname");
				String str = mm.invoke(o).toString();
				return str;
			}catch(Exception error) {
				error.printStackTrace();
				return "error";
			}
		}
		public void add_object(String new_input){
			try{
				Object o = Class.forName(input).newInstance();
				object.add(Class.forName(input).newInstance());
				Class<?> cc = object.get(object.size()-1).getClass();
				Method mm = cc.getMethod("set", String.class);
				mm.invoke(object.get(object.size()-1),new_input);
			}catch(Exception error) {
				error.printStackTrace();
			}
		}
		public void set_object(int index,String new_input){
			try{
				Object o = Class.forName(input).newInstance();
				Class<?> cc = o.getClass();
				Method mm = cc.getMethod("set", String.class);
				mm.invoke(object.get(index),new_input);
			}catch(Exception error) {
				error.printStackTrace();
			}
		}
		public void list_reset(JScrollPane listScrollPane){
			try{
				Object o = Class.forName(input).newInstance();
				Class<?> cc = o.getClass();
				Method mm = cc.getMethod("get");
				listModel.removeAllElements();
				for(int i=0;i<object.size();i++){
					System.out.print(mm.invoke(object.get(i)).toString());
					listModel.addElement(mm.invoke(object.get(i)).toString());
				}
				list.setModel(listModel);
				listScrollPane.setViewportView(list);
			}catch(Exception error) {
				error.printStackTrace();
			}
		}

		public ArrayList<String> object_tokenizer(String temp){
			ArrayList<String> str = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(temp,"{/}");
			while(st.hasMoreTokens()){
					str.add(st.nextToken());
			} 
			return str;
		} 
}