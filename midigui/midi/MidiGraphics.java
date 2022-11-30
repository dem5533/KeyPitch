package midi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

public class MidiGraphics extends JComponent implements MouseListener {
    private int y = 130;
    private RoundRectangle rr = new RoundRectangle();
    private WhiteKey wk_1 = new WhiteKey(100, y);
    private WhiteKey wk_2 = new WhiteKey(120, y);
    private WhiteKey wk_3 = new WhiteKey(140, y);
    private WhiteKey wk_4 = new WhiteKey(160, y);
    private WhiteKey wk_5 = new WhiteKey(180, y);
    private WhiteKey wk_6 = new WhiteKey(200, y);
    private WhiteKey wk_7 = new WhiteKey(220, y);
    private WhiteKey wk_8 = new WhiteKey(240, y);
    private WhiteKey wk_9 = new WhiteKey(260, y);
    private WhiteKey wk_10 = new WhiteKey(280,y);
    private WhiteKey wk_11 = new WhiteKey(300, y);
    private WhiteKey wk_12 = new WhiteKey(320, y);
    private WhiteKey wk_13 = new WhiteKey(340, y);
    private WhiteKey wk_14 = new WhiteKey(360, y);
    private WhiteKey wk_15 = new WhiteKey(380, y);
    private WhiteKey wk_16 = new WhiteKey(400, y);
    private WhiteKey wk_17 = new WhiteKey(420, y);
    private WhiteKey wk_18 = new WhiteKey(440,y);
    private WhiteKey wk_19 = new WhiteKey(460, y);
    private WhiteKey wk_20 = new WhiteKey(480, y);
    private WhiteKey wk_21 = new WhiteKey(500, y);
    private WhiteKey wk_22 = new WhiteKey(520, y);
    private WhiteKey wk_23 = new WhiteKey(540, y);
    private WhiteKey wk_24 = new WhiteKey(560, y);
    private WhiteKey wk_25 = new WhiteKey(580, y);
    private WhiteKey wk_26 = new WhiteKey(600, y);
    private WhiteKey wk_27 = new WhiteKey(620, y);
    private WhiteKey wk_28 = new WhiteKey(640, y);
    private WhiteKey wk_29 = new WhiteKey(660, y);

    private BlackKey bk_1 = new BlackKey(115, y);
    private BlackKey bk_2 = new BlackKey(135, y);
    private BlackKey bk_3 = new BlackKey(175, y);
    private BlackKey bk_4 = new BlackKey(195, y);
    private BlackKey bk_5 = new BlackKey(215, y);
    private BlackKey bk_6 = new BlackKey(255, y);
    private BlackKey bk_7 = new BlackKey(275, y);
    private BlackKey bk_8 = new BlackKey(315, y);
    private BlackKey bk_9 = new BlackKey(335, y);
    private BlackKey bk_10 = new BlackKey(355, y);
    private BlackKey bk_11 = new BlackKey(395, y);
    private BlackKey bk_12 = new BlackKey(415, y);
    private BlackKey bk_13 = new BlackKey(475, y);
    private BlackKey bk_14 = new BlackKey(495, y);
    private BlackKey bk_15 = new BlackKey(515, y);
    private BlackKey bk_16 = new BlackKey(555, y);
    private BlackKey bk_17 = new BlackKey(575, y);
    private BlackKey bk_18 = new BlackKey(615, y);
    private BlackKey bk_19 = new BlackKey(635, y);
    private BlackKey bk_20 = new BlackKey(655, y);

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //paint the background
        g2.setColor(new Color(142, 194, 194));
        g2.fillRect(0,0,getWidth(),getHeight());

        g2.setColor(rr.getColor());
        g2.fillRoundRect(rr.getX(), rr.getY(), rr.getWidth(), rr.getHeight(), rr.getArcWidth(),rr.getArcHeight());
        g2.setColor(Color.black);
        g2.drawRoundRect(rr.getX(), rr.getY(), rr.getWidth(), rr.getHeight(), rr.getArcWidth(),rr.getArcHeight());
        //draw first key

