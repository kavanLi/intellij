package indi.kavan.li;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.sun.deploy.net.proxy.RemoveCommentReader;
import com.sun.org.apache.bcel.internal.generic.GOTO;
import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;

/**
 * Created by Ritchie in 12:26 2017/12/22.
 */
public class Plane extends GameObject {


    private boolean left;
    private boolean up;
    private boolean right;
    private boolean down;


    private boolean isLive = true;

    public Plane() {
    }

    public Plane(Image image, double x, double y) {
        this.image = image;
        this.x = x;
        this.y = y;
        width = 30;
        System.out.println(image.getWidth(null));
        height = 30;
    }

    public Plane(String path, double x, double y) {
        this(GameUtil.getImage(path), x, y);
    }

    public void draw(Graphics graphics) {

        if (isLive) {
            graphics.drawImage(image, (int) x, (int) y, null);

            move();
        }


    }

    public void move() {

        if (left) {
            x -= speed;
        }
        if (right) {
            x += speed;
        }
        if (up) {
            y -= speed;
        }
        if (down) {
            y += speed;
        }
    }

    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            default:
                break;
        }
    }

    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            default:
                break;
        }
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
