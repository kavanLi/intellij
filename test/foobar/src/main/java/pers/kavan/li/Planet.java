package pers.kavan.li;

import java.awt.*;

import indi.kavan.li.GameUtil;

/**
 * Created by Ritchie in 21:39 2017/12/21.
 */
public class Planet extends Star {
    double longAxis;  //椭圆的长轴
    double shortAxis;  //椭圆的短轴
    double speed;     //飞行的速度
    double degree;
    Star center;

    boolean satellite = true;

    public Planet() {

    }

    public Planet(double longAxis, double shortAxis, double speed, String path, Star center) {
        this.center = center;
        this.x = center.x + longAxis;
        this.y = center.y;

        this.longAxis = longAxis;
        this.shortAxis = shortAxis;
        this.speed = speed;
        this.image = GameUtil.getImage(path);
    }

    public Planet(double longAxis, double shortAxis, double speed, String path, Star center, boolean satellite) {
        this(longAxis, shortAxis, speed, path, center);
        this.satellite = satellite;
    }

    public void draw(Graphics graphics) {
        super.draw(graphics);
        if (satellite) {
            drawTrace(graphics);
        }
        move();
    }

    public void move() {
        x = center.x + longAxis * Math.cos(degree);
        y = center.x + shortAxis * Math.sin(degree);

        degree += speed;
    }

    public void drawTrace(Graphics graphics) {
        double width = longAxis * 2;
        double height = shortAxis * 2;
        double x = center.x - longAxis;
        double y = center.y - shortAxis;

        Color color = graphics.getColor();
        graphics.setColor(Color.BLUE);
        graphics.drawOval((int) x, (int) y, (int) width, (int) height);
        graphics.setColor(color);
    }

}
