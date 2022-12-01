package frame;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ToolBar extends JPanel implements ActionListener {
    private JButton undo;
    private JButton forward;
    private JButton record;
    private JButton play;

    private CustomListener textListener;
    Dimension d;

    public ToolBar(){
        undo = new JButton("undo");
        forward = new JButton("forward");
        record = new JButton("record");
        play = new JButton("play");
        d = getPreferredSize();
        d.height = 120;
        setPreferredSize(d);

        setLayout(new FlowLayout(FlowLayout.CENTER)); //move all the buttons to the left
        setBorder(BorderFactory.createTitledBorder("KeyPitch"));
        setBackground(new Color(3, 84, 87, 120));

        add(undo);
        add(forward);
        add(play);
        add(record);

        undo.setToolTipText("undo");
        forward.setToolTipText("forward");
        play.setToolTipText("play");
        record.setToolTipText("record");

        play.setIcon(createIcon("/images/icons8-play-button-circled-16.png"));
        record.setIcon(createIcon("/images/icons8-voice-recorder-16.png"));

        undo.setFocusable(false);
        forward.setFocusable(false);
        play.setFocusable(false);
        record.setFocusable(false);

        undo.setFont(new Font("Times New Roman", Font.BOLD, 15));
        forward.setFont(new Font("Times New Roman", Font.BOLD, 15));
        play.setFont(new Font("Times New Roman", Font.BOLD, 15));
        record.setFont(new Font("Times New Roman", Font.BOLD, 15));

        undo.addActionListener(this); //respond to an action
        forward.addActionListener(this);
        record.addActionListener(this);
        play.addActionListener(this);
//        undo.setIcon(new ImageIcon());
    }
    private ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);

        if(url == null){
            System.err.println("Unable to load the image: " + path);
        }
        ImageIcon icon = new ImageIcon(url);
      return icon;
    }

    /**
     * add action listeners to each button
     * @param customListener
     */
    public void setCustomListener(CustomListener customListener){
        this.textListener = customListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if(clicked == undo){
            //to be changed for connection
//            if(textListener != null){
//                textListener.emmited("undo\n");
//            }

        }
        if(clicked == forward){
            //to be changed for connection
//               if(textListener != null){
//                   textListener.emmited("forward\n");
//            }
        }
        if(clicked == play){
            //to be changed for connection
//            if(textListener != null){
//                textListener.emmited("play\n");
//            }
        }
        if(clicked == record){
            //to be changed for connection
//            if(textListener != null){
//                textListener.emmited("record\n");
//            }
        }
    }
}