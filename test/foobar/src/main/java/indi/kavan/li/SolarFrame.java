package indi.kavan.li;

import java.awt.*;

import com.sun.javafx.sg.prism.web.NGWebView;

/**
 * Created by Ritchie in 17:15 2017/12/21.
 */
public class SolarFrame extends MyFrame {
    Image bg = GameUtil.getImage("images/bg.jpg");
    Star sun = new Star("images/sun.jpg", Constant.GAME_WIDTH / 2, Constant.GAME_HEIGHT / 2);
    Planet earth = new Planet(sun, "images/earth.jpg", 150, 100, 0.1);
    Planet mars = new Planet(sun, "images/mars.jpg", 200, 130, 0.2);
    Planet moon = new Planet(earth, "images/moon.jpg", 30, 20, 0.1, true);

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
