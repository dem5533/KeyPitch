package midi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class MidiGraphics extends JComponent implements MouseListener, MouseMotionListener{
    private final int Y = 140;
    private final int WK_WIDTH = 20;
    private final int WK_HEIGHT = 135;
    private final int WK_ARCH = 7;
    private final int BK_WIDTH = 12;
    private final int BK_HEIGHT = 90;
    private final int BK_ARCH = 5;

    private volatile int screenX = 0;
    private volatile int screenY = 0;
    private volatile int myX = 0;
    private volatile int myY = 0;
    private RoundRectangle2D mrb;

    JLabel label;

    private RoundRectangle2D wk1, wk2, wk3, wk4, wk5, wk6, wk7, wk8, wk9, wk10, wk11, wk12;
    private RoundRectangle2D wk13, wk14, wk15, wk16, wk17, wk18, wk19, wk20, wk21, wk22, wk23;
    private RoundRectangle2D wk24, wk25, wk26, wk27, wk28;

    private RoundRectangle2D bk1,bk2, bk3, bk4, bk5, bk6, bk7, bk8,bk9,bk10;
    private RoundRectangle2D bk11, bk12, bk13, bk14, bk15, bk16, bk17, bk18, bk19, bk20;

    private BufferedImage buffer;

    private boolean active = false;
    int keyCount;
    Color color;

    /**
     * constructor
     */
    public MidiGraphics(){
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
         //       super.componentResized(e);
                buffer = null;
            }
        });
        //instantiate rectangle midi shape and keys
        mrb = new RoundRectangle2D.Double(90, 80, 580, 210, 14,14);
        wk1 = new RoundRectangle2D.Double(100, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk2 = new RoundRectangle2D.Double(120, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk3 = new RoundRectangle2D.Double(140, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk4 = new RoundRectangle2D.Double(160, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk5 = new RoundRectangle2D.Double(180, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk6 = new RoundRectangle2D.Double(200, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk7 = new RoundRectangle2D.Double(220, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk8 = new RoundRectangle2D.Double(240, Y,WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk9 = new RoundRectangle2D.Double(260, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk10 = new RoundRectangle2D.Double(280, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk11 = new RoundRectangle2D.Double(300, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk12 = new RoundRectangle2D.Double(320, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk13 = new RoundRectangle2D.Double(340, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk14 = new RoundRectangle2D.Double(360, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk15 = new RoundRectangle2D.Double(380, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk16 = new RoundRectangle2D.Double(400, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk17 = new RoundRectangle2D.Double(420, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk18 = new RoundRectangle2D.Double(440, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk19 = new RoundRectangle2D.Double(460, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk20 = new RoundRectangle2D.Double(480, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk21 = new RoundRectangle2D.Double(500, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk22 = new RoundRectangle2D.Double(520, Y,WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk23 = new RoundRectangle2D.Double(540, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk24 = new RoundRectangle2D.Double(560, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk25 = new RoundRectangle2D.Double(580, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk26 = new RoundRectangle2D.Double(600, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk27 = new RoundRectangle2D.Double(620, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);
        wk28 = new RoundRectangle2D.Double(640, Y, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH);

        bk1 = new RoundRectangle2D.Double(115, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk2 = new RoundRectangle2D.Double(135, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk3 = new RoundRectangle2D.Double(175, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk4 = new RoundRectangle2D.Double(195, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk5 = new RoundRectangle2D.Double(215, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk6 = new RoundRectangle2D.Double(255, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk7 = new RoundRectangle2D.Double(275, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk8 = new RoundRectangle2D.Double(315, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk9 = new RoundRectangle2D.Double(335, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk10 = new RoundRectangle2D.Double(355, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk11 = new RoundRectangle2D.Double(395, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk12 = new RoundRectangle2D.Double(415, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk13 = new RoundRectangle2D.Double(455, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk14 = new RoundRectangle2D.Double(475, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk15 = new RoundRectangle2D.Double(495, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk16 = new RoundRectangle2D.Double(535, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk17 = new RoundRectangle2D.Double(555, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk18 = new RoundRectangle2D.Double(595, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk19 = new RoundRectangle2D.Double(615, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        bk20 = new RoundRectangle2D.Double(635, Y, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    @Override
    public void paintComponent(Graphics g){
        if(buffer == null){
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR);
        }

        Graphics2D g2 = (Graphics2D)buffer.getGraphics();
        //paint the background

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(142, 194, 194));
        g2.fillRect(0,0,getWidth(),getHeight());

        g2.setColor(new Color(17, 15, 15, 174));
        g2.fill(mrb);
        g2.setColor(Color.black);
        g2.draw(mrb);
        if(active == true && keyCount == 1){
            g2.setPaint(Color.GREEN);
            g2.draw(wk1);
        }
        paintWhiteKeys(g2);
        paintBlackKeys(g2);

        g.drawImage(buffer, 0,0, null);
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
        g2.fill( wk1);
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
        active = true;

        if ((e.getButton()) == 1 && wk1.contains(e.getX(), e.getY())) { //Left Click
            //test
            //           JOptionPane.showMessageDialog(null, "first key!");
            keyCount = 1;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk2.contains(e.getX(), e.getY())) { //Left Click
            //test
//            JOptionPane.showMessageDialog(null, "key 2!");
            keyCount = 2;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk3.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 3;
            changeKeyColorOnMouseClicked();
        }

        if ((e.getButton()) == 1 && wk4.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 4;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk5.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 5;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk6.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 6;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk7.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 7;
            changeKeyColorOnMouseClicked();
        }

        if ((e.getButton()) == 1 && wk8.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 8;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk9.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 9;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk10.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 10;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk11.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 11;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk12.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 12;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk13.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 13;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk14.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 14;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk15.contains(e.getX(), e.getY())) { //Left Click
            //test
            keyCount = 15;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk16.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 16;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk17.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 17;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk18.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 18;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk19.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 19;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk20.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 20;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk21.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 21;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk22.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 22;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk23.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 23;
            changeKeyColorOnMouseClicked();
        }

        if ((e.getButton()) == 1 && wk24.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 24;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk25.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 25;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk26.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 26;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk27.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 27;
            changeKeyColorOnMouseClicked();
        }
        if ((e.getButton()) == 1 && wk28.contains(e.getX(), e.getY())) { //Left Click
            keyCount = 28;
            changeKeyColorOnMouseClicked();
        }
//        else if ((e.getButton()) == 3 && wk28.contains(e.getX(), e.getY())) { //Right  Click
//            //test
//            JOptionPane.showMessageDialog(null, " key 28 Right Click! YES!");
//        }
    }

    /**
     * detects the x and y coordinates of the mouse on the panel
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        screenX = e.getXOnScreen();
        screenY = e.getYOnScreen();
        myX = getX();
        myY = getY();
    }

    /**
     * not needed
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * not needed
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * not needed
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        int deltaX = e.getXOnScreen() - screenX;
//        int deltaY = e.getYOnScreen() - screenY;
//
//        setLocation(myX + deltaX, myY + deltaY);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        active = true;
        if (wk1.contains(e.getX(), e.getY())) {
            keyCount = 1;
            changeKeyColorOnMouseMoved();
        }
        if (wk2.contains(e.getX(), e.getY())) {
            keyCount = 2;
            changeKeyColorOnMouseMoved();
        }
        if (wk3.contains(e.getX(), e.getY())) {
            keyCount = 3;
            changeKeyColorOnMouseMoved();
        }
        if (wk4.contains(e.getX(), e.getY())) {
            keyCount = 4;
            changeKeyColorOnMouseMoved();
        }
        if (wk5.contains(e.getX(), e.getY())) {
            keyCount = 5;
            changeKeyColorOnMouseMoved();
        }
        if (wk6.contains(e.getX(), e.getY())) {
            keyCount = 6;
            changeKeyColorOnMouseMoved();
        }
        if (wk7.contains(e.getX(), e.getY())) {
            keyCount = 7;
            changeKeyColorOnMouseMoved();
        }
        if (wk8.contains(e.getX(), e.getY())) {
            keyCount = 8;
            changeKeyColorOnMouseMoved();
        }
        if (wk9.contains(e.getX(), e.getY())) {
            keyCount = 9;
            changeKeyColorOnMouseMoved();
        }
        if (wk10.contains(e.getX(), e.getY())) {
            keyCount = 10;
            changeKeyColorOnMouseMoved();
        }
        if (wk11.contains(e.getX(), e.getY())) {
            keyCount = 11;
            changeKeyColorOnMouseMoved();
        }
        if (wk12.contains(e.getX(), e.getY())) {
            keyCount = 12;
            changeKeyColorOnMouseMoved();
        }
        if (wk13.contains(e.getX(), e.getY())) {
            keyCount = 13;
            changeKeyColorOnMouseMoved();
        }
        if (wk14.contains(e.getX(), e.getY())) {
            keyCount = 14;
            changeKeyColorOnMouseMoved();
        }
        if (wk15.contains(e.getX(), e.getY())) {
            keyCount = 15;
            changeKeyColorOnMouseMoved();
        }
        if (wk16.contains(e.getX(), e.getY())) {
            keyCount = 16;
            changeKeyColorOnMouseMoved();
        }
        if (wk17.contains(e.getX(), e.getY())) {
            keyCount = 17;
            changeKeyColorOnMouseMoved();
        }
        if (wk18.contains(e.getX(), e.getY())) {
            keyCount = 18;
            changeKeyColorOnMouseMoved();
        }
        if (wk19.contains(e.getX(), e.getY())) {
            keyCount = 19;
            changeKeyColorOnMouseMoved();
        }
        if (wk10.contains(e.getX(), e.getY())) {
            keyCount = 20;
            changeKeyColorOnMouseMoved();
        }
        if (wk21.contains(e.getX(), e.getY())) {
            keyCount = 21;
            changeKeyColorOnMouseMoved();
        } else if (wk22.contains(e.getX(), e.getY())) {
            keyCount = 22;
            changeKeyColorOnMouseMoved();
        }
        if (wk23.contains(e.getX(), e.getY())) {
            keyCount = 23;
            changeKeyColorOnMouseMoved();
        }
        if (wk24.contains(e.getX(), e.getY())) {
            keyCount = 24;
            changeKeyColorOnMouseMoved();
        }
        if (wk25.contains(e.getX(), e.getY())) {
            keyCount = 25;
            changeKeyColorOnMouseMoved();
        }
        if (wk26.contains(e.getX(), e.getY())) {
            keyCount = 26;
            changeKeyColorOnMouseMoved();
        }
        if (wk27.contains(e.getX(), e.getY())) {
            keyCount = 27;
            changeKeyColorOnMouseMoved();
        }
        if (wk28.contains(e.getX(), e.getY())) {
            keyCount = 28;
            changeKeyColorOnMouseMoved();
        }
    }

    /**
     * changes white key colors when the mouse moves over that key
     */
    public void changeKeyColorOnMouseMoved() {
        Color c = generateColor();
        Graphics g = getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        if (active == true && keyCount == 1) {
            g2.setColor(c);
            g2.fill(wk1);
            g2.setColor(Color.BLACK);
            g2.draw(wk1);
            g2.setColor(Color.BLACK);
            g2.fill(bk1);
        } g2.setColor(c);
        if (active == true && keyCount == 2) {
            g2.fill(wk2);
            g2.setColor(Color.BLACK);
            g2.draw(wk2);
            g2.setColor(Color.BLACK);
            g2.fill(bk1);
            g2.setColor(Color.BLACK);
            g2.fill(bk2);
        } g2.setColor(c);
        if (active == true && keyCount == 3) {
            g2.fill(wk3);
            g2.setColor(Color.BLACK);
            g2.draw(wk3);
            g2.setColor(Color.BLACK);
            g2.fill(bk2);
        } g2.setColor(c);
        if (active == true && keyCount == 4) {
            g2.fill(wk4);
            g2.setColor(Color.BLACK);
            g2.draw(wk4);
            g2.setColor(Color.BLACK);
            g2.fill(bk3);
        } g2.setColor(c);
        if (active == true && keyCount == 5) {
            g2.fill(wk5);
            g2.setColor(Color.BLACK);
            g2.draw(wk5);
            g2.setColor(Color.BLACK);
            g2.fill(bk3);
            g2.setColor(Color.BLACK);
            g2.fill(bk4);
        } g2.setColor(c);
        if (active == true && keyCount == 6) {
            g2.fill(wk6);
            g2.setColor(Color.BLACK);
            g2.draw(wk6);
            g2.setColor(Color.BLACK);
            g2.fill(bk4);
            g2.setColor(Color.BLACK);
            g2.fill(bk5);
        } g2.setColor(c);
        if (active == true && keyCount == 7) {
            g2.fill(wk7);
            g2.setColor(Color.BLACK);
            g2.draw(wk7);
            g2.setColor(Color.BLACK);
            g2.fill(bk5);
            g2.setColor(Color.BLACK);
            g2.fill(bk6);
        } g2.setColor(c);
        if (active == true && keyCount == 8) {
            g2.fill(wk8);
            g2.setColor(Color.BLACK);
            g2.draw(wk8);
            g2.setColor(Color.BLACK);
            g2.fill(bk6);
        } g2.setColor(c);
        if (active == true && keyCount == 9) {
            g2.fill(wk9);
            g2.setColor(Color.BLACK);
            g2.draw(wk9);
            g2.setColor(Color.BLACK);
            g2.fill(bk6);
            g2.setColor(Color.BLACK);
            g2.fill(bk7);
        } g2.setColor(c);
        if (active == true && keyCount == 10) {
            g2.fill(wk10);
            g2.setColor(Color.BLACK);
            g2.draw(wk10);
            g2.setColor(Color.BLACK);
            g2.fill(bk7);
        } g2.setColor(c);
        if (active == true && keyCount == 11) {
            g2.fill(wk11);
            g2.setColor(Color.BLACK);
            g2.draw(wk11);
            g2.setColor(Color.BLACK);
            g2.fill(bk8);
        } g2.setColor(c);
        if (active == true && keyCount == 12) {
            g2.fill(wk12);
            g2.setColor(Color.BLACK);
            g2.draw(wk12);
            g2.setColor(Color.BLACK);
            g2.fill(bk8);
            g2.setColor(Color.BLACK);
            g2.fill(bk9);
        } g2.setColor(c);
        if (active == true && keyCount == 13) {
            g2.fill(wk13);
            g2.setColor(Color.BLACK);
            g2.draw(wk13);
            g2.setColor(Color.BLACK);
            g2.fill(bk9);
            g2.setColor(Color.BLACK);
            g2.fill(bk10);
        } g2.setColor(c);
        if (active == true && keyCount == 14) {
            g2.fill(wk14);
            g2.setColor(Color.BLACK);
            g2.draw(wk14);
            g2.setColor(Color.BLACK);
            g2.fill(bk10);
        } g2.setColor(c);
        if (active == true && keyCount == 15) {
            g2.fill(wk15);
            g2.setColor(Color.BLACK);
            g2.draw(wk15);
            g2.setColor(Color.BLACK);
            g2.fill(bk11);
        } g2.setColor(c);
        if (active == true && keyCount == 16) {
            g2.fill(wk16);
            g2.setColor(Color.BLACK);
            g2.draw(wk16);
            g2.setColor(Color.BLACK);
            g2.fill(bk11);
            g2.setColor(Color.BLACK);
            g2.fill(bk12);
        } g2.setColor(c);
        if (active == true && keyCount == 17) {
            g2.fill(wk17);
            g2.setColor(Color.BLACK);
            g2.draw(wk17);
            g2.setColor(Color.BLACK);
            g2.fill(bk12);
        } g2.setColor(c);
        if (active == true && keyCount == 18) {
            g2.fill(wk18);
            g2.setColor(Color.BLACK);
            g2.draw(wk18);
            g2.setColor(Color.BLACK);
            g2.fill(bk13);
        } g2.setColor(c);
        if (active == true && keyCount == 19) {
            g2.fill(wk19);
            g2.setColor(Color.BLACK);
            g2.draw(wk19);
            g2.setColor(Color.BLACK);
            g2.fill(bk13);
            g2.setColor(Color.BLACK);
            g2.fill(bk14);
        } g2.setColor(c);
        if (active == true && keyCount == 20) {
            g2.fill(wk20);
            g2.setColor(Color.BLACK);
            g2.draw(wk20);
            g2.setColor(Color.BLACK);
            g2.fill(bk14);
            g2.setColor(Color.BLACK);
            g2.fill(bk15);
        } g2.setColor(c);
        if (active == true && keyCount == 21) {
            g2.fill(wk21);
            g2.setColor(Color.BLACK);
            g2.draw(wk21);
            g2.setColor(Color.BLACK);
            g2.fill(bk15);
        } g2.setColor(c);
        if (active == true && keyCount == 22) {
            g2.fill(wk22);
            g2.setColor(Color.BLACK);
            g2.draw(wk22);
            g2.setColor(Color.BLACK);
            g2.fill(bk16);
        } g2.setColor(c);
        if (active == true && keyCount == 23) {
            g2.fill(wk23);
            g2.setColor(Color.BLACK);
            g2.draw(wk23);
            g2.setColor(Color.BLACK);
            g2.fill(bk16);
            g2.setColor(Color.BLACK);
            g2.fill(bk17);
        } g2.setColor(c);
        if (active == true && keyCount == 24) {
            g2.fill(wk24);
            g2.setColor(Color.BLACK);
            g2.draw(wk24);
            g2.setColor(Color.BLACK);
            g2.fill(bk17);
        } g2.setColor(c);
        if (active == true && keyCount == 25) {
            g2.fill(wk25);
            g2.setColor(Color.BLACK);
            g2.draw(wk25);
            g2.setColor(Color.BLACK);
            g2.fill(bk18);
        } g2.setColor(c);
        if (active == true && keyCount == 26) {
            g2.fill(wk26);
            g2.setColor(Color.BLACK);
            g2.draw(wk26);
            g2.setColor(Color.BLACK);
            g2.fill(bk18);
            g2.setColor(Color.BLACK);
            g2.fill(bk19);
        } g2.setColor(c);
        if (active == true && keyCount == 27) {
            g2.fill(wk27);
            g2.setColor(Color.BLACK);
            g2.draw(wk27);
            g2.setColor(Color.BLACK);
            g2.fill(bk19);
            g2.setColor(Color.BLACK);
            g2.fill(bk20);
        } g2.setColor(c);
        if (active == true && keyCount == 28) {
            g2.fill(wk28);
            g2.setColor(Color.BLACK);
            g2.draw(wk28);
            g2.setColor(Color.BLACK);
            g2.fill(bk20);
        }
    }

    public void changeKeyColorOnMouseClicked() {
        Graphics g = getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        Color color = new Color(238, 56, 56, 184);

        if (active == true && keyCount == 1) {
            g2.setColor(Color.BLACK);
            g2.fill(bk1);
            g2.setColor(color);
            g2.fill(wk1);
            g2.setColor(Color.BLACK);
            g2.draw(wk1);
            g2.setColor(Color.BLACK);
            g2.fill(bk1);
        }
        if (active == true && keyCount == 2) {
            g2.setColor(Color.BLACK);
            g2.fill(bk1);
            g2.setColor(Color.BLACK);
            g2.fill(bk2);
            g2.setColor(color);
            g2.fill(wk2);
            g2.setColor(Color.BLACK);
            g2.draw(wk2);
            g2.setColor(Color.BLACK);
            g2.fill(bk1);
            g2.setColor(Color.BLACK);
            g2.fill(bk2);
        }
        if (active == true && keyCount == 3) {
            g2.setColor(Color.BLACK);
            g2.fill(bk2);
            g2.setColor(color);
            g2.fill(wk3);
            g2.setColor(Color.BLACK);
            g2.draw(wk3);
            g2.setColor(Color.BLACK);
            g2.fill(bk2);
        }
        if (active == true && keyCount == 4) {
            g2.setColor(Color.BLACK);
            g2.fill(bk3);
            g2.setColor(color);
            g2.fill(wk4);
            g2.setColor(Color.BLACK);
            g2.draw(wk4);
            g2.setColor(Color.BLACK);
            g2.fill(bk3);
        }
        if (active == true && keyCount == 5) {
            g2.setColor(Color.BLACK);
            g2.fill(bk3);
            g2.setColor(Color.BLACK);
            g2.fill(bk4);
            g2.setColor(color);
            g2.fill(wk5);
            g2.setColor(Color.BLACK);
            g2.draw(wk5);
            g2.setColor(Color.BLACK);
            g2.fill(bk3);
            g2.setColor(Color.BLACK);
            g2.fill(bk4);
        }
        if (active == true && keyCount == 6) {
            g2.setColor(Color.BLACK);
            g2.fill(bk4);
            g2.setColor(Color.BLACK);
            g2.fill(bk5);
            g2.setColor(color);
            g2.fill(wk6);
            g2.setColor(Color.BLACK);
            g2.draw(wk6);
            g2.setColor(Color.BLACK);
            g2.fill(bk4);
            g2.setColor(Color.BLACK);
            g2.fill(bk5);
        }
        if (active == true && keyCount == 7) {
            g2.setColor(Color.BLACK);
            g2.fill(bk5);
            g2.setColor(color);
            g2.fill(wk7);
            g2.setColor(Color.BLACK);
            g2.draw(wk7);
            g2.setColor(Color.BLACK);
            g2.fill(bk5);
        }
        if (active == true && keyCount == 8) {
            g2.setColor(Color.BLACK);
            g2.fill(bk6);
            g2.setColor(color);
            g2.fill(wk8);
            g2.setColor(Color.BLACK);
            g2.draw(wk8);
            g2.setColor(Color.BLACK);
            g2.fill(bk6);
        }
        if (active == true && keyCount == 9) {
            g2.setColor(Color.BLACK);
            g2.fill(bk6);
            g2.setColor(Color.BLACK);
            g2.fill(bk7);
            g2.setColor(color);
            g2.fill(wk9);
            g2.setColor(Color.BLACK);
            g2.draw(wk9);
            g2.setColor(Color.BLACK);
            g2.fill(bk6);
            g2.setColor(Color.BLACK);
            g2.fill(bk7);
        }
        if (active == true && keyCount == 10) {
            g2.setColor(Color.BLACK);
            g2.fill(bk7);
            g2.setColor(color);
            g2.fill(wk10);
            g2.setColor(Color.BLACK);
            g2.draw(wk10);
            g2.setColor(Color.BLACK);
            g2.fill(bk7);
        }
        if (active == true && keyCount == 11) {
            g2.setColor(Color.BLACK);
            g2.fill(bk8);
            g2.setColor(color);
            g2.fill(wk11);
            g2.setColor(Color.BLACK);
            g2.draw(wk11);
            g2.setColor(Color.BLACK);
            g2.fill(bk8);
        }
        if (active == true && keyCount == 12) {
            g2.setColor(Color.BLACK);
            g2.fill(bk8);
            g2.setColor(Color.BLACK);
            g2.fill(bk9);
            g2.setColor(color);
            g2.fill(wk12);
            g2.setColor(Color.BLACK);
            g2.draw(wk12);
            g2.setColor(Color.BLACK);
            g2.fill(bk8);
            g2.setColor(Color.BLACK);
            g2.fill(bk9);
            g2.setColor(color);
        }
        if (active == true && keyCount == 13) {
            g2.setColor(Color.BLACK);
            g2.fill(bk9);
            g2.setColor(Color.BLACK);
            g2.fill(bk10);
            g2.setColor(color);
            g2.fill(wk13);
            g2.setColor(Color.BLACK);
            g2.draw(wk13);
            g2.setColor(Color.BLACK);
            g2.fill(bk9);
            g2.setColor(Color.BLACK);
            g2.fill(bk10);
        }
        if (active == true && keyCount == 14) {
            g2.setColor(Color.BLACK);
            g2.fill(bk10);
            g2.setColor(color);
            g2.fill(wk14);
            g2.setColor(Color.BLACK);
            g2.draw(wk14);
            g2.setColor(Color.BLACK);
            g2.fill(bk10);
        }
        if (active == true && keyCount == 15) {
            g2.setColor(Color.BLACK);
            g2.fill(bk11);
            g2.setColor(Color.BLACK);
            g2.fill(bk2);
            g2.setColor(color);
            g2.fill(wk15);
            g2.setColor(Color.BLACK);
            g2.draw(wk15);
            g2.setColor(Color.BLACK);
            g2.fill(bk11);
        }
        if (active == true && keyCount == 16) {
            g2.setColor(Color.BLACK);
            g2.fill(bk11);
            g2.setColor(Color.BLACK);
            g2.fill(bk12);
            g2.setColor(color);
            g2.fill(wk16);
            g2.setColor(Color.BLACK);
            g2.draw(wk16);
            g2.setColor(Color.BLACK);
            g2.fill(bk11);
            g2.setColor(Color.BLACK);
            g2.fill(bk12);
        }
        if (active == true && keyCount == 17) {
            g2.setColor(Color.BLACK);
            g2.fill(bk12);
            g2.setColor(color);
            g2.fill(wk17);
            g2.setColor(Color.BLACK);
            g2.draw(wk17);
            g2.setColor(Color.BLACK);
            g2.fill(bk12);
            g2.setColor(color);
        }
        if (active == true && keyCount == 18) {
            g2.setColor(Color.BLACK);
            g2.fill(bk13);
            g2.setColor(color);
            g2.fill(wk18);
            g2.setColor(Color.BLACK);
            g2.draw(wk18);
            g2.setColor(Color.BLACK);
            g2.fill(bk13);
        }
        if (active == true && keyCount == 19) {
            g2.setColor(Color.BLACK);
            g2.fill(bk13);
            g2.setColor(Color.BLACK);
            g2.fill(bk14);
            g2.setColor(color);
            g2.fill(wk19);
            g2.setColor(Color.BLACK);
            g2.draw(wk19);
            g2.setColor(Color.BLACK);
            g2.fill(bk13);
            g2.setColor(Color.BLACK);
            g2.fill(bk14);
        }
        if (active == true && keyCount == 20) {
            g2.setColor(Color.BLACK);
            g2.fill(bk14);
            g2.setColor(Color.BLACK);
            g2.fill(bk15);
            g2.setColor(color);
            g2.fill(wk20);
            g2.setColor(Color.BLACK);
            g2.draw(wk20);
            g2.setColor(Color.BLACK);
            g2.fill(bk14);
            g2.setColor(Color.BLACK);
            g2.fill(bk15);
        }
        if (active == true && keyCount == 21) {
            g2.setColor(Color.BLACK);
            g2.fill(bk15);
            g2.setColor(color);
            g2.fill(wk21);
            g2.setColor(Color.BLACK);
            g2.draw(wk21);
            g2.setColor(Color.BLACK);
            g2.fill(bk15);
        }
        if (active == true && keyCount == 22) {
            g2.setColor(Color.BLACK);
            g2.fill(bk16);
            g2.setColor(color);
            g2.fill(wk22);
            g2.setColor(Color.BLACK);
            g2.draw(wk22);
            g2.setColor(Color.BLACK);
            g2.fill(bk16);
        }
        if (active == true && keyCount == 23) {
            g2.setColor(Color.BLACK);
            g2.fill(bk16);
            g2.setColor(Color.BLACK);
            g2.fill(bk17);
            g2.setColor(color);
            g2.fill(wk23);
            g2.setColor(Color.BLACK);
            g2.draw(wk23);
            g2.setColor(Color.BLACK);
            g2.fill(bk16);
            g2.setColor(Color.BLACK);
            g2.fill(bk17);
        }
        if (active == true && keyCount == 24) {
            g2.setColor(Color.BLACK);
            g2.fill(bk17);
            g2.setColor(color);
            g2.fill(wk24);
            g2.setColor(Color.BLACK);
            g2.draw(wk24);
            g2.setColor(Color.BLACK);
            g2.fill(bk17);
        }
        if (active == true && keyCount == 25) {
            g2.setColor(Color.BLACK);
            g2.fill(bk17);
            g2.setColor(color);
            g2.fill(wk25);
            g2.setColor(Color.BLACK);
            g2.draw(wk25);
            g2.setColor(Color.BLACK);
            g2.fill(bk17);
        }
        if (active == true && keyCount == 26) {
            g2.setColor(Color.BLACK);
            g2.fill(bk18);
            g2.setColor(Color.BLACK);
            g2.fill(bk19);
            g2.setColor(color);
            g2.fill(wk26);
            g2.setColor(Color.BLACK);
            g2.draw(wk26);
            g2.setColor(Color.BLACK);
            g2.fill(bk18);
            g2.setColor(Color.BLACK);
            g2.fill(bk19);
        }
        if (active == true && keyCount == 27) {
            g2.setColor(Color.BLACK);
            g2.fill(bk19);
            g2.setColor(Color.BLACK);
            g2.fill(bk20);
            g2.setColor(color);
            g2.fill(wk27);
            g2.setColor(Color.BLACK);
            g2.draw(wk27);
            g2.setColor(Color.BLACK);
            g2.fill(bk19);
            g2.setColor(Color.BLACK);
            g2.fill(bk20);
        }
        if (active == true && keyCount == 28) {
            g2.setColor(Color.BLACK);
            g2.fill(bk20);
            g2.setColor(color);
            g2.fill(wk28);
            g2.setColor(Color.BLACK);
            g2.draw(wk28);
            g2.setColor(Color.BLACK);
            g2.fill(bk20);
        }
    }

    /**
     * generates new random colors
     * @return
     */
    public Color generateColor(){
      int r = (int)(Math.random() * 256);
      int g = (int)(Math.random() * 256);
      int b = (int)(Math.random() * 256);
      int a = 40;
       return new Color(r,g,b,a);
    }



}

