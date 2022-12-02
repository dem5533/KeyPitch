package midi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KeyClickListener extends MouseAdapter {

    private MidiPanel midiPanel;

    public KeyClickListener(MidiPanel midiPanel) {
        this.midiPanel = midiPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println(e.getX() + " " + e.getY());

    }

    public int getXCoordinate(MouseEvent e){
        return e.getX();
    }

    public int getYCoordinate(MouseEvent e){
        return e.getX();
    }
}
