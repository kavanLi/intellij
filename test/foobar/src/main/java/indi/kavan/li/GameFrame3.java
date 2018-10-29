package indi.kavan.li;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Ritchie in 11:07 2017/12/17.
 */
@SuppressWarnings("ALL")
public class GameFrame3 extends MyFrame {

    Image img = GameUtil.getImage("images/sun.jpg");
    int a = 123;

    private double x = 100;
    private double y = 100;
    private boolean left = true;


    @Override
    public void paint(Graphics g) {

        g.drawImage(img, (int) x, (int) y, null);

        if (left) {
            x += 3;
            if (x > 300) {
                left = false;
            }
        } else {
            x -= 3;
            if (x <= 3) {
                left = true;
            }
        }
        //y += 3;
    }


    public static void main(String[] args) {
        GameFrame3 gameFrame = new GameFrame3();
        gameFrame.launchFrame();

    }
}
