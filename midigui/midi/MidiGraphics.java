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

    private Graphics2D g;
    private KeyClickListener listener;
    private RoundRectangle2D mrb;
    private RoundRectangle2D wk1, wk2, wk3, wk4, wk5, wk6, wk7, wk8, wk9, wk10, wk11, wk12;
    private RoundRectangle2D wk13, wk14, wk15, wk16, wk17, wk18, wk19, wk20, wk21, wk22, wk23;
    private RoundRectangle2D wk24, wk25, wk26, wk27, wk28;

    private RoundRectangle2D bk1,bk2, bk3, bk4, bk5, bk6, bk7, bk8,bk9,bk10;
    private RoundRectangle2D bk11, bk12, bk13, bk14, bk15, bk16, bk17, bk18, bk19, bk20;

    private BufferedImage buffer;

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

        g2.setColor(new Color(42, 39, 39, 174));
        g2.fill(mrb);
        g2.setColor(Color.black);
        g2.draw(mrb);

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

    public void changeColorWhiteKey(Graphics2D g){
        RoundRectangle2D rr = new RoundRectangle2D.Double(getX(), getY(), WK_WIDTH, WK_HEIGHT, WK_ARCH, WK_ARCH);
        g.setColor(new Color(250, 205, 61, 240));
        g.fill(rr);
    }

    public void changeColorBlackKey(Graphics2D g){
        RoundRectangle2D rr = new RoundRectangle2D.Double(getX(), getY(), BK_WIDTH, BK_HEIGHT, BK_ARCH, BK_ARCH);
        g.setColor(new Color(6, 18, 68, 240));
        g.fill(rr);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if ((e.getButton()) == 1 && wk1.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "first key!");
        } else if ((e.getButton()) == 3 && wk1.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, "first key Right Click! YES!");
        }

        if ((e.getButton()) == 1 && wk2.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 2!");
        } else if ((e.getButton()) == 3 && wk2.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 2 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk3.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 3!");
        } else if ((e.getButton()) == 3 && wk3.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, "key 3 Right Click! YES!");
        }

        if ((e.getButton()) == 1 && wk4.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 4!");
        } else if ((e.getButton()) == 3 && wk4.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 4 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk5.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, " key 5!");
        } else if ((e.getButton()) == 3 && wk5.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 5 Right Click! YES!");
        }

        if ((e.getButton()) == 1 && wk6.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 6!");
        } else if ((e.getButton()) == 3 && wk6.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 6 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk7.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 7!");
        } else if ((e.getButton()) == 3 && wk1.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, "key 7 Right Click! YES!");
        }

        if ((e.getButton()) == 1 && wk8.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 8!");
        } else if ((e.getButton()) == 3 && wk8.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 8 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk9.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, " key 9!");
        } else if ((e.getButton()) == 3 && wk9.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 9 Right Click! YES!");
        }

        if ((e.getButton()) == 1 && wk10.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 10!");
        } else if ((e.getButton()) == 3 && wk10.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 10 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk11.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 11!");
        } else if ((e.getButton()) == 3 && wk11.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, "key 11 Right Click! YES!");
        }

        if ((e.getButton()) == 1 && wk12.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 12!");
        } else if ((e.getButton()) == 3 && wk12.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 12 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk13.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, " key 13!");
        } else if ((e.getButton()) == 3 && wk13.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 13 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk14.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 14!");
        } else if ((e.getButton()) == 3 && wk14.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 14 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk15.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 15!");
        } else if ((e.getButton()) == 3 && wk15.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, "key 15 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk16.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 16!");
        } else if ((e.getButton()) == 3 && wk16.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 16 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk17.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, " key 17!");
        } else if ((e.getButton()) == 3 && wk17.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 17 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk18.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 18!");
        } else if ((e.getButton()) == 3 && wk18.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 18 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk19.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 19!");
        } else if ((e.getButton()) == 3 && wk19.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, "key 19 Right Click! YES!");
        }

        if ((e.getButton()) == 1 && wk20.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 20!");
        } else if ((e.getButton()) == 3 && wk20.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 20 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk21.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, " key 21!");
        } else if ((e.getButton()) == 3 && wk21.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 21 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk22.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 22!");
        } else if ((e.getButton()) == 3 && wk22.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 22 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk23.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 23!");
        } else if ((e.getButton()) == 3 && wk23.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, "key 23 Right Click! YES!");
        }

        if ((e.getButton()) == 1 && wk24.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 24!");
        } else if ((e.getButton()) == 3 && wk24.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 24 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk25.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, " key 25!");
        } else if ((e.getButton()) == 3 && wk25.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 25 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk26.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 26!");
        } else if ((e.getButton()) == 3 && wk26.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, "key 26 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk27.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, "key 27!");
        } else if ((e.getButton()) == 3 && wk27.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 27 Right Click! YES!");
        }
        if ((e.getButton()) == 1 && wk28.contains(e.getX(), e.getY())) { //Left Click
            //test
            JOptionPane.showMessageDialog(null, " key 28!");
        } else if ((e.getButton()) == 3 && wk28.contains(e.getX(), e.getY())) { //Right  Click
            //test
            JOptionPane.showMessageDialog(null, " key 28 Right Click! YES!");
        }
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
        if (wk1.contains(e.getX(), e.getY())){
            System.out.println("Moved at ["+
                    e.getX()+ ", "+e.getY()+"]");
        }else{
            System.out.println("");
        }

    }
}

