package pers.kavan.li;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import jdk.nashorn.internal.ir.WhileNode;
import sun.font.TrueTypeFont;

/**
 * Created by Ritchie in 20:32 2017/12/21.
 */
public class MyFrame extends Frame {

    /**
     * 加载窗口
     */
    public void launchFrame() {
        setSize(Constant.WIDTH, Constant.HEIGHT);
        setLocation(100, 100);
        setVisible(true);

        //启动重画线程
        new paintThread().start();

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

    /**
     * 定义一个内部类, 用于重画窗口.
     */
    class paintThread extends Thread {
        public void run() {
            while (true) {
                //外部类的方法
                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
