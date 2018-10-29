package pers.kavan.li;

import java.awt.*;

/**
 * Created by Ritchie in 21:26 2017/12/21.
 */
public class Star {
    Image image;
    double x;
    double y;

    public Star(Image image, double x, double y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public Star(String path, double x, double y) {
        this(GameUtil.getImage(path), x, y);
    }

    public Star() {
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, (int) x, (int) y, null);
    }
}
