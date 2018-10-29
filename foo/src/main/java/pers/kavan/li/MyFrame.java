package pers.kavan.li;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Ritchie in 16:51 2017/12/21.
 */
public class MyFrame extends Frame {


    /**
     * 加载窗口
     */
    public void launchFrame() {
        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
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

    class PaintThread extends Thread {

        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);

        Graphics gOff = offScreenImage.getGraphics();

        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
