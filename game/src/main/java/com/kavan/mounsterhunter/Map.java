package com.kavan.mounsterhunter;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Ritchie on 8/30/2017.
 */
public class Map {
    Hunter player;
    String map_name = null;

    void chooseMap() {
        player = new Hunter();
        player.setUpRole();
        System.out.println("以下列出地图编号对应的地图");
        System.out.println("0是desert");
        System.out.println("1是snowyMountains");
        System.out.println("2是jungle");
        System.out.println("3是swamp");
        System.out.println("4是volcano");
        System.out.println("5是forestAndHill");
        System.out.println("6是greatArena");
        System.out.println("7是tower");
        System.out.println("8是battleGround");
        System.out.println("现在需要选择游戏地图,请输入地图编号:");
        String[] map_list = {"desert", "snowyMountains", "jungle", "swamp", "volcano", "forestAndHill", "greatArena", "tower", "battleGround"};
        Scanner in = new Scanner(System.in);
        int map_dig = in.nextInt();
        System.out.println("地图选择" + map_list[map_dig]);
        map_name = map_list[map_dig];
        int daytime = new Random().nextInt(2);
        if (daytime == 0) {
            System.out.println("地图随机到的时间段是白天");
        } else if (daytime == 1) {
            System.out.println("地图随机到的时间段是夜晚");
        }
        System.out.println("And,Please choose a monster which you want to hunt!");
    }

}

//Scanner mapName = new Scanner(System.in);
//int mapNum = mapName.nextInt();
//if (mapNum == 0)
//{
//    System.out.println("地图选择desert");
//}
//else if (mapNum == 1)
//{
//    System.out.println("地图选择snowyMountains");
//}
//else if (mapNum == 2)
//{
//    System.out.println("地图选择jungle");
//}
//else if (mapNum == 3)
//{
//    System.out.println("地图选择swamp");
//}else if (mapNum == 4)
//{
//    System.out.println("地图选择volcano");
//}else if (mapNum == 5)
//{
//    System.out.println("地图选择forestAndHill");
//}else if (mapNum == 6)
//{
//    System.out.println("地图选择greatArena");
//}else if (mapNum == 7)
//{
//    System.out.println("地图选择tower");
//}else if (mapNum == 8)
//{
//    System.out.println("地图选择battleGround");
//}

