import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {
    private JButton undo;
    private JButton forward;
    private JButton record;
    private JButton play;
    private CustomListener textListener;

    /**
     * ToolBar constructor initializes and adds buttons, sets a layout
     * sets a border,
     */
    public ToolBar(){
        undo = new JButton("undo");
        forward = new JButton("forward");
        record = new JButton("record");
        play = new JButton("play");

        setLayout(new FlowLayout(FlowLayout.LEFT)); //move all the buttons to the left
        setBorder(BorderFactory.createTitledBorder("Toolbar"));
        setBackground(new Color(40,100,220,120));//sets the background color of the toolbar

        add(undo);
        add(forward);
        add(play);
        add(record);

        undo.addActionListener(this); //respond to an action
        forward.addActionListener(this);
        record.addActionListener(this);
        play.addActionListener(this);

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
            if(textListener != null){
                textListener.emmited("undo\n");
            }
        }
        if(clicked == forward){
            //to be changed for connection
               if(textListener != null){
                   textListener.emmited("forward\n");
            }
        }
        if(clicked == play){
            //to be changed for connection
            if(textListener != null){
                textListener.emmited("play\n");
            }
        }
        if(clicked == record){
            //to be changed for connection
            if(textListener != null){
                textListener.emmited("record\n");
            }
        }
    }
}
