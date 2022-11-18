import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MidiPanel extends JPanel implements ActionListener {
   // private JTextArea textArea;
    public MidiPanel(){
     //   textArea = new JTextArea();
        setLayout(new BorderLayout());
//        Dimension dim = getPreferredSize();
//        dim.width = 250;
//        setPreferredSize(dim);

  //      add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

//    public void appendText(String s){
//        textArea.append(s);
//        }


}
