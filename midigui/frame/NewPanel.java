package frame;

import javax.swing.*;
import java.awt.*;

public class NewPanel extends JPanel {
    public NewPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 20;
        setPreferredSize(dim);

        setLayout(new FlowLayout(FlowLayout.LEADING));
        setBorder(BorderFactory.createTitledBorder(""));
        setBackground(new Color(84, 134, 126, 182));
    }
}
