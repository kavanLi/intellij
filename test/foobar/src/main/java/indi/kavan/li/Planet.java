package indi.kavan.li;

import java.awt.*;

/**
 * Created by Ritchie in 17:30 2017/12/21.
 */
public class Planet extends Star {

    double longAxix;
    double shortAxis;
    double speed;
    double degree;
    Star center;

    boolean satelitte;

    public Planet(Star center, String path, double longAxix, double shortAxis, double speed) {
        this.longAxix = longAxix;
        this.shortAxis = shortAxis;
        this.speed = speed;
        this.center = center;
        this.x = center.x + longAxix;
        this.y = center.y;
        this.image = GameUtil.getImage(path);
    }

    public Planet(Star center, String path, double longAxix, double shortAxis, double speed, boolean isSatelitte) {
        this(center, path, longAxix, shortAxis, speed);
        this.satelitte = isSatelitte;
    }

    public Planet(String path, double x, double y) {
        super(path, x, y);
    }

    public void draw(Graphics graphics) {
        super.draw(graphics);
        if (satelitte) {
            drawTrace(graphics);
        }
        move();

    }

    public void drawTrace(Graphics graphics) {

        double width = longAxix * 2;
        double height = shortAxis * 2;
        double x = center.x - longAxix;
        double y = center.y - shortAxis;

        Color color = graphics.getColor();
        graphics.setColor(Color.BLUE);
        graphics.drawOval((int) x, (int) y, (int) width, (int) height);
        graphics.setColor(color);
    }

    public void move() {
        x = center.x + longAxix * Math.cos(degree);
        y = center.x + shortAxis * Math.sin(degree);

        degree += speed;
    }
}
