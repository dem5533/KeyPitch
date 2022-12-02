package midi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

public class MidiGraphics extends JComponent implements MouseListener {
    private final int Y = 140;
    private final int WK_WIDTH = 20;
    private final int WK_HEIGHT = 135;
    private final int WK_ARCH = 7;
    private final int BK_WIDTH = 12;
    private final int BK_HEIGHT = 90;
    private final int BK_ARCH = 5;


    private RoundRectangle2D mrb = new RoundRectangle2D.Double(90, 80, 580, 210, 14,14);
    private RoundRectangle2D wk1 = new RoundRectangle2D.Double(100, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk2 = new RoundRectangle2D.Double(120, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk3 = new RoundRectangle2D.Double(140, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk4 = new RoundRectangle2D.Double(160, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk5 = new RoundRectangle2D.Double(180, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk6 = new RoundRectangle2D.Double(200, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk7 = new RoundRectangle2D.Double(220, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk8 = new RoundRectangle2D.Double(240, Y,WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk9 = new RoundRectangle2D.Double(260, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk10 = new RoundRectangle2D.Double(280, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk11 = new RoundRectangle2D.Double(300, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk12 = new RoundRectangle2D.Double(320, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk13 = new RoundRectangle2D.Double(340, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk14 = new RoundRectangle2D.Double(360, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk15 = new RoundRectangle2D.Double(380, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk16 = new RoundRectangle2D.Double(400, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk17 = new RoundRectangle2D.Double(420, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk18 = new RoundRectangle2D.Double(440, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk19 = new RoundRectangle2D.Double(460, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk20 = new RoundRectangle2D.Double(480, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk21 = new RoundRectangle2D.Double(500, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk22 = new RoundRectangle2D.Double(520, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk23 = new RoundRectangle2D.Double(540, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk24 = new RoundRectangle2D.Double(560, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk25 = new RoundRectangle2D.Double(580, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk26 = new RoundRectangle2D.Double(600, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk27 = new RoundRectangle2D.Double(620, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
    private RoundRectangle2D wk28 = new RoundRectangle2D.Double(640, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);

    private RoundRectangle2D bk1 = new RoundRectangle2D.Double(115, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk2 = new RoundRectangle2D.Double(135, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk3 = new RoundRectangle2D.Double(175, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk4 = new RoundRectangle2D.Double(195, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk5 = new RoundRectangle2D.Double(215, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk6 = new RoundRectangle2D.Double(255, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk7 = new RoundRectangle2D.Double(275, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk8 = new RoundRectangle2D.Double(315, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk9 = new RoundRectangle2D.Double(335, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk10 = new RoundRectangle2D.Double(355, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk11 = new RoundRectangle2D.Double(395, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk12 = new RoundRectangle2D.Double(415, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk13 = new RoundRectangle2D.Double(455, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk14 = new RoundRectangle2D.Double(475, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk15 = new RoundRectangle2D.Double(495, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk16 = new RoundRectangle2D.Double(535, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk17 = new RoundRectangle2D.Double(555, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk18 = new RoundRectangle2D.Double(595, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk19 = new RoundRectangle2D.Double(615, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
    private RoundRectangle2D bk20 = new RoundRectangle2D.Double(635, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //paint the background
        g2.setColor(new Color(142, 194, 194));
        g2.fillRect(0,0,getWidth(),getHeight());

        g2.setColor(new Color(42, 39, 39, 174));
        g2.fill(mrb);
        g2.setColor(Color.black);
        g2.draw(mrb);

        paintWhiteKeys(g2);
        paintBlackKeys(g2);
    }

    private void paintBlackKeys(Graphics2D g2){
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk1);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk2);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk3);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk4);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk5);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk6);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk7);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk8);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk9);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk10);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk11);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk12);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk13);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk14);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk15);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk16);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk17);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk18);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk19);
        g2.setColor(new Color(5, 9, 26, 255));
        g2.fill(bk20);
    }

    private void paintWhiteKeys(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.fill(wk1);
        g2.setColor(Color.BLACK);
        g2.draw(wk1);
        g2.setColor(Color.WHITE);
        g2.fill(wk2);
        g2.setColor(Color.BLACK);
        g2.draw(wk2);
        g2.setColor(Color.WHITE);
        g2.fill(wk3);
        g2.setColor(Color.BLACK);
        g2.draw(wk3);
        g2.setColor(Color.WHITE);
        g2.fill(wk4);
        g2.setColor(Color.BLACK);
        g2.draw(wk4);
        g2.setColor(Color.WHITE);
        g2.fill(wk5);
        g2.setColor(Color.BLACK);
        g2.draw(wk5);
        g2.setColor(Color.WHITE);
        g2.fill(wk6);
        g2.setColor(Color.BLACK);
        g2.draw(wk6);
        g2.setColor(Color.WHITE);
        g2.fill(wk7);
        g2.setColor(Color.BLACK);
        g2.draw(wk7);

        g2.setColor(Color.WHITE);
        g2.fill(wk8);
        g2.setColor(Color.BLACK);
        g2.draw(wk8);
        g2.setColor(Color.WHITE);
        g2.fill(wk9);
        g2.setColor(Color.BLACK);
        g2.draw(wk9);
        g2.setColor(Color.WHITE);
        g2.fill(wk10);
        g2.setColor(Color.BLACK);
        g2.draw(wk10);
        g2.setColor(Color.WHITE);
        g2.fill(wk11);
        g2.setColor(Color.BLACK);
        g2.draw(wk11);
        g2.setColor(Color.WHITE);
        g2.fill(wk12);
        g2.setColor(Color.BLACK);
        g2.draw(wk12);
        g2.setColor(Color.WHITE);
        g2.fill(wk13);
        g2.setColor(Color.BLACK);
        g2.draw(wk13);
        g2.setColor(Color.WHITE);
        g2.fill(wk14);
        g2.setColor(Color.BLACK);
        g2.draw(wk14);
        g2.setColor(Color.WHITE);
        g2.fill(wk15);
        g2.setColor(Color.BLACK);
        g2.draw(wk15);
        g2.setColor(Color.WHITE);
        g2.fill(wk16);
        g2.setColor(Color.BLACK);
        g2.draw(wk16);
        g2.setColor(Color.WHITE);
        g2.fill(wk17);
        g2.setColor(Color.BLACK);
        g2.draw(wk17);
        g2.setColor(Color.WHITE);
        g2.fill(wk18);
        g2.setColor(Color.BLACK);
        g2.draw(wk18);
        g2.setColor(Color.WHITE);
        g2.fill(wk19);
        g2.setColor(Color.BLACK);
        g2.draw(wk19);
        g2.setColor(Color.WHITE);
        g2.fill(wk20);
        g2.setColor(Color.BLACK);
        g2.draw(wk20);
        g2.setColor(Color.WHITE);
        g2.fill(wk21);
        g2.setColor(Color.BLACK);
        g2.draw(wk21);
        g2.setColor(Color.WHITE);
        g2.fill(wk22);
        g2.setColor(Color.BLACK);
        g2.draw(wk22);
        g2.setColor(Color.WHITE);
        g2.fill(wk23);
        g2.setColor(Color.BLACK);
        g2.draw(wk23);
        g2.setColor(Color.WHITE);
        g2.fill(wk24);
        g2.setColor(Color.BLACK);
        g2.draw(wk24);
        g2.setColor(Color.WHITE);
        g2.fill(wk25);
        g2.setColor(Color.BLACK);
        g2.draw(wk25);
        g2.setColor(Color.WHITE);
        g2.fill(wk26);
        g2.setColor(Color.BLACK);
        g2.draw(wk26);
        g2.setColor(Color.WHITE);
        g2.fill(wk27);
        g2.setColor(Color.BLACK);
        g2.draw(wk27);
        g2.setColor(Color.WHITE);
        g2.fill(wk28);
        g2.setColor(Color.BLACK);
        g2.draw(wk28);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

