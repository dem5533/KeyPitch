package midi;

import java.awt.*;

public class WhiteKey {
    private int x;
    private int y;
    private int  height;
    private int  width;
    private int  arcWidth;
    private int  arcHeight;
    private Color color;


    public WhiteKey(int x, int y) {
        this.x = x;
        this.y = y;
        setRoundRect();
        color = Color.white;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRoundRect() {
        height = 135;
        width = 20;
        arcWidth = 7;
        arcHeight = 7;
    }
    private Color setColor(Color color){
        return color;
    }
    public Color getColor(){return color;}
    public int getArcWidth() {
        return arcWidth;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void changeColor(){
        this.setColor(new Color(15, 213, 131, 255));
    }


}
