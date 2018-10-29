package pers.kavan.li;

import java.awt.*;

/**
 * Created by Ritchie in 16:44 2017/12/22.
 */
public class Explodation {
    double x;
    double y;
    static Image[] images = new Image[16];
    int counts;

    static {
        for (int i = 0; i < 16; i++) {
            images[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");
            images[i].getWidth(null);
        }
    }

    public Explodation() {
    }

    public Explodation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics graphics) {
        if (counts < 16) {
            graphics.drawImage(images[counts], (int) x, (int) y, null);
            counts++;
        }

    }
}
