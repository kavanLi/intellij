package com.kavan.mounsterhunter;

import java.util.Random;
import java.util.Scanner;

import javax.lang.model.element.NestingKind;

/**
 * Created by Ritchie on 8/30/2017.
 */
public class KillMonster {
    WantedMonster monsterkiller;

    void killing() {
        monsterkiller = new WantedMonster();
        monsterkiller.chooseMonster();
        System.out.println("以下列出怪物对应的编号");
        System.out.println("00是:大怪鸟");
        System.out.println("01是:黑狼鸟");
        System.out.println("02是:桃毛兽");
        System.out.println("03是:金狮子");
        System.out.println("04是:激昂金狮子");
        System.out.println("05是:轰龙");
        System.out.println("06是:雌火龙");
        System.out.println("07是:雄火龙");
        System.out.println("08是:金火龙");
        System.out.println("09是:银火龙");
        System.out.println("10是:麒麟");
        System.out.println("11是:钢龙");
        System.out.println("12是:炎王龙");
        System.out.println("13是:红黑龙");
        System.out.println("14是:祖龙");
        System.out.println("随机到的怪物是:");
        String[] needToKillMonster = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"};
        int choice = new Random().nextInt(14);
        WantedMonster newBornMonster = buildMonster(needToKillMonster[choice]);
        System.out.println(newBornMonster.toString());
        killMonster(newBornMonster);
    }

    private static WantedMonster buildMonster(String type) {

        WantedMonster newBornMonster = null;

        if ("00".equalsIgnoreCase(type)) {
            WantedMonster strangeBird = new WantedMonster();
            strangeBird.setType("00");
            strangeBird.setSpecies("bird");
            strangeBird.setName("大怪鸟");
            strangeBird.setHabit("jungle,forestAndHill");
            strangeBird.setLife(1998);

            newBornMonster = strangeBird;

        } else if ("01".equalsIgnoreCase(type)) {
            WantedMonster blackWolfBird = new WantedMonster();
            blackWolfBird.setType("01");
            blackWolfBird.setSpecies("bird");
            blackWolfBird.setName("黑狼鸟");
            blackWolfBird.setHabit("jungle,forestAndHill");
            blackWolfBird.setLife(4400);

            newBornMonster = blackWolfBird;
        } else if ("02".equalsIgnoreCase(type)) {
            WantedMonster pinkFurBeast = new WantedMonster();
            pinkFurBeast.setType("02");
            pinkFurBeast.setSpecies("fangedBeast");
            pinkFurBeast.setName("桃毛兽");
            pinkFurBeast.setHabit("jungle,swamp");
            pinkFurBeast.setLife(5460);

            newBornMonster = pinkFurBeast;
        } else if ("03".equalsIgnoreCase(type)) {
            WantedMonster goldLion = new WantedMonster();
            goldLion.setType("03");
            goldLion.setSpecies("fangedBeast");
            goldLion.setName("金狮子");
            goldLion.setHabit("snowyMountains,volcano");
            goldLion.setLife(4860);

            newBornMonster = goldLion;
        } else if ("04".equalsIgnoreCase(type)) {
            WantedMonster ultraGoldLion = new WantedMonster();
            ultraGoldLion.setType("04");
            ultraGoldLion.setSpecies("fangedBeast");
            ultraGoldLion.setName("激昂金狮子");
            ultraGoldLion.setHabit("jungle,swamp");
            ultraGoldLion.setLife(7020);

            newBornMonster = ultraGoldLion;
        } else if ("05".equalsIgnoreCase(type)) {
            WantedMonster roaringDragon = new WantedMonster();
            roaringDragon.setType("05");
            roaringDragon.setSpecies("flyingDragon");
            roaringDragon.setName("轰龙");
            roaringDragon.setHabit("snowyMountains,desert");
            roaringDragon.setLife(7600);

            newBornMonster = roaringDragon;
        } else if ("06".equalsIgnoreCase(type)) {
            WantedMonster femaleFireDragon = new WantedMonster();
            femaleFireDragon.setType("06");
            femaleFireDragon.setSpecies("flyingDragon");
            femaleFireDragon.setName("雌火龙");
            femaleFireDragon.setHabit("jungle,forestAndHill,swamp");
            femaleFireDragon.setLife(7800);

            newBornMonster = femaleFireDragon;
        } else if ("07".equalsIgnoreCase(type)) {
            WantedMonster fireDragon = new WantedMonster();
            fireDragon.setType("07");
            fireDragon.setSpecies("flyingDragon");
            fireDragon.setName("雄火龙");
            fireDragon.setHabit("forestAndHill,volcano");
            fireDragon.setLife(6240);

            newBornMonster = fireDragon;
        } else if ("08".equalsIgnoreCase(type)) {
            WantedMonster goldMoon = new WantedMonster();
            goldMoon.setType("08");
            goldMoon.setSpecies("flyingDragon");
            goldMoon.setName("金火龙");
            goldMoon.setHabit("tower,greatArena,swamp");
            goldMoon.setLife(8800);

            newBornMonster = goldMoon;
        } else if ("09".equalsIgnoreCase(type)) {
            WantedMonster silverSun = new WantedMonster();
            silverSun.setType("09");
            silverSun.setSpecies("flyingDragon");
            silverSun.setName("银火龙");
            silverSun.setHabit("tower,greatArena,swamp");
            silverSun.setLife(7600);

            newBornMonster = silverSun;
        } else if ("10".equalsIgnoreCase(type)) {
            WantedMonster phantomBeast = new WantedMonster();
            phantomBeast.setType("10");
            phantomBeast.setSpecies("elderDragon");
            phantomBeast.setName("麒麟");
            phantomBeast.setHabit("snowyMountains,tower");
            phantomBeast.setLife(6080);

            newBornMonster = phantomBeast;
        } else if ("11".equalsIgnoreCase(type)) {
            WantedMonster steelDragon = new WantedMonster();
            steelDragon.setType("11");
            steelDragon.setSpecies("elderDragon");
            steelDragon.setName("钢龙");
            steelDragon.setHabit("jungle,snowyMountains");
            steelDragon.setLife(13650);

            newBornMonster = steelDragon;
        } else if ("12".equalsIgnoreCase(type)) {
            WantedMonster flameKingDragon = new WantedMonster();
            flameKingDragon.setType("12");
            flameKingDragon.setSpecies("elderDragon");
            flameKingDragon.setName("炎王龙");
            flameKingDragon.setHabit("volcano,tower");
            flameKingDragon.setLife(14625);

            newBornMonster = flameKingDragon;
        } else if ("13".equalsIgnoreCase(type)) {
            WantedMonster redBlackDragon = new WantedMonster();
            redBlackDragon.setType("13");
            redBlackDragon.setSpecies("elderDragon");
            redBlackDragon.setName("红黑龙");
            redBlackDragon.setHabit("battleGround");
            redBlackDragon.setLife(26000);

            newBornMonster = redBlackDragon;
        } else if ("14".equalsIgnoreCase(type)) {
            WantedMonster ancestralDragon = new WantedMonster();
            ancestralDragon.setType("14");
            ancestralDragon.setSpecies("elderDragon");
            ancestralDragon.setName("祖龙");
            ancestralDragon.setHabit("tower");
            ancestralDragon.setLife(26000);

            newBornMonster = ancestralDragon;
        }
        return newBornMonster;
    }

