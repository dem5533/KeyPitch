package midi;

import java.awt.*;

public class RoundRectangle {

    private int x;
    private int  y;
    private int  height;
    private int  width;
    private int  arcWidth;
    private int  arcHeight;
    private Color color;

    public RoundRectangle() {
        setRoundRect();
        setColor();
        //       color = new Color(30, 31, 31,120);

    }

    public Color setColor(){
        color = new Color(42, 39, 39, 174);
        return color;
    }
    public Color getColor(){return color;}
    public int getArcWidth() {
        return arcWidth;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void setRoundRect() {
        x = 90;
        y = 80;
        height = 200;
        width = 580;
        arcWidth = 10;
        arcHeight = 10;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
