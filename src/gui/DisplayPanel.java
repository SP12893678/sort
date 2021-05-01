package gui;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

import java.awt.*;


public class DisplayPanel extends JWindow {

    public static String driver,url,user,password;
    private static final long serialVersionUID = 1000L;
    public static JWindow displayWindow = new JWindow();
    public static JScrollPane listScroll = new JScrollPane();
    public static MyPanel2 trypan = new MyPanel2();
    public DisplayPanel()
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        displayWindow.setSize(800, 200);
        //displayWindow.setContentPane(new JLabel(imageIcon.getImageIcon("../res/image/Startup.png", 750, 750)));
        displayWindow.getContentPane().setPreferredSize(new Dimension(800, 200));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        displayWindow.setLocation((int) (screenSize.getWidth() / 2) - 800 / 2, (int) (screenSize.getHeight() / 2) + 650 / 2 - 100);
        
        JScrollBar vertical = listScroll.getVerticalScrollBar();
        vertical.setPreferredSize(new Dimension(0, 0));
        /*-----------------------------------------------------*/
        //listScroll.setBounds(0, 0, 800, 200);
        listScroll.setViewportView(trypan);
        //listScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        listScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //listScroll.getViewport().setOpaque(false);
        listScroll.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        listScroll.getVerticalScrollBar().setUnitIncrement(10);
        //listScroll.setOpaque(false);
        listScroll.setVerticalScrollBar(vertical);
        listScroll.setBorder(null);
        add(listScroll);
        
        displayWindow.add(listScroll);
        displayWindow.pack();
        displayWindow.setVisible(true);
        DragListener drag = new DragListener();
        displayWindow.addMouseListener(drag);
        displayWindow.addMouseMotionListener(drag);
    }
    public class DragListener extends MouseInputAdapter
    {
        Point location;
        MouseEvent pressed;

        public void mousePressed(MouseEvent me)
        {
            pressed = me;
        }

        public void mouseDragged(MouseEvent me)
        {
            Component component = me.getComponent();
            location = component.getLocation(location);
            int x = location.x - pressed.getX() + me.getX();
            int y = location.y - pressed.getY() + me.getY();
            component.setLocation(x, y);
        }
    }
}
