package gui;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.DefaultCaret;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import imageicon.imageIcon;
import listener.*;
import listener.function.Redo;
import component.EssentialComponent;
import sound.Sound;;


public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1000L;
    public static Object lock = new Object();
    private Thread mainThread = new Thread();
    /*-------------------------------------------------------------------------------------*/
    public Sound BackgroundMusic = new Sound("./res/music/background.mp3",true,0.5);
    public static Sound submitSound = new Sound("./res/music/start.mp3",false,0.5);
    public static Sound finishSound = new Sound("./res/music/finish.mp3",false,0.5);
    public static Sound wrongSound = new Sound("./res/music/wrong.mp3",false,0.5);
    public JMenuBar menubar = new JMenuBar();
    public JMenu filemenu = new JMenu("File");
    public JMenuItem openfile = new JMenuItem("Open file", imageIcon.getImageIcon("./res/image/open.png", 16, 16));
    public JMenuItem config_file = new JMenuItem("Config file", imageIcon.getImageIcon("./res/image/version.png", 16, 16));
    public static JMenuItem savefile = new JMenuItem("Save file", imageIcon.getImageIcon("./res/image/save.png", 16, 16));
    public JMenuItem saveAsfile = new JMenuItem("Save As...", imageIcon.getImageIcon("./res/image/saveas.png", 16, 16));
    public JMenuItem exit = new JMenuItem("Exit", imageIcon.getImageIcon("./res/image/exit.png", 16, 16));
    public JMenu editmenu = new JMenu("Edit");
    public static JMenuItem redo = new JMenuItem("Redo", imageIcon.getImageIcon("./res/image/redo.png", 16, 16));
    public static JMenuItem undo = new JMenuItem("Undo", imageIcon.getImageIcon("./res/image/undo.png", 16, 16));
    public static JMenuItem copy = new JMenuItem("Copy", imageIcon.getImageIcon("./res/image/copy.png", 16, 16));
    public static JMenuItem cut = new JMenuItem("Cut", imageIcon.getImageIcon("./res/image/cut.png", 16, 16));
    public static JMenuItem paste = new JMenuItem("Paste", imageIcon.getImageIcon("./res/image/paste.png", 16, 16));
    public JMenu optionmenu = new JMenu("Option");
    public JMenu ioFilter = new JMenu("IO filter");
    public static JMenuItem number = new JMenuItem("Number", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem text = new JMenuItem("Text", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem object = new JMenuItem("Object", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public JMenu order = new JMenu("Order");
    public static JMenuItem ascending = new JMenuItem("Ascending", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem descending = new JMenuItem("Descending", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public JMenu algorithm = new JMenu("Algorithm");
    public static JMenuItem insertsion = new JMenuItem("Insertion", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem selectsion = new JMenuItem("Selection", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem bubble = new JMenuItem("Bubble", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem merge = new JMenuItem("Merge", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem quick = new JMenuItem("Quick", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public JMenu outline_border = new JMenu("Outline Border");
    public static JMenuItem square = new JMenuItem("Square", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem circle = new JMenuItem("Circle", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem oval = new JMenuItem("Oval", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem triangle = new JMenuItem("Triangle", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public JMenu move_path = new JMenu("Move Path");
    public static JMenuItem straight = new JMenuItem("Straight", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem curve = new JMenuItem("Curve", imageIcon.getImageIcon("./res/image/checked.png", 16, 16));
    public static JMenuItem random = new JMenuItem("Random generation", imageIcon.getImageIcon("./res/image/random.png", 16, 16));
    public static JMenuItem clear = new JMenuItem("Clear the input", imageIcon.getImageIcon("./res/image/reset.png", 16, 16));
    public JMenu databasemenu = new JMenu("Database");
    public JMenuItem newdatabase = new JMenuItem("New", imageIcon.getImageIcon("./res/image/new.png", 16, 16));
    public JMenuItem deletedatabase = new JMenuItem("Delete", imageIcon.getImageIcon("./res/image/delete.png", 16, 16));
    public JMenuItem modifydatabase = new JMenuItem("Modify", imageIcon.getImageIcon("./res/image/modify.png", 16, 16));
    public JMenuItem obtaindatabase = new JMenuItem("Obtain", imageIcon.getImageIcon("./res/image/obtain.png", 16, 16));
    public static JButton submit_button = new JButton();
    public static JButton abort_button = new JButton();
    public static JButton pause_button = new JButton();
    public static JButton skip_button = new JButton();
    public JLabel input_bg = new JLabel();
    public static JTextField manual_input = new JTextField();
    public static JTextArea display_sort = new JTextArea();
    public JScrollPane scroll = new JScrollPane(display_sort);
    public static JLabel slide_down = new JLabel();
    public static JLabel slide_down_bg = new JLabel();
    public JLabel output_bg = new JLabel();
    public JTextArea filePathTitle = new JTextArea();
    public static JTextArea filePath = new JTextArea();
    public static JLabel using_type = new JLabel();
    public JLabel information_bar_bg = new JLabel();
    /*-------------------------------------------------------------------------------------*/
    /**
     * MainFrame Constructor
     * 
     * @param width  frame width
     * @param height frame height
     * @param title  frame title
     */
    public MainFrame(int width, int height, String title) {
        super(title);
        synchronized (lock) 
        {
            setVisible(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setFocusable(true);
            // Set ScreenSize
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation((int) (screenSize.getWidth() / 2) - width / 2, (int) (screenSize.getHeight() / 2) - height / 2);
            setSize(width, height);
            // Set the main frame layout
            setLayout(null);
            addListener();
        }
    }
    public void Setmenu(JMenu menu, int dimension_x) 
    {
        menu.setPreferredSize(new Dimension(dimension_x, 20));
        menu.setMargin(new Insets(0, 3, 0, 3));
        menu.setFont(new Font("SansSerif", Font.PLAIN, 16));
    }

    public void Setmenuitem(JMenuItem menuItem, int dimension_x) 
    {
        menuItem.setPreferredSize(new Dimension(dimension_x, 25));
        menuItem.setHorizontalTextPosition(SwingConstants.RIGHT);
    }

    public void ConnectComponent() 
    {
        EssentialComponent.setInputField(manual_input);
        EssentialComponent.setDisplayArea(display_sort);
        EssentialComponent.setFilePathField(filePath);
        EssentialComponent.setSaveItem(savefile);
        EssentialComponent.setSubmitItem(submit_button);
        EssentialComponent.setInterruptItem(abort_button);
    }
    public void Creatobject()
    {
        // Run Background Music
        BackgroundMusic.playSound();
        // Set Background Image
         try 
         {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./res/image/Background.png"))
                    .getScaledInstance(800, 450, BufferedImage.SCALE_SMOOTH))));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        // Set Frame icon
        setIconImage(Toolkit.getDefaultToolkit().getImage("./res/image/icon.png"));

        //Set BasicObject
        ConnectComponent();

        // Set Menubar
        menubar.setBackground(Color.WHITE);
        setJMenuBar(menubar);

        // Set File Menu
        Setmenu(filemenu,42);
        menubar.add(filemenu);

        // Set Open file MenuItem in File Menu
        Setmenuitem(openfile,225);
        openfile.addActionListener(new ListenerSystem("open"));
        openfile.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK));
        filemenu.add(openfile);

        // Set Config file MenuItem in File Menu
        Setmenuitem(config_file,225);
        config_file.addActionListener(new ListenerSystem("config"));
        config_file.setAccelerator(KeyStroke.getKeyStroke('C', KeyEvent.CTRL_MASK));
        filemenu.add(config_file);

        // Separator
        filemenu.addSeparator();
        // Separator
        
        // Save file MenuItem in File Menu
        Setmenuitem(savefile,225);
        savefile.addActionListener(new ListenerSystem("save"));
        savefile.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
        savefile.setEnabled(false);
        filemenu.add(savefile);

        // Save As... MenuItem in File Menu
        Setmenuitem(saveAsfile,225);
        saveAsfile.addActionListener(new ListenerSystem("saveAs"));
        saveAsfile.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK | KeyEvent.SHIFT_MASK));
        filemenu.add(saveAsfile);

        // Separator
        filemenu.addSeparator();
        // Separator

        // Exit MenuItem in File Menu
        Setmenuitem(exit,225);
        exit.addActionListener(new ListenerSystem("exit",this));
        filemenu.add(exit);

        // Set Edit Menu
        Setmenu(editmenu,45);
        menubar.add(editmenu);

        // Redo MenuItem in Edit Menu
        Setmenuitem(redo,125);
        redo.addActionListener(new ListenerSystem("redo"));
        editmenu.add(redo);

        // Undo MenuItem in Edit Menu
        Setmenuitem(undo,125);
        undo.addActionListener(new ListenerSystem("undo"));
        editmenu.add(undo);

        // Separator
        editmenu.addSeparator();
        // Separator

        // Copy MenuItem in Edit Menu
        Setmenuitem(copy,125);
        copy.addActionListener(new ListenerSystem("copy"));
        editmenu.add(copy);

        // Cut MenuItem in Edit Menu
        Setmenuitem(cut,125);
        cut.addActionListener(new ListenerSystem("cut"));
        editmenu.add(cut);

        // Paste MenuItem in Edit Menu
        Setmenuitem(paste,125);
        paste.addActionListener(new ListenerSystem("paste"));
        editmenu.add(paste);

        // Set Option Menu
        Setmenu(optionmenu,60);
        menubar.add(optionmenu);

        // IO filter Menu in Option Menu
        ioFilter.setPreferredSize(new Dimension(200, 25));
        ioFilter.setHorizontalTextPosition(SwingConstants.RIGHT);
        optionmenu.add(ioFilter);

        // Number Menu in IO filter Menu
        Setmenuitem(number, 125);
        number.addActionListener(new ListenerSystem("select","ioFilter","Number"));
        ioFilter.add(number);

        // Text Menu in IO filter Menu
        Setmenuitem(text, 125);
        text.addActionListener(new ListenerSystem("select","ioFilter","Text"));
        text.setIcon(null);
        ioFilter.add(text);

        Setmenuitem(object, 125);
        object.addActionListener(new ListenerSystem("object",this));
        object.setIcon(null);
        ioFilter.add(object);

        // Order Menu in Option Menu
        order.setPreferredSize(new Dimension(200, 25));
        order.setHorizontalTextPosition(SwingConstants.RIGHT);
        optionmenu.add(order);
        
        // Ascending Menu in Order Menu
        Setmenuitem(ascending, 125);
        ascending.addActionListener(new ListenerSystem("select","order","Ascending"));
        order.add(ascending);

        // Descending Menu in Order Menu
        Setmenuitem(descending, 125);
        descending.addActionListener(new ListenerSystem("select","order","Descending"));
        descending.setIcon(null);
        order.add(descending);

        // Algorithm Menu in Option Menu
        algorithm.setPreferredSize(new Dimension(200, 25));
        algorithm.setHorizontalTextPosition(SwingConstants.RIGHT);
        optionmenu.add(algorithm);

        // Insertsion sort Menu in Algorithm Menu
        Setmenuitem(insertsion, 125);
        insertsion.addActionListener(new ListenerSystem("select","algorithm","Insertion"));
        algorithm.add(insertsion);

        // Selectsion sort Menu in Algorithm Menu
        Setmenuitem(selectsion, 125);
        selectsion.addActionListener(new ListenerSystem("select","algorithm","Selection"));
        selectsion.setIcon(null);
        algorithm.add(selectsion);

        // Bubble sort Menu in Algorithm Menu
        Setmenuitem(bubble, 125);
        bubble.addActionListener(new ListenerSystem("select","algorithm","Bubble"));
        bubble.setIcon(null);
        algorithm.add(bubble);

        // Merge sort Menu in Algorithm Menu
        Setmenuitem(merge, 125);
        merge.addActionListener(new ListenerSystem("select","algorithm","Merge"));
        merge.setIcon(null);
        //merge.setEnabled(false);
        algorithm.add(merge);

        // Quick sort Menu in Algorithm Menu
        Setmenuitem(quick, 125);
        quick.addActionListener(new ListenerSystem("select","algorithm","Quick"));
        quick.setIcon(null);
        //quick.setEnabled(false);
        algorithm.add(quick);
        
        // Separator
        optionmenu.addSeparator();
        // Separator

     // Outline Border Menu in Option Menu
        outline_border.setPreferredSize(new Dimension(200, 25));
        outline_border.setHorizontalTextPosition(SwingConstants.RIGHT);
        optionmenu.add(outline_border);

        // Square Menuitem in Outline Border Menu
        Setmenuitem(square, 125);
        square.addActionListener(new ListenerSystem("select","border","Square"));
        outline_border.add(square);

        // Circle Menuitem in Outline Border Menu
        Setmenuitem(circle, 125);
        circle.addActionListener(new ListenerSystem("select","border","Circle"));
        circle.setIcon(null);
        outline_border.add(circle);
        
        // Oval Menuitem in Outline Border Menu
        Setmenuitem(oval, 125);
        oval.addActionListener(new ListenerSystem("select","border","Oval"));
        oval.setIcon(null);
        outline_border.add(oval);
        
        // Triangle Menuitem in Outline Border Menu
        Setmenuitem(triangle, 125);
        triangle.addActionListener(new ListenerSystem("select","border","Triangle"));
        triangle.setIcon(null);
        outline_border.add(triangle);

        // Move Path Menu in Option Menu
        move_path.setPreferredSize(new Dimension(200, 25));
        move_path.setHorizontalTextPosition(SwingConstants.RIGHT);
        optionmenu.add(move_path);

        // Straight Menuitem in Outline Border Menu
        Setmenuitem(straight, 125);
        straight.addActionListener(new ListenerSystem("select","move_path","Straight"));
        move_path.add(straight);

        // Curve Menuitem in Outline Border Menu
        Setmenuitem(curve, 125);
        curve.addActionListener(new ListenerSystem("select","move_path","Curve"));
        curve.setIcon(null);
        move_path.add(curve);

        // Separator
        optionmenu.addSeparator();
        // Separator
        
        
        // Random the text to input MenuItem in Option Menu
        Setmenuitem(random, 200);
        random.addActionListener(new ListenerSystem("random"));
        optionmenu.add(random);

        // Clear the input MenuItem in Option Menu
        Setmenuitem(clear, 200);
        clear.addActionListener(new ListenerSystem("clear"));
        optionmenu.add(clear);

        // Set Database Menu
        Setmenu(databasemenu,80);
        menubar.add(databasemenu);

        // Set New Database MenuItem in Database Menu
        Setmenuitem(newdatabase, 125);
        newdatabase.setEnabled(false);
        databasemenu.add(newdatabase);

        // Set Delete Database MenuItem in Database Menu
        Setmenuitem(deletedatabase, 125);
        deletedatabase.setEnabled(false);
        databasemenu.add(deletedatabase);

        // Set Modify Database MenuItem in Database Menu
        Setmenuitem(modifydatabase, 125);
        modifydatabase.setEnabled(false);
        databasemenu.add(modifydatabase);

        // Set Obtain Database MenuItem in Database Menu
        Setmenuitem(obtaindatabase, 125);
        obtaindatabase.addActionListener(new ListenerSystem("obtain"));
        databasemenu.add(obtaindatabase);

        /* Set the Input Field */
        manual_input.addFocusListener(
                new JTextFieldHintListener("Please input the data that you need to arrange", manual_input));
        manual_input.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
        manual_input.setOpaque(false);
        manual_input.setBorder(BorderFactory.createLineBorder(Color.white));
        manual_input.setBounds(55, 65, 600, 25);
        manual_input.addCaretListener(new CaretListener() 
        {
            public void caretUpdate(CaretEvent e) 
            {
                if(Redo.nowInput!=null && Redo.nowInput!="" && !Redo.redo)
                {
                    Redo.previousInput = Redo.nowInput;
                    Redo.nowInput = manual_input.getText();
                }
            }
        });
        add(manual_input);

        /* Set the Input Field Background */
        input_bg.setIcon(imageIcon.getImageIcon("./res/image/input_data_bar.png", 650, 45));
        input_bg.setBounds(30, 55, 700, 45);
        add(input_bg);

        /* Set Button for submit the text */
        submit_button.setContentAreaFilled(false);
        submit_button.setBorderPainted(false);
        submit_button.setToolTipText("Pressing the button will perform the sort");
        submit_button.setIcon(imageIcon.getImageIcon("./res/image/submit.png", 40, 40));
        submit_button.setPressedIcon(imageIcon.getImageIcon("./res/image/submit_action.png", 40, 40));
        submit_button.addActionListener(new ListenerSystem("submit"));
        submit_button.setBounds(690, 98, 40, 40);
        mousemotion(submit_button,"submit");
        add(submit_button);

        /* Set Button for submit the text */
        abort_button.setContentAreaFilled(false);
        abort_button.setBorderPainted(false);
        abort_button.setToolTipText("Pressing the button will Interrupt the sort");
        abort_button.setIcon(imageIcon.getImageIcon("./res/image/stop.png", 40, 40));
        abort_button.setPressedIcon(imageIcon.getImageIcon("./res/image/stop_action.png", 40, 40));
        abort_button.addActionListener(new ListenerSystem("abort"));
        abort_button.setBounds(730, 98, 40, 40);
        mousemotion(abort_button,"stop");
        add(abort_button);

        pause_button.setContentAreaFilled(false);
        pause_button.setBorderPainted(false);
        pause_button.setToolTipText("Pressing the button will Pause the sort");
        pause_button.setIcon(imageIcon.getImageIcon("./res/image/pause.png", 40, 40));
        pause_button.setPressedIcon(imageIcon.getImageIcon("./res/image/pause_action.png", 40, 40));
        pause_button.addActionListener(new ListenerSystem("pause"));
        pause_button.setBounds(690, 58, 40, 40);
        mousemotion(pause_button,"pause");
        add(pause_button);

        skip_button.setContentAreaFilled(false);
        skip_button.setBorderPainted(false);
        skip_button.setToolTipText("Pressing the button will Skip the sort");
        skip_button.setIcon(imageIcon.getImageIcon("./res/image/skip.png", 40, 40));
        skip_button.setPressedIcon(imageIcon.getImageIcon("./res/image/skip_action.png", 40, 40));
        skip_button.addActionListener(new ListenerSystem("skip"));
        skip_button.setBounds(730, 58, 40, 40);
        mousemotion(skip_button,"skip");
        add(skip_button);

        /* Set the Display Sort Area */
        display_sort.setText("This area will display the sort process.");
        display_sort.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
        Color display = new Color(245, 245, 245);
        display_sort.setForeground(display);
        display_sort.setEditable(false);
        display_sort.setLineWrap(true);
        display_sort.setWrapStyleWord(true);
        display_sort.setOpaque(false);
        //display_sort.setBounds(97, 161, 588, 150);
        UIManager.put("ScrollBar.thumb", new ColorUIResource(new Color(255, 145, 162)));
        UIManager.put("ScrollBar.track", new ColorUIResource(new Color(245, 189, 198))); 
        UIManager.put("ScrollBar.width", 17);
        DefaultCaret caret = (DefaultCaret)display_sort.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
        scroll.setBounds(62, 159, 605, 150);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
        add(scroll);

        /* Set the Display Sort Process Background */
        output_bg.setIcon(imageIcon.getImageIcon("./res/image/display_process_bg.png", 660, 200));
        output_bg.setBounds(22, 135, 660, 200);
        add(output_bg);

        /* Set the Slide Down GIF */
        Image slide_image = new ImageIcon("./res/image/slide_down3.gif").getImage();
        ImageIcon slide_icon = new ImageIcon(slide_image);
        slide_down.setIcon(slide_icon);
        slide_down.setBounds(705, 200, 50, 72);
        slide_down.setVisible(false);
        add(slide_down);
        
        /* Set the Slide Down Background */
        slide_down_bg.setIcon(imageIcon.getImageIcon("./res/image/slide_bg.png", 50, 72));
        slide_down_bg.setBounds(705, 200, 50, 72);
        slide_down_bg.setVisible(false);
        add(slide_down_bg);

        /* Set file Path Title */
        filePathTitle.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
        filePathTitle.setText(" File Path:");
        filePathTitle.setToolTipText("Your file's location");
        filePathTitle.setForeground(Color.BLACK);
        filePathTitle.setEditable(false);
        filePathTitle.setLineWrap(true);
        filePathTitle.setWrapStyleWord(true);
        filePathTitle.setOpaque(false);
        filePathTitle.setBounds(0, 376, 55, 17);
        add(filePathTitle);

        /* Set file Path */
        filePath.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
        filePath.setForeground(Color.BLACK);
        filePath.setEditable(false);
        filePath.setLineWrap(true);
        filePath.setWrapStyleWord(true);
        filePath.setOpaque(false);
        filePath.setBounds(55, 376, 520, 17);
        add(filePath);

        /* Set Using Type */
        using_type.setText("Number | Ascending | Insertsion");
        using_type.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
        using_type.setHorizontalAlignment(SwingConstants.RIGHT);
        using_type.setToolTipText("Your using type");
        using_type.setOpaque(false);
        using_type.setBounds(575, 377, 210, 17);
        add(using_type);

        /* Set Information bar */
        information_bar_bg.setIcon(imageIcon.getImageIcon("./res/image/filepathbar.png", 804, 17));
        information_bar_bg.setBounds(0, 376, 804, 17);
        add(information_bar_bg);
        
    }

    public void mousemotion(JButton Icon_button,String pic)
    {
        Icon_button.addMouseListener(new MouseAdapter() 
        {   
            public void mouseExited(MouseEvent e) 
            {    
                Icon_button.setIcon(imageIcon.getImageIcon("./res/image/"+pic+".png", 40, 40));
            }
            public void mouseEntered(MouseEvent e) 
            {
                Icon_button.setIcon(imageIcon.getImageIcon("./res/image/"+pic+"_action.png", 40, 40));
            }
        });
    }
    public void run() {
        synchronized (lock) {
            lock.notify();
            setVisible(true);
            setAlwaysOnTop(true);
            setAlwaysOnTop(false);
            mainThread.start();
        }
    }
    private void addListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseReleased(e);
                MainFrame.this.requestFocus();
            }
        });
    }
}


