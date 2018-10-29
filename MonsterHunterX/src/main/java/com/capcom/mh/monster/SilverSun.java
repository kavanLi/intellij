package com.capcom.mh.monster;

import com.capcom.mh.monster.FireDragon;

/**
 * Created by Ritchie on 9/10/2017.
 */
public class SilverSun extends FireDragon {

    final static public int b = 0;

    public static void a() {
        System.out.println("232332");
        //this.skyDive(); 不能直接直接访问所属类的实例变量和实例方法,栈溢出就是死循环?


    }

    public void echo() {
        System.out.println("我是银火龙");
    }

    public void dash() {
        System.out.println(b);
        System.out.println("银火龙冲");
    }

    public void skyDive() {
        System.out.println("加强高空俯冲");
        this.skyDive();
    }

    public void hoverAttack() {
        System.out.println("加强盘旋攻击");
    }

    final public void hoverAttcak(int a) {
        System.out.println(a);
    }
}
