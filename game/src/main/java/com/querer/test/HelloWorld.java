package com.querer.test;

import java.util.Random;

import com.querer.test.com.Dragon;
import com.querer.test.com.Student;

/**
 * Created by Ritchie on 2017/8/12.
 */
public class HelloWorld {

    public static void main(String[] args) {

        //String silverDragonCode = "09";
        //String goldenDragonCode = "08";
        //String maleDragonCode = "01";
        Dragon newBornDragon = buildDragon("09");
        System.out.println(newBornDragon.toString());

        killDragon(newBornDragon);
    }

    private static Dragon buildDragon(String type) {

        Dragon newBornDragon = null;

        if ("01".equalsIgnoreCase(type)) {
            Dragon maleDragon = new Dragon();
            maleDragon.setName("雄火龙");
            maleDragon.setType("01");
            maleDragon.setLife(2000);
            maleDragon.setLength(30.89);
            maleDragon.setHeight(19.25);
            newBornDragon = maleDragon;

        } else if ("09".equalsIgnoreCase(type)) {
            Dragon silverDragon = new Dragon();
            silverDragon.setName("银火龙");
            silverDragon.setType("09");
            silverDragon.setLife(4889);
            silverDragon.setLength(35.67);
            silverDragon.setHeight(23.66);

            newBornDragon = silverDragon;

        } else if ("08".equalsIgnoreCase(type)) {
            Dragon goldenDragon = new Dragon();
            goldenDragon.setName("金火龙");
            goldenDragon.setType("08");
            goldenDragon.setLife(5555);
            goldenDragon.setLength(37.67);
            goldenDragon.setHeight(28.66);

            newBornDragon = goldenDragon;
        }
        return newBornDragon;
    }

    // focus to kill this dragon
    private static void killDragon(Dragon dragon) {
        for (int i = 0; i < 100; i++) {
            // step 1 - get damage value between 20~100
            Random rand = new Random();
            int damage = rand.nextInt(100) + 20;
            //int damage = 20 + (int)(Math.random() * 80);
            // step 2 - print out the damage value
            int times = i + 1;
            System.out.println("猎人第" + times + "次攻击" + dragon.getName() + "造成伤害值：" + damage);


            // step 3 - calc left life value of dragon get hurt with damage value
            int dqxl = dragon.getLife();
            System.out.println(dragon.getName() + "当前的血量：" + dqxl);
            System.out.println(dragon.getName() + "受到第" + times + "攻击点数：" + damage);

            int leftLifeValue = dragon.getLife() - damage;
            dragon.setLife(leftLifeValue);

            // step 4 - print out the left life value of dragon
            System.out.println(dragon.getName() + "剩余血量：" + dragon.getLife());
            if (leftLifeValue <= 0) {
                System.out.println("第" + (i + 1) + "次攻击火龙死亡，任务结束");
                break;

            }


        }


    }


    //private static void oneHurt(Dragon dragon) {
    //    // step 1 - get damage value between 20~100
    //    Random rand = new Random();
    //    int damage = rand.nextInt(100) + 20;
    //    //int damage = 20 + (int)(Math.random() * 80);
    //    // step 2 - print out the damage value
    //    System.out.println("猎人攻击" + dragon.getName() + "造成伤害值：" + damage);
    //
    //
    //    // step 3 - calc left life value of dragon get hurt with damage value
    //    int dqxl = dragon.getLife();
    //    System.out.println(dragon.getName() + "当前的血量：" + dqxl);
    //    System.out.println(dragon.getName() + "受到攻击点数：" + damage);
    //
    //    int leftLifeValue = dragon.getLife() - damage;
    //    dragon.setLife(leftLifeValue);
    //
    //    // step 4 - print out the left life value of dragon
    //    System.out.println(dragon.getName() + "剩余血量：" + dragon.getLife());
    //
    //}
}