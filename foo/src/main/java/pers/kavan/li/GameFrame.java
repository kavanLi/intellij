package pers.kavan.li;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Ritchie in 11:07 2017/12/17.
 */
@SuppressWarnings("ALL")
public class GameFrame extends Frame {
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

    @Override
    public void paint(Graphics g) {
        g.drawLine(100, 100, 200, 200);
        g.drawRect(100, 100, 250, 200);
        g.drawOval(100, 100, 250, 200);
        Color color = g.getColor();
        g.setColor(Color.YELLOW);

        Font font = new Font("微软雅黑", Font.BOLD, 100);
        g.setFont(font);

        g.drawString("sdf", 200, 200);
        g.fillRect(100, 100, 20, 20);
        g.setColor(color);

        g.drawImage(img, (int) x, (int) y, null);

        x += 3;
        y += 3;

    }

    class PaintThread extends Thread {

        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.launchFrame();

    }
}
