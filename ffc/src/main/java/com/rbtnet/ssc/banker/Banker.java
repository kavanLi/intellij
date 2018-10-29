package com.rbtnet.ssc.banker;

/**
 * @author 1136009436@qq.com
 */
public interface Banker {

    boolean login(String username, String password);

    boolean getCode();

    boolean doBet(String lottyid, String data, String adv);

    String getAdv();

    String getCountdown();

    Double balance();

    /**
     * 获取分分彩计划
     */
    String getFfc();

}
