package midi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * This class is a canvas where all the piano rounded rectangles are drawn
 */

public class MidiGraphics extends JComponent implements MouseListener, MouseMotionListener{
    private final int Y_COORDINATE = 140; //y coordinate of all keys
    int whiteKeyStartPosition = 100; //starting position of all white keys
    private final int WK_WIDTH = 20; //white key width
    private final int WK_HEIGHT = 135; //white key height
    private final int WK_ARCH = 7;  //white key arch width and arch height
    private final int BK_WIDTH = 12;  //black key width
    private final int BK_HEIGHT = 90;  //black key height
    private final int BK_ARCH = 5;   //black key arch width and arch height

//    private volatile int screenX = 0;
//    private volatile int screenY = 0;
//    private volatile int myX = 0;
//    private volatile int myY = 0;
    private RoundRectangle2D mrb;

    private RoundRectangle2D[] whiteKey; //WHITE keys array

    private RoundRectangle2D[] blackKey = new RoundRectangle2D.Double[20]; //BLACK keys array
    private BufferedImage buffer;
    private boolean active = false;
    private int whiteKeyCount; //white key counter
    private int blackKeyCount; //black key counter
    private Image myImage;

    /**
     * constructor
     */
    public MidiGraphics(){
        //instantiate rectangle midi base
        mrb = new RoundRectangle2D.Double(90, 80, 580, 210, 14,14);

        myImage = new ImageIcon("/images/icons8-piano-pastel-glyph-96.png").getImage();

        //initialize white key rectangles
        whiteKey = new RoundRectangle2D.Double[28];
        for(int i = 0; i < whiteKey.length; i++){
            whiteKey[i] = new RoundRectangle2D.Double(whiteKeyStartPosition,Y_COORDINATE, WK_WIDTH, WK_HEIGHT, WK_ARCH,WK_ARCH );
            whiteKeyStartPosition += 20;
        }

        //initialize black keys manually because of uneven gap space
        blackKey[0] = new RoundRectangle2D.Double(115, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[1]  = new RoundRectangle2D.Double(135, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[2]  = new RoundRectangle2D.Double(175, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[3]  = new RoundRectangle2D.Double(195, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[4]  = new RoundRectangle2D.Double(215, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[5] = new RoundRectangle2D.Double(255, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[6] = new RoundRectangle2D.Double(275, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[7] = new RoundRectangle2D.Double(315, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[8] = new RoundRectangle2D.Double(335, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[9] = new RoundRectangle2D.Double(355, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[10] = new RoundRectangle2D.Double(395, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[11] = new RoundRectangle2D.Double(415, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[12] = new RoundRectangle2D.Double(455, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[13] = new RoundRectangle2D.Double(475, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[14] = new RoundRectangle2D.Double(495, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[15] = new RoundRectangle2D.Double(535, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[16] = new RoundRectangle2D.Double(555, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[17] = new RoundRectangle2D.Double(595, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[18] = new RoundRectangle2D.Double(615, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);
        blackKey[19] = new RoundRectangle2D.Double(635, Y_COORDINATE, BK_WIDTH, BK_HEIGHT, BK_ARCH,BK_ARCH);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    @Override
    public void paintComponent(Graphics g){
        if(buffer == null){
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR);
        }
        Graphics2D g2 = (Graphics2D)buffer.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(142, 194, 194));
        g2.fillRect(0,0,getWidth(),getHeight());

        g2.setColor(new Color(17, 15, 15, 174));
        g2.fill(mrb);
        g2.setColor(Color.black);
        g2.draw(mrb);
        paintWhiteKeys(g2);
        paintBlackKeys(g2);

        g.drawImage(buffer, 0,0, null);
    }

    /**
     * paints each black key rectangle
     * @param g2 graphics
     */
    private void paintBlackKeys(Graphics2D g2){
        g2.setColor(new Color(5, 9, 26, 255));
        for(int i = 0; i < blackKey.length; i++){
            g2.fill(blackKey[i]);
        }
    }

    /**
     * paints each white key rectangle
     * @param g2 graphics
     */
    private void paintWhiteKeys(Graphics2D g2){
        g2.setColor(Color.WHITE);
        for(int i = 0; i < whiteKey.length; i++){
            g2.fill(whiteKey[i]);
        }
        g2.setColor(Color.BLACK);
        for(int i = 0; i < whiteKey.length; i++){
            g2.draw(whiteKey[i]);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        active = true;
        int bkPressed = 0;

        //add code for Black keys
        for (int i = 0; i < blackKey.length; i++) {
            blackKeyCount = i;
            if ((e.getButton()) == 1 && blackKey[i].contains(e.getX(), e.getY())) { //Left Click
                //for testing only
                JOptionPane.showMessageDialog(null, "black key " + (blackKeyCount + 1));
                bkPressed = 1;
                //add code here to connect black keys
            }
        }

        if (bkPressed == 0) {
            for(int i = 0; i < whiteKey.length; i++){
                whiteKeyCount = i;
                if ((e.getButton()) == 1 && whiteKey[i].contains(e.getX(), e.getY())) { //Left Click
                    //test
    //                JOptionPane.showMessageDialog(null, "key " + (whiteKeyCount + 1) );
                    changeKeyColorOnMouseClicked();
                    // add code to connect white keys
                }
            else if ((e.getButton()) == 3 && whiteKey[i].contains(e.getX(), e.getY())) { //Right  Click
                changeKeyColorOnMouseClicked();
    //                JOptionPane.showMessageDialog(null, "right click on key " + (whiteKeyCount + 1) );
                }
            }
        }
    }

    /**
     * detects the x and y coordinates of the mouse on the panel
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
//        screenX = e.getXOnScreen();
//        screenY = e.getYOnScreen();
//        myX = getX();
//        myY = getY();
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
        active = true; //set true when mouse action listener activated
        //for each white key get x and y coordinates
        for (int i = 0; i < whiteKey.length; i++){
            whiteKeyCount = i;
            if (whiteKey[i].contains(e.getX(), e.getY())) {
                changeKeyColorOnMouseMoved();
                //for testing purposes
//                System.out.println("white key at number "+ (whiteKeyCount +1) + " "+ e.getX() + " " + e.getY());
            }
        }
    }

    /**
     * changes white key colors when the mouse moves over that key
     */
    public void changeKeyColorOnMouseMoved() {
        Color c = generateColor();
        Graphics g = getGraphics();
        Graphics2D g2 = (Graphics2D) g;

        for(int i = 0; i < whiteKey.length; i++){
            if (active == true && whiteKeyCount == i) {
                g2.setColor(c);
                g2.fill(whiteKey[i]);
            }
        }
        //repaint white key's borders
        for(int i = 0; i < whiteKey.length; i++){
            if (active == true && whiteKeyCount == i) {
                g2.setColor(Color.BLACK);
                g2.draw(whiteKey[i]);
            }
        }
    //repaint black keys
        for(int i = 0; i < blackKey.length; i++){
                g2.setColor(Color.BLACK);
                g2.fill(blackKey[i]);
        }
    }

    public void changeKeyColorOnMouseClicked() {
        Graphics g = getGraphics(); //create graphics
        Graphics2D g2 = (Graphics2D) g;
        Color color = new Color(10,150,255, 87);

        //repaint black keys
        for(int i = 0; i < blackKey.length; i++){
            g2.setColor(Color.BLACK);
            g2.fill(blackKey[i]);
        }
        //paint only the active key
        for(int i = 0; i < whiteKey.length; i++){
            if (active == true && whiteKeyCount == i) {
                g2.setColor(color);
                g2.fill(whiteKey[i]);
            }
        }
        //draw only the active key's borders
        for(int i = 0; i < whiteKey.length; i++){
            if (active == true && whiteKeyCount == i) {
                g2.setColor(Color.BLACK);
                g2.draw(whiteKey[i]);
            }
        }
        //repaint black keys
        for(int i = 0; i < blackKey.length; i++){
            g2.setColor(Color.BLACK);
            g2.fill(blackKey[i]);
        }
    }

    /**
     * generates new random colors
     * @return
     */
    public Color generateColor(){
      int r = (int)(Math.random() * 256 + 50);
      int g = (int)(Math.random() * 256 + 50);
      int b = (int)(Math.random() * 256 + 50);
      int a = 40;
       return new Color(r,g,b,a);
    }
    
    private ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);

        if(url == null){
            System.err.println("Unable to load the image: " + path);
        }
        ImageIcon icon = new ImageIcon(url);
        return icon;
    }
}

