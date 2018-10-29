package com.rbtnet.ssc;

import com.rbtnet.ssc.banker.Banker;
import com.rbtnet.ssc.banker.provider.B365Provider;
import com.rbtnet.ssc.ticket.Ticket;
import com.rbtnet.ssc.ticket.strategy.RandomTicketStrategy;

import java.util.Scanner;

/**
 * @author 1136009436@qq.com
 */
public class Client {

    private static int count = 0; // 统计投注次数
    private static int win = -1; // 胜利次数
    private static int jiabei = 5; // 加倍
    private static int step = 0; // 不下单
    private static Boolean isFail = false;
    private static Double balance = 0.0;

    public static void main(String[] args) {
        Banker banker = new B365Provider();
        Ticket ticket = new RandomTicketStrategy();
        Scanner in = new Scanner(System.in);
        System.out.println("用户名：");
        String username = in.nextLine();
        System.out.println("密码：");
        String password = in.nextLine();
        System.out.println("下注单位(分-100；角-10):");
        int unit = in.nextInt();
        System.out.println("失败后停止下单次数：");
        int stp = in.nextInt();
        System.out.println("加倍数：");
        jiabei = in.nextInt() + 1;
        int jb = jiabei - 1;
        banker.login(username, password);

        Double initBalance = banker.balance(); // 初始账号余额

        while (true) {

            System.out.println("盈利：" + (banker.balance() - initBalance));

            if (balance < banker.balance()) {
                win++;
                jiabei--;
                if (jiabei < 1) {
                    jiabei = 1;
                }
            } else {
                isFail = true;
                step++;
                if (step == stp + 1) {
                    step = 0;
                    isFail = false;
                    jiabei = jb;
                }
            }

            String lottyid = banker.getCountdown();
            String adv = banker.getAdv();

            String bill = ticket.produce();

            //String[] data = {"[\"37|1|112345|1|110|5|100|,,,,"+bill+"\"]","[\"37|1|112345|1|110|5|10|,,,,"+bill+"\"]"};
            // String data = "[\"37|1|112345|1|110|5|10|,,,,"+bill+"\"]"; // 5角

            String data = "[\"37|1|112345|" + jiabei + "|110|5|" + unit + "|,,,," + bill + "\"]";  //5分
            //int random = (int) (Math.random() * 2);
            if (!isFail) {
                count++;
                banker.doBet(lottyid, data, adv);
            } else {
                System.out.println("不下单" + step + "次");
            }

            balance = banker.balance();
            System.out.println("余额：" + balance);
            System.out.println("获胜场次:" + "(" + win + "/" + count + ")");
            System.out.println("加倍:" + jiabei);
            System.out.println("-------------------------------");
            ;
            try {
                Thread.sleep(1000 * 60);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
