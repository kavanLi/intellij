package indi.kavan.li;

import java.awt.*;

/**
 * Created by Ritchie in 17:20 2017/12/21.
 */
public class Star {
    Image image;
    double x;
    double y;

    public Star() {

    }

    public Star(String path, double x, double y) {
        this.image = GameUtil.getImage(path);
        this.x = x;
        this.y = y;
    }


    public void draw(Graphics graphics) {
        graphics.drawImage(image, (int) x, (int) y, null);
    }

}
