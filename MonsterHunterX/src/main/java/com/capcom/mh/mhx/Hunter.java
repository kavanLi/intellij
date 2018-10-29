package com.capcom.mh.mhx;

import java.util.Random;

/**
 * Created by Ritchie on 9/2/2017.
 */
public class Hunter {

    private String name;
    private String gender;
    private String weapon;

    public Hunter() {
        this.name = "legendHunter";
        this.gender = "female";
        this.weapon = "水果刀";

    }

    public String toString() {
        return "Hunter初始化{" + "name=" + name +
                ", gender=" + gender +
                ", weapon=" + weapon +
                '}';
    }

    public int attack() {
        //int damage = 0;
        int damage = 0;
        if (this.weapon.equals("水果刀")) {
            damage = new Random().nextInt(100) + 50;
        }
        return damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
