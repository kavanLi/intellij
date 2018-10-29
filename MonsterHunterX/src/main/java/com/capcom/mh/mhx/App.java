package com.capcom.mh.mhx;

/**
 * Created by Ritchie on 9/2/2017.
 */
public class App {

    // main
    public static void main(String[] args) {
        // launch game
        System.out.println("请选择需要加载的游戏");
        MhxGame mhxGame = new MhxGame();
        mhxGame.launch();
        mhxGame.exit();
    }
}
