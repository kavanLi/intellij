package pers.kavan.li;

import java.awt.*;

/**
 * Created by Ritchie in 20:29 2017/12/21.
 */
public class GameUtil {
    /**
     * 工具类的最好将构造器私有
     */
    private GameUtil() {
    }

    public static Image getImage(String path) {
        Image image = Toolkit.getDefaultToolkit().getImage(path);
        return image;
    }
}
