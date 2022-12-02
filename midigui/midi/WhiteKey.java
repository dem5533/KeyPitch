package midi;

import java.awt.*;

public class WhiteKey implements RoundedRectangle{
    private final int X;
    private final int Y;
    private int  height;
    private int  width;
    private int  arcWidth;
    private int  arcHeight;
    private Color color;

    /**
     * constructor to set the size, color and location of the rectangle
     * @param x location on the panel
     * @param y location on the panel
     */
    public WhiteKey(int x, int y) {
        this.X = x;
        this.Y = y;
        setRoundRect();
        setColor(color);
    }

    @Override
    public void setRoundRect() {
        height = 135;
        width = 20;
        arcWidth = 7;
        arcHeight = 7;
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public int getY() {
        return Y;
    }

    @Override
    public int getArcWidth() {
        return arcWidth;
    }

    @Override
    public int getArcHeight() {
        return arcHeight;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }


    public Color setColor(Color color){
        this.color = new Color(247, 247, 250, 255);
        return color;
    }
    public Color getColor(){return color;}


    public void changeColor(){
        this.setColor(new Color(15, 213, 131, 255));
    }

}
