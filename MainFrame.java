import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * the MainFrame class adds all the components to the frame window to customize the gui
 */
public class MainFrame  extends JFrame {
    private ToolBar toolBar;//create a toolbar
    private MidiPanel midiPanel; //adds strings to the text panel when buttons are clicked
    private FormPanel formPanel;//to delete
    private JFileChooser fileChooser;//to import/export file into the application dialog window

//    private MidiGraphics graphics;

    /**
     * MainFrame constructor
     * initializes a layout, a toolbar, a textPanel
     */
    public MainFrame(){
        super("MIDI");

       setLayout(new BorderLayout());//set layout design BorderLayout

        midiPanel = new MidiPanel();
        formPanel = new FormPanel();
        toolBar= new ToolBar(); //setting up a toolbar on top of the application
        fileChooser = new JFileChooser();//setting up a window frame for open and export file
        fileChooser.addChoosableFileFilter(new WAVFileFilter());

        /*
        add a listener interface
        change the component when connecting
         */
       toolBar.setCustomListener(new CustomListener() {
           @Override
           public void emmited(String text) {
 //              System.out.println(text);
 //              textPanel.appendText(text);
           }
       });

 //       add(textPanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH); //add a toolbar at the top of the screen
        add(midiPanel, BorderLayout.CENTER);

        setJMenuBar(createMenuBar());

        setMinimumSize(new Dimension(700, 500));//prevent the user from making the window frame too small
        setSize(1200, 800);//sets the size of the application frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close application
        setVisible(true); //set visibility
    }

    /**
     * creates a File and Settings menu bar
     * @return
     */
    private JMenuBar createMenuBar(){
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu settings = new JMenu("Settings");

    JMenuItem openFile = new JMenuItem("Open...");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem exportFile = new JMenuItem("Export File");
    JMenuItem exit = new JMenuItem("Exit");

    fileMenu.add(openFile);
    fileMenu.add(save);
    fileMenu.add(exportFile);
    fileMenu.addSeparator();// adds a separator
    fileMenu.add(exit);

    menuBar.add(fileMenu);
    menuBar.add(settings);

        //sets keyboard keys to Alt + F will open the file menu
        fileMenu.setMnemonic(KeyEvent.VK_F);


        // sets keyboard keys to Alt + F
        // then Alt + X will activate exit field of the file menu
        exit.setMnemonic(KeyEvent.VK_X);
        //adds an action
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(MainFrame.this, "Would you like to exit the application?",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
                if(option == JOptionPane.OK_OPTION) {
                    System.exit(0);}
            }
        });

        //adds an accelerator CTRL + X to exit the application
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

       //////////////////////////////////////////////////////////////////////////////////////
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        //adds an accelerator CTRL + O to open a file
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        ///////////////////////////////////////////////////////////////////////////////////////
        exportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        //adds an accelerator CTRL + E to open a file
        exportFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        ////////////////////////////////////////////////////////////////////////////////////////////
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainFrame.this, "File Saved");
            }
        });

        //adds an accelerator CTRL + S to save a file
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));



        return menuBar;
    }

}
