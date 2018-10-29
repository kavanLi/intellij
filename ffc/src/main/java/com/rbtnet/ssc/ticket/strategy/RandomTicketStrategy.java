package com.rbtnet.ssc.ticket.strategy;

import com.rbtnet.ssc.ticket.Ticket;

/**
 * @author 1136009436@qq.com
 */
public class RandomTicketStrategy implements Ticket {

    public String produce() {
        String ffc = "";
        while (ffc.length() < 5) {
            int random = randomOneValue();
            if (ffc.indexOf(String.valueOf(random)) < 0) {
                ffc += random;
            }
        }
        System.out.println("机选号码:" + ffc);
        return ffc;
    }

    /**
     * 随机选取
     * <p>
     * 获取0~9其中一个数
     */
    private static int randomOneValue() {
        int randomValue = (int) (Math.random() * 10);
        return randomValue;
    }
}
