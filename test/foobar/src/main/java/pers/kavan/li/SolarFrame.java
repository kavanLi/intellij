package pers.kavan.li;

import java.awt.*;

/**
 * Created by Ritchie in 21:23 2017/12/21.
 */
public class SolarFrame extends MyFrame {
    Image bg = GameUtil.getImage("images/bg.jpg");
    Star sun = new Star("images/sun.jpg", Constant.WIDTH / 2, Constant.HEIGHT / 2);
    Planet earth = new Planet(150, 100, 0.1, "images/earth.jpg", sun);
    Planet mars = new Planet(200, 130, 0.3, "images/mars.jpg", sun);
    Planet moon = new Planet(30, 20, 0.1, "images/moon.jpg", earth, false);

    public void paint(Graphics graphics) {
        graphics.drawImage(bg, 0, 0, null);
        sun.draw(graphics);
        earth.draw(graphics);
        mars.draw(graphics);
        moon.draw(graphics);
    }

    public static void main(String[] args) {
        new SolarFrame().launchFrame();
    }
}
