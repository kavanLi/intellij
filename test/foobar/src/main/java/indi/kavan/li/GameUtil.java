package indi.kavan.li;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Created by Ritchie in 20:56 2017/12/17.
 * 游戏中常用的工具类
 */
public class GameUtil {
    /**
     * 工具类最好将构造器私有
     */
    private GameUtil() {

    }

    public static Image getImage(String path) {
        Image image = Toolkit.getDefaultToolkit().getImage(path);
        return image;
    }
}
