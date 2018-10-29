package pers.kavan.li;

import java.awt.*;

/**
 * Created by Ritchie in 14:32 2017/12/22.
 */
public class GameObject {

    Image image;
    double x;
    double y;
    int speed = 3;

    int width;
    int height;

    public GameObject() {
    }

    public Rectangle getRect() {
        Rectangle rectangle = new Rectangle((int) x, (int) y, width, height);
        return rectangle;
    }
}