    private static void killMonster(WantedMonster monster) {
        System.out.print("请选择你想使用的武器:可以选择大剑,太刀或弓箭,请输入:");
        Scanner in = new Scanner(System.in);
        String weapon_use;
        while (true) {
            weapon_use = in.nextLine();
            if (weapon_use.equals("大剑")) {
                System.out.println("武器大剑已佩戴");
                break;
            } else if (weapon_use.equals("太刀")) {
                System.out.println("武器太刀已配带");
                break;
            } else if (weapon_use.equals("弓箭")) {
                System.out.println("武器弓箭已佩戴");
                break;
            }
            System.out.println("无法识别,输入错误,请重新输入武器名字:");
        }

        int damage = 0;
        Random rand = new Random();
        if (weapon_use.equals("大剑")) {
            damage = rand.nextInt(150) + 50;
        } else if (weapon_use.equals("太刀")) {
            damage = rand.nextInt(90) + 30;
        } else if (weapon_use.equals("弓箭")) {
            damage = rand.nextInt(60) + 20;
        }
        for (int i = 0; i < 300; i++) {
            // step 1 - get damage value between 20~100

            //int damage = 20 + (int)(Math.random() * 80);
            // step 2 - print out the damage value
            int times = i + 1;
            System.out.println("猎人第" + times + "次攻击" + monster.getName() + "造成伤害值：" + damage);

            // step 3 - calc left life value of dragon get hurt with damage value
            int dqxl = monster.getLife();
            System.out.println(monster.getName() + "当前的血量：" + dqxl);
            System.out.println(monster.getName() + "受到第" + times + "次攻击点数：" + damage);

            int leftLifeValue = monster.getLife() - damage;
            monster.setLife(leftLifeValue);

            // step 4 - print out the left life value of dragon
            System.out.println(monster.getName() + "剩余血量：" + monster.getLife());
            if (leftLifeValue <= 0) {
                System.out.println("第" + (i + 1) + "次攻击" + monster.getName() + "死亡，任务结束");
                break;

            }


        }


    }


}
