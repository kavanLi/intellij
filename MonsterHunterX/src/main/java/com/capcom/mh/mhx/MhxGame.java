package com.capcom.mh.mhx;

import java.util.ArrayList;

/**
 * Created by Ritchie on 9/2/2017.
 */
public class MhxGame {
    private Map map;

    public void launch() {
        // start game
        System.out.println("加载游戏mhx");
        ArrayList <Map> mapList = new ArrayList <Map>();
        Map jungle = new Map("jungle");
        Map volcano = new Map("volcano");
        Map tower = new Map("tower");
        mapList.add(jungle);
        mapList.add(volcano);
        mapList.add(tower);
        this.map = mapList.get(1);
        System.out.println("加载地图" + mapList.get(1).getName());
        mapList.get(1).initialize();
        //map.kickOff();
    }

    public void exit() {
        // quit the game
        this.map.dispose();
        this.map = null;
        System.out.println("地图初始化完成");
        System.out.println("全体初始化,退出游戏");
    }
}
