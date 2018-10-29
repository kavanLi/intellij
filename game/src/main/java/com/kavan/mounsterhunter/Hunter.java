package com.kavan.mounsterhunter;

import java.util.Scanner;

/**
 * Created by Ritchie on 8/30/2017.
 */
public class Hunter {
    String playerAccount;
    int a = 0;

    void setUpRole() {
        while (true) {
            System.out.print("游戏创建,请输入你的性别,数字0是男性,数字1是女性(只能输入整数否者会报错):");
            Scanner in = new Scanner(System.in);
            while (true) {
                int gender = in.nextInt();
                if (gender == 0) {
                    System.out.println("男性角色读取中");
                    break;
                } else if (gender == 1) {
                    System.out.println("女性角色读取中");
                    break;
                }
                System.out.println("输入错误请重新输入(0代表男性,1代表女性):");

            }
            System.out.print("请输入你的名字:");
            String name = in.next();
            System.out.println("猎人的名字:" + name + ",已保存");
            System.out.print("猎人初始设定已完成,是否要重新设定,数字0代表重新设定,数字1代表完成设定.请输入:");
            int confirm = in.nextInt();
            if (confirm == 0) {
                System.out.println("正在初始化...");
            } else if (confirm == 1) {
                System.out.println("正在保存设定...");
                System.out.println("Loading.......");
                System.out.println("Welcome to Monster Hunter!Enjoy yourself!");
                break;
            }

        }

    }
}
