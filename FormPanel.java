import javax.swing.*;
import java.awt.*;

/**
 * left panel in the main frame and might not be needed
 */
public class FormPanel extends JPanel {

    public FormPanel(){
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
    }
}
