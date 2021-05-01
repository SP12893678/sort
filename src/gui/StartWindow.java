package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.*;

import imageicon.imageIcon;

public class StartWindow {
    
    public static JWindow startWindow = new JWindow();
    public StartWindow() 
    {
        startWindow.setSize(750, 750);
        startWindow.setLayout(null);
        startWindow.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        // Set Background Image
        startWindow.setContentPane(new JLabel(imageIcon.getImageIcon("./res/image/Startup.png", 750, 750)));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        startWindow.setLocation((int) (screenSize.getWidth() / 2) - 750 / 2, (int) (screenSize.getHeight() / 2) - 750 / 2);
        startWindow.pack();
        startWindow.setVisible(true);
        //startWindow.setOpacity(0.05f);
        startWindow.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
        startWindow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseReleased(e);
                startWindow.requestFocus();
            }
        });
    }
    public void closed()
    {
        startWindow.setVisible(false);
        startWindow.requestFocus();
    }
}
