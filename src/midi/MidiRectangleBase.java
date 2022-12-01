package midi;

import java.awt.*;

public class MidiRectangleBase implements RoundedRectangle{

    private int x;
    private int  y;
    private int  height;
    private int  width;
    private int  arcWidth;
    private int  arcHeight;
    private Color color;

    /**
     * constructor to set the size and the color of the rectangle
     */
    public MidiRectangleBase() {
        setRoundRect();
        setColor();
    }

    public void setRoundRect() {
        x = 90;
        y = 80;
        height = 200;
        width = 580;
        arcWidth = 10;
        arcHeight = 10;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArcWidth() {
        return arcWidth;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public Color setColor(){
        color = new Color(42, 39, 39, 174);
        return color;
    }
    public Color getColor(){return color;}

}
