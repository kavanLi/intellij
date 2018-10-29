package com.capcom.mh.mhx;

import java.util.ArrayList;

import com.capcom.mh.monster.Monster;

/**
 * Created by Ritchie on 9/2/2017.
 */
public class Zoom {


    //private int number;
    //private ArrayList<Zoom> zoomList;
    //private Monster monster;//
    //private Hunter hunter;//这两行还是需要的
    //private ArrayList<Zoom> zoomList;

    public String startBattle(Monster monster, Hunter hunter) {
        //this.dragon = dragon;
        //this.hunter = hunter;
        String result = null;
        if (monster != null && hunter != null) {
            // hit 300 times
            int hp = monster.getHp();
            int timesOfAttack = 0;
            while (hp >= 0) {
                int damage = hunter.attack();
                hp = hp - damage;
                monster.setHp(hp);
                timesOfAttack++;
                System.out.println(hunter.getName() + "第" + timesOfAttack + "次攻击" + monster.getName() + ",造成伤害" + damage + "点");
                if (hp > 0) {
                    System.out.println(monster.getName() + "剩余" + hp + "生命值");
                } else if (hp <= 0) {
                    System.out.println(monster.getName() + "死亡");
                    result = "victory";
                }
            }
        }
        return result;
    }

    public void loadMonster(Monster monster) {

    }

    public void loadHunter(Hunter hunter) {

    }
    //public ArrayList<Zoom> getZoomlList() {
    //    return zoomList;
    //}
    //
    //public void setZoomlist(ArrayList<Zoom> zoomList) {
    //    this.zoomList = zoomList;
    //}

    //public int getNumber() {
    //    return number;
    //}
    //
    //public void setNumber(int number) {
    //    this.number = number;
    //}

    //public Monster getMonster() {
    //    return monster;
    //}
    //
    //public void setMonster(Monster monster) {
    //    this.monster = monster;
    //}
    //
    //public Hunter getHunter() {
    //    return hunter;
    //}
    //
    //public void setHunter(Hunter hunter) {
    //    this.hunter = hunter;
    //}
}
