package com.capcom.mh.monster;

/**
 * Created by Ritchie on 9/10/2017.
 */
public class FlyingDragon extends Monster {
    //private FlyingDragon() {
    //    super();
    //}

    //public String getName() {
    //    return this.name;
    //}
    //
    //@Override
    //public void setName(String name) {
    //    this.name = name;
    //}

    public String name = "321";


    // private FlyingDragon() {
    //    System.out.println("FlyingDragon");
    //}

    public void bite() {
        System.out.println("bite" + name);
    }

    public void drift() {
        System.out.println("drift");
    }

    public void spitFireBall() {
        System.out.println("spitFireBall");
    }

    public void poisonThorn() {
        System.out.println("毒刺");
    }
}


