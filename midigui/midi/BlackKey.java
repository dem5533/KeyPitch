package midi;

import java.awt.*;

public class BlackKey {
        private int x;
        private int y;
        private int  height;
        private int  width;
        private int  arcWidth;
        private int  arcHeight;
        private Color color;


        public BlackKey(int x, int y) {
            this.x = x;
            this.y = y;
            setRoundRect();
            color = new Color(10, 15, 35, 255);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        private void setRoundRect() {
            height = 90;
            width = 13;
            arcWidth = 5;
            arcHeight = 5;
        }
        public Color setColor(Color color){
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
            this.setColor(new Color(182,98,232,73));
        }

}
