package com.capcom.mh.mhx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.capcom.mh.monster.Monster;
import com.capcom.mh.monster.SilverSun;

/**
 * Created by Ritchie on 9/2/2017.
 */
public class Map {
    private String name;
    private Monster monster;
    private Hunter hunter;
    private Zoom zoom;
    private ArrayList <Zoom> zoomList;
    //private List<Zoom> zoomL ist = new ArrayList<Zoom>(10);

    public Map(String name) {
        this.name = name;
    }

    //public Map(MhxGame mhxGame) {
    //    this.game = mhxGame;
    //    this.initialize();
    //}

    public void initialize() {
        //System.out.println("地图为" + this.name);
        this.zoomList = new ArrayList <Zoom>();
        //zoomList = new ArrayList<Zoom>();
        //this.zoom = new Zoom();
        //this.zoom.setZoomlist(new ArrayList<Zoom>());
        for (int i = 0; i < 10; i++) {
            //this.zoom = new Zoom();
            this.zoomList.add(i, new Zoom());
            System.out.println("地图" + i + "区初始化完成");
        }

        this.monster = new SilverSun();
        this.monster.setName("银火龙");
        this.monster.setHeight(7.33);
        this.monster.setLength(33.33);
        this.monster.setWeight(4444.44);
        this.monster.setHp(5000);
        System.out.println(this.monster.toString());
        this.hunter = new Hunter();
        System.out.println(this.hunter.toString());

        generateBornZoom(this.monster, this.hunter);
    }

    public void generateBornZoom(Monster monster, Hunter hunter) {
        int a = 0;
        int b = 0;
        this.zoomList.get(3).loadMonster(this.monster);
        System.out.println(this.monster.getName() + "出生在3区");
        this.zoomList.get(4).loadHunter(hunter);
        System.out.println(this.hunter.getName() + "出生在4区");
        while (true) {
            a = new Random().nextInt(10);
            b = new Random().nextInt(10);
            Zoom zoom = this.zoomList.get(a);
            zoom.loadMonster(this.monster);
            //this.zoomList.get(a).setDragon(dragon);
            System.out.println(this.monster.getName() + "移动到了" + a + "区");
            this.zoomList.get(b).loadHunter(hunter);
            System.out.println(this.hunter.getName() + "移动到了" + b + "区");
            if (a == b) {
                this.zoom = zoomList.get(a);
                System.out.println("在" + a + "区遭遇，并发生了战斗");
                kickOff();
                break;
            }
        }
        //Zoom.
        // zoom 3, set dragon
        //this.zoom.getNumber();
        // zoom 4  set hunter
        // random choose zooms for dragon and hunter
    }

    public void kickOff() {
        //for (Zoom zoom : zoomList) {
        //    zoom.startBattle();
        //}
        //this.zoom.startBattle(this.dragon,this.hunter);
        String result = this.zoom.startBattle(this.monster, this.hunter);
        System.out.println(result);
        //if (this.dragon.getHp() < 0) {
        //    // mission complete
        //
        //    dispose();
        //
        //    this.game.exit();
        //}
    }

    public void dispose() {
        this.monster = null;
        this.hunter = null;
        this.zoom = null;
        // notify game exit;
        System.out.println("dragon,hunter和zoom初始化完成");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hunter getHunter() {
        return hunter;
    }

    public void setHunter(Hunter hunter) {
        this.hunter = hunter;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

}
