package pers.kavan.li;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Ritchie in 11:07 2017/12/17.
 */
@SuppressWarnings("ALL")
public class GameFrame2 extends Frame {
    Image img = GameUtil.getImage("images/sun.jpg");
    int a = 123;

    /**
     * 加载窗口
     */
    public void launchFrame() {
        setSize(500, 500);
        setLocation(100, 100);
        setVisible(true);

        new PaintThread().start();

        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

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

    class PaintThread extends Thread {

        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        GameFrame2 gameFrame = new GameFrame2();
        gameFrame.launchFrame();

    }
}