        paintWhiteKeys(g2);
        paintBlackKeys(g2);
    }

    private void paintBlackKeys(Graphics g){
        g.setColor(bk_1.getColor());
        g.fillRoundRect(bk_1.getX(), bk_1.getY(), bk_1.getWidth(), bk_1.getHeight(), bk_1.getArcWidth(), bk_1.getArcHeight());

        g.setColor(bk_2.getColor());
        g.fillRoundRect(bk_2.getX(), bk_2.getY(), bk_2.getWidth(), bk_2.getHeight(), bk_2.getArcWidth(), bk_2.getArcHeight());

        g.setColor(bk_3.getColor());
        g.fillRoundRect(bk_3.getX(), bk_3.getY(), bk_3.getWidth(), bk_3.getHeight(), bk_3.getArcWidth(), bk_3.getArcHeight());

        g.setColor(bk_4.getColor());
        g.fillRoundRect(bk_4.getX(), bk_4.getY(), bk_4.getWidth(), bk_4.getHeight(), bk_4.getArcWidth(), bk_4.getArcHeight());

        g.setColor(bk_5.getColor());
        g.fillRoundRect(bk_5.getX(), bk_5.getY(), bk_5.getWidth(), bk_5.getHeight(), bk_5.getArcWidth(), bk_5.getArcHeight());

        g.setColor(bk_6.getColor());
        g.fillRoundRect(bk_6.getX(), bk_6.getY(), bk_6.getWidth(), bk_6.getHeight(), bk_6.getArcWidth(), bk_6.getArcHeight());

        g.setColor(bk_7.getColor());
        g.fillRoundRect(bk_7.getX(), bk_7.getY(), bk_7.getWidth(), bk_7.getHeight(), bk_7.getArcWidth(), bk_7.getArcHeight());

        g.setColor(bk_8.getColor());
        g.fillRoundRect(bk_8.getX(), bk_8.getY(), bk_8.getWidth(), bk_8.getHeight(), bk_8.getArcWidth(), bk_8.getArcHeight());

        g.setColor(bk_9.getColor());
        g.fillRoundRect(bk_9.getX(), bk_9.getY(), bk_9.getWidth(), bk_9.getHeight(), bk_9.getArcWidth(), bk_9.getArcHeight());

        g.setColor(bk_10.getColor());
        g.fillRoundRect(bk_10.getX(), bk_10.getY(), bk_10.getWidth(), bk_10.getHeight(), bk_10.getArcWidth(), bk_10.getArcHeight());

        g.setColor(bk_11.getColor());
        g.fillRoundRect(bk_11.getX(), bk_11.getY(), bk_11.getWidth(), bk_11.getHeight(), bk_11.getArcWidth(), bk_11.getArcHeight());

        g.setColor(bk_12.getColor());
        g.fillRoundRect(bk_12.getX(), bk_12.getY(), bk_12.getWidth(), bk_12.getHeight(), bk_12.getArcWidth(), bk_12.getArcHeight());

        g.setColor(bk_13.getColor());
        g.fillRoundRect(bk_13.getX(), bk_13.getY(), bk_13.getWidth(), bk_13.getHeight(), bk_13.getArcWidth(), bk_13.getArcHeight());

        g.setColor(bk_14.getColor());
        g.fillRoundRect(bk_14.getX(), bk_14.getY(), bk_14.getWidth(), bk_14.getHeight(), bk_14.getArcWidth(), bk_14.getArcHeight());

        g.setColor(bk_15.getColor());
        g.fillRoundRect(bk_15.getX(), bk_15.getY(), bk_15.getWidth(), bk_15.getHeight(), bk_5.getArcWidth(), bk_5.getArcHeight());

        g.setColor(bk_16.getColor());
        g.fillRoundRect(bk_16.getX(), bk_16.getY(), bk_16.getWidth(), bk_16.getHeight(), bk_16.getArcWidth(), bk_16.getArcHeight());

        g.setColor(bk_17.getColor());
        g.fillRoundRect(bk_17.getX(), bk_17.getY(), bk_17.getWidth(), bk_17.getHeight(), bk_17.getArcWidth(), bk_17.getArcHeight());

        g.setColor(bk_18.getColor());
        g.fillRoundRect(bk_18.getX(), bk_18.getY(), bk_18.getWidth(), bk_18.getHeight(), bk_18.getArcWidth(), bk_18.getArcHeight());

        g.setColor(bk_19.getColor());
        g.fillRoundRect(bk_19.getX(), bk_19.getY(), bk_19.getWidth(), bk_19.getHeight(), bk_19.getArcWidth(), bk_19.getArcHeight());

        g.setColor(bk_20.getColor());
        g.fillRoundRect(bk_20.getX(), bk_20.getY(), bk_20.getWidth(), bk_20.getHeight(), bk_20.getArcWidth(), bk_20.getArcHeight());
    }

    private void paintWhiteKeys(Graphics g){
        g.setColor(wk_1.getColor());
        g.fillRoundRect(wk_1.getX(),wk_1.getY(), wk_1.getWidth(), wk_1.getHeight(), wk_1.getArcWidth(), wk_1.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_1.getX(),wk_1.getY(), wk_1.getWidth(), wk_1.getHeight(), wk_1.getArcWidth(), wk_1.getArcHeight());
        //draw second key
        g.setColor(wk_2.getColor());
        g.fillRoundRect(wk_2.getX(),wk_2.getY(), wk_2.getWidth(), wk_2.getHeight(), wk_2.getArcWidth(), wk_2.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_2.getX(),wk_2.getY(), wk_2.getWidth(), wk_2.getHeight(), wk_2.getArcWidth(), wk_2.getArcHeight());
        //draw third key
        g.setColor(wk_3.getColor());
        g.fillRoundRect(wk_3.getX(),wk_3.getY(), wk_3.getWidth(), wk_3.getHeight(), wk_3.getArcWidth(), wk_3.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_3.getX(),wk_3.getY(), wk_3.getWidth(), wk_3.getHeight(), wk_3.getArcWidth(), wk_3.getArcHeight());
        //draw fourth key
        g.setColor(wk_1.getColor());
        g.fillRoundRect(wk_4.getX(),wk_4.getY(), wk_4.getWidth(), wk_4.getHeight(), wk_4.getArcWidth(), wk_4.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_4.getX(),wk_4.getY(), wk_4.getWidth(), wk_4.getHeight(), wk_4.getArcWidth(), wk_4.getArcHeight());
        //draw fifth key
        g.setColor(wk_2.getColor());
        g.fillRoundRect(wk_5.getX(),wk_5.getY(), wk_5.getWidth(), wk_5.getHeight(), wk_5.getArcWidth(), wk_5.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_5.getX(),wk_5.getY(), wk_5.getWidth(), wk_5.getHeight(), wk_5.getArcWidth(), wk_5.getArcHeight());
        //draw sixth key
        g.setColor(wk_6.getColor());
        g.fillRoundRect(wk_6.getX(),wk_6.getY(), wk_6.getWidth(), wk_6.getHeight(), wk_6.getArcWidth(), wk_6.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_6.getX(),wk_6.getY(), wk_6.getWidth(), wk_6.getHeight(), wk_6.getArcWidth(), wk_6.getArcHeight());
        //draw seventh key
        g.setColor(wk_7.getColor());
        g.fillRoundRect(wk_7.getX(), wk_7.getY(), wk_7.getWidth(), wk_7.getHeight(), wk_7.getArcWidth(), wk_7.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_7.getX(), wk_7.getY(), wk_7.getWidth(), wk_7.getHeight(), wk_7.getArcWidth(), wk_7.getArcHeight());
        //draw eight key
        g.setColor(wk_8.getColor());
        g.fillRoundRect(wk_8.getX(), wk_8.getY(), wk_8.getWidth(), wk_8.getHeight(), wk_8.getArcWidth(), wk_8.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_8.getX(), wk_8.getY(), wk_8.getWidth(), wk_8.getHeight(), wk_8.getArcWidth(), wk_8.getArcHeight());
        //draw ninth key
        g.setColor(wk_9.getColor());
        g.fillRoundRect(wk_9.getX(), wk_9.getY(), wk_9.getWidth(), wk_9.getHeight(), wk_9.getArcWidth(), wk_9.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_9.getX(), wk_9.getY(), wk_9.getWidth(), wk_9.getHeight(), wk_9.getArcWidth(), wk_9.getArcHeight());
        //draw tenth key
        g.setColor(wk_10.getColor());
        g.fillRoundRect(wk_10.getX(),wk_10.getY(), wk_10.getWidth(), wk_10.getHeight(), wk_10.getArcWidth(), wk_10.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_10.getX(),wk_10.getY(), wk_10.getWidth(), wk_10.getHeight(), wk_10.getArcWidth(), wk_10.getArcHeight());
        //draw eleventh key
        g.setColor(wk_11.getColor());
        g.fillRoundRect(wk_11.getX(),wk_11.getY(), wk_11.getWidth(), wk_11.getHeight(), wk_11.getArcWidth(), wk_11.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_11.getX(),wk_11.getY(), wk_11.getWidth(), wk_11.getHeight(), wk_11.getArcWidth(), wk_11.getArcHeight());
        //draw twelfth key
        g.setColor(wk_12.getColor());
        g.fillRoundRect(wk_12.getX(),wk_12.getY(), wk_12.getWidth(), wk_12.getHeight(), wk_12.getArcWidth(), wk_12.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_12.getX(),wk_12.getY(), wk_12.getWidth(), wk_12.getHeight(), wk_12.getArcWidth(), wk_12.getArcHeight());
        //draw thirteenth key
        g.setColor(wk_13.getColor());
        g.fillRoundRect(wk_13.getX(),wk_13.getY(), wk_13.getWidth(), wk_13.getHeight(), wk_13.getArcWidth(), wk_13.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_13.getX(),wk_13.getY(), wk_13.getWidth(), wk_13.getHeight(), wk_13.getArcWidth(), wk_13.getArcHeight());
        //draw fourteenth key
        g.setColor(wk_14.getColor());
        g.fillRoundRect(wk_14.getX(),wk_14.getY(), wk_14.getWidth(), wk_14.getHeight(), wk_14.getArcWidth(), wk_14.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_14.getX(),wk_14.getY(), wk_14.getWidth(), wk_14.getHeight(), wk_14.getArcWidth(), wk_14.getArcHeight());
        //draw fifteenth key
        g.setColor(wk_15.getColor());
        g.fillRoundRect(wk_15.getX(),wk_15.getY(), wk_15.getWidth(), wk_15.getHeight(), wk_15.getArcWidth(), wk_15.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_15.getX(),wk_15.getY(), wk_15.getWidth(), wk_15.getHeight(), wk_15.getArcWidth(), wk_15.getArcHeight());
        //draw sixth key
        g.setColor(wk_16.getColor());
        g.fillRoundRect(wk_16.getX(),wk_16.getY(), wk_16.getWidth(), wk_16.getHeight(), wk_16.getArcWidth(), wk_16.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_16.getX(),wk_16.getY(), wk_16.getWidth(), wk_16.getHeight(), wk_16.getArcWidth(), wk_16.getArcHeight());
        //draw seventeenth key
        g.setColor(wk_17.getColor());
        g.fillRoundRect(wk_17.getX(), wk_17.getY(), wk_17.getWidth(), wk_17.getHeight(), wk_17.getArcWidth(), wk_17.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_17.getX(), wk_17.getY(), wk_17.getWidth(), wk_17.getHeight(), wk_17.getArcWidth(), wk_17.getArcHeight());
        //draw eighteenth key
        g.setColor(wk_18.getColor());
        g.fillRoundRect(wk_18.getX(), wk_18.getY(), wk_18.getWidth(), wk_18.getHeight(), wk_18.getArcWidth(), wk_18.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_18.getX(), wk_18.getY(), wk_18.getWidth(), wk_18.getHeight(), wk_18.getArcWidth(), wk_18.getArcHeight());
        //draw ninth key
        g.setColor(wk_19.getColor());
        g.fillRoundRect(wk_19.getX(), wk_19.getY(), wk_19.getWidth(), wk_19.getHeight(), wk_19.getArcWidth(), wk_19.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_19.getX(), wk_19.getY(), wk_19.getWidth(), wk_19.getHeight(), wk_19.getArcWidth(), wk_19.getArcHeight());
        //draw twentieth key
        g.setColor(wk_20.getColor());
        g.fillRoundRect(wk_20.getX(),wk_20.getY(), wk_20.getWidth(), wk_20.getHeight(), wk_20.getArcWidth(), wk_20.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_20.getX(),wk_20.getY(), wk_20.getWidth(), wk_20.getHeight(), wk_20.getArcWidth(), wk_20.getArcHeight());
        //draw twenty-first key
        g.setColor(wk_1.getColor());
        g.fillRoundRect(wk_21.getX(),wk_21.getY(), wk_21.getWidth(), wk_21.getHeight(), wk_21.getArcWidth(), wk_21.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_21.getX(),wk_21.getY(), wk_21.getWidth(), wk_21.getHeight(), wk_21.getArcWidth(), wk_21.getArcHeight());
        //draw twenty-second key
        g.setColor(wk_22.getColor());
        g.fillRoundRect(wk_22.getX(),wk_22.getY(), wk_22.getWidth(), wk_22.getHeight(), wk_22.getArcWidth(), wk_22.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_22.getX(),wk_22.getY(), wk_22.getWidth(), wk_22.getHeight(), wk_22.getArcWidth(), wk_22.getArcHeight());
        //draw twenty-third key
        g.setColor(wk_3.getColor());
        g.fillRoundRect(wk_23.getX(),wk_23.getY(), wk_23.getWidth(), wk_23.getHeight(), wk_23.getArcWidth(), wk_23.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_23.getX(),wk_23.getY(), wk_23.getWidth(), wk_23.getHeight(), wk_23.getArcWidth(), wk_23.getArcHeight());
        //draw fourth key
        g.setColor(wk_24.getColor());
        g.fillRoundRect(wk_24.getX(),wk_24.getY(), wk_24.getWidth(), wk_24.getHeight(), wk_24.getArcWidth(), wk_24.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_24.getX(),wk_24.getY(), wk_24.getWidth(), wk_24.getHeight(), wk_24.getArcWidth(), wk_24.getArcHeight());
        //draw fifth key
        g.setColor(wk_25.getColor());
        g.fillRoundRect(wk_25.getX(),wk_25.getY(), wk_25.getWidth(), wk_25.getHeight(), wk_25.getArcWidth(), wk_25.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_25.getX(),wk_25.getY(), wk_25.getWidth(), wk_25.getHeight(), wk_25.getArcWidth(), wk_25.getArcHeight());
        //draw sixth key
        g.setColor(wk_26.getColor());
        g.fillRoundRect(wk_26.getX(),wk_26.getY(), wk_26.getWidth(), wk_26.getHeight(), wk_26.getArcWidth(), wk_26.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_26.getX(),wk_26.getY(), wk_26.getWidth(), wk_26.getHeight(), wk_26.getArcWidth(), wk_26.getArcHeight());
        //draw seventh key
        g.setColor(wk_27.getColor());
        g.fillRoundRect(wk_27.getX(), wk_27.getY(), wk_27.getWidth(), wk_27.getHeight(), wk_27.getArcWidth(), wk_27.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_27.getX(), wk_27.getY(), wk_27.getWidth(), wk_27.getHeight(), wk_27.getArcWidth(), wk_27.getArcHeight());
        //draw eight key
        g.setColor(wk_28.getColor());
        g.fillRoundRect(wk_28.getX(), wk_28.getY(), wk_28.getWidth(), wk_28.getHeight(), wk_28.getArcWidth(), wk_28.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_28.getX(), wk_28.getY(), wk_28.getWidth(), wk_28.getHeight(), wk_28.getArcWidth(), wk_28.getArcHeight());
        //draw ninth key
        g.setColor(wk_29.getColor());
        g.fillRoundRect(wk_29.getX(), wk_29.getY(), wk_29.getWidth(), wk_29.getHeight(), wk_29.getArcWidth(), wk_29.getArcHeight());
        g.setColor(Color.BLACK);
        g.drawRoundRect(wk_29.getX(), wk_29.getY(), wk_29.getWidth(), wk_29.getHeight(), wk_29.getArcWidth(), wk_29.getArcHeight());
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        wk_1.changeColor();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        wk_1.changeColor();
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

