package com.rbtnet.ssc.ticket.strategy;

import com.alibaba.fastjson.JSON;
import com.rbtnet.ssc.ticket.Ticket;
import com.rbtnet.ssc.utils.HttpUtils;

/**
 * @author langhsu
 */
public class FFCTicketStrategy implements Ticket {
    HttpUtils httpUtils = new HttpUtils();

    // 上期计划
    private String prev = "";

    public String produce() {
        String url = "http://774444.cc/json/ffc.json";
        try {
            String entity = httpUtils.get(url);

            // 获取本期计划
            Object gameMultiple = JSON.parseObject(entity).get("GameMultiple");
            String ffc = JSON.parseObject(gameMultiple.toString()).get("num").toString();

            if (ffc != null && ffc.trim().length() > 0) {
                prev = ffc;
            }
            System.out.println("分析号码:" + ffc);
            return ffc;
        } catch (Exception e) {
            e.printStackTrace();

            // 如果出错，返回上次结果
            return prev;
        }
    }

}
