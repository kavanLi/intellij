package pers.kavan.li;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Created by Ritchie in 12:19 2017/12/22.
 */
public class PlaneGameFrame extends MyFrame {
    Image bg = GameUtil.getImage("images/bg.jpg");
    Plane plane = new Plane("images/plane.png", 50, 50);

    //泛型暂时会学
    ArrayList <Bullet> bulletArrayList = new ArrayList <>();
    Explodation explodation;

    public void paint(Graphics graphics) {
        graphics.drawImage(bg, 0, 0, null);
        plane.draw(graphics);
        for (Bullet bullet : bulletArrayList) {
            bullet.draw(graphics);

            //检测碰撞
            boolean isBash = bullet.getRect().intersects(plane.getRect());
            //System.out.println(plane.getRect());
            //System.out.println(bullet.getRect());
            if (isBash) {
                System.out.println("鹏");
                plane.setLive(false);
                if (explodation == null) {
                    explodation = new Explodation(plane.x, plane.y);
                }
                explodation.draw(graphics);

                break;
            }

            if (!plane.isLive()) {

                printGameOver(graphics, "Over", 50);
            }
        }
    }


    public void printGameOver(Graphics graphics, String s, int size) {
        Color color = graphics.getColor();
        graphics.setColor(Color.white);
        Font font = new Font("宋体", Font.BOLD, size);
        graphics.setFont(font);
        graphics.drawString(s, 100, 200);

        graphics.setColor(color);
    }

    /**
     * 加载窗口
     */
    @Override
    public void launchFrame() {
        super.launchFrame();
        addKeyListener(new KeyMonitor());

        //生成一堆子弹
        for (int i = 0; i < 50; i++) {
            Bullet bullet = new Bullet();
            bulletArrayList.add(bullet);
        }
    }

    public static void main(String[] args) {
        new PlaneGameFrame().launchFrame();
    }

    /**
     * 定义为内部类, 一般只有外部类需要使用, 从属于外部类, 可以方便的使用外部类的普通属性
     */
    class KeyMonitor extends KeyAdapter {
        /**
         * Invoked when a key has been pressed.
         *
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("按下:" + e.getKeyCode());
            plane.addDirection(e);
            //plane.move(e);
        }

        /**
         * Invoked when a key has been released.
         *
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("松开:" + e.getKeyCode());
            plane.minusDirection(e);
        }
    }
}
