package indi.kavan.li;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.text.CollationElementIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Ritchie in 13:13 2017/12/22.
 */
public class Bullet extends GameObject {

    double degree;


    public Bullet() {
        degree = Math.random() * Math.PI * 2;
        x = Constant.GAME_WIDTH / 2;
        y = Constant.GAME_HEIGHT / 2;
        width = 10;
        height = 10;
    }

    public Bullet(double x, double y, int speed, double degree) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.degree = degree;
    }

    public void draw(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.YELLOW);
        graphics.fillOval((int) x, (int) y, width, height);

        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);

        if (y > Constant.GAME_HEIGHT - height || y < 30) {
            degree = -degree;
        }

        if (x < 0 || x > Constant.GAME_WIDTH - width) {
            degree = Math.PI - degree;
        }

        graphics.setColor(color);
    }
}
