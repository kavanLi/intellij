package com.capcom.mh.monster;

/**
 * Created by Ritchie on 9/10/2017.
 */
public class FireDragon extends FlyingDragon {
    String name = "222";

    public FireDragon() {

    }

    public FireDragon(int a) {

    }

    public static void a() {
        System.out.println("123");
        //this.skyDive(); 不能直接直接访问所属类的实例变量和实例方法
    }

    public void dash() {
        //super.dash();
        System.out.println("雄火龙冲");

    }

    public void skyDive() {
        System.out.println("高空俯冲");
    }

    public void hoverAttack() {
        System.out.println("盘旋攻击");
    }

    public void echo() {
        System.out.println("我是雄火龙");
    }
}
