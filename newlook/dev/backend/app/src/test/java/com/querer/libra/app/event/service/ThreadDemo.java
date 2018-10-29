package com.querer.libra.app.event.service;

import java.util.Date;

import com.querer.libra.app.event.domain.model.EventModel;
import com.querer.libra.app.event.domain.model.UserCouponModel;
import com.querer.libra.app.event.service.business.UserCouponBizService;
import com.querer.libra.platform.code.UniqueCodeGenerator;
import com.querer.libra.platform.code.impl.DefaultUniqueCodeGeneratorImpl;
import com.querer.libra.platform.core.test.BaseServiceIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ritchie on 9/10/2017.
 */
public class ThreadDemo extends BaseServiceIntegrationTest implements Runnable {

    @Autowired
    UserCouponBizService userCouponBizService;

    @Override
    public void run() {
        testBatchDrawCoupon();
    }

    /**
     * 抽奖测试.
     */
    @Test
    public void testBatchDrawCoupon() {
        //newlook实体店对应的openingCode.
        String openingCode = "nl7mokzukhwhY1NNCP";
        //声明一个UniqueCodeGenerator对象,用于生成uid.
        UniqueCodeGenerator uniqueCodeGenerator = new DefaultUniqueCodeGeneratorImpl();
        //多次抽奖测试.
        for (int i = 0; i < 1500; i++) {
            //声明userCouponModel
            UserCouponModel userCouponModel = new UserCouponModel();
            //生成32为分别由字符(大小写字母)和数字组成的随机字符串,赋值给uid.
            String uid = uniqueCodeGenerator.generateCodeAlphanumeric(32);


            /*
            //测试生成纯数字的随机uid
            String uid = uniqueCodeGenerator.generateCodeNumeric(10);
            long testUid = Long.parseLong(uid);
            */

            /*
            给userCouponModel赋值属性uid, occurTime.再由openingCode查询匹配的event,也赋值给userCouponModel.
             */
            userCouponModel.setUid(uid);
            userCouponModel.setOccurTime(new Date());
            EventModel eventModel = new EventModel();
            eventModel.setOpeningCode(openingCode);
            userCouponModel.setEvent(eventModel);
            /*
            传入userCouponModel(带有uid, event的openingCode, occurTime等信息)给抽奖方法doDrawCoupon.返回一个具有
            完整信息的userCouponModel并赋值给this.UserCouponModel.
             */
            UserCouponModel result = userCouponBizService.doDrawCoupon(userCouponModel);

            //assertNotNull(result);
            //检索1, 2, 3, 4等奖并打印出来,进行测试.
            if (result.getCoupon().getOid() == 1) {
                System.out.println("一等奖开出来了： " + result.getOid());
            }

            if (result.getCoupon().getOid() == 2) {
                System.out.println("二等奖开出来了： " + result.getOid());
            }

            if (result.getCoupon().getOid() == 3) {
                System.out.println("三等奖开出来了： " + result.getOid());
            }

            if (result.getCoupon().getOid() == 4) {
                System.out.println("四等奖开出来了： " + result.getOid());
            }

            if (result.getCoupon().getOid() == 4) {
                System.out.println("五等奖开出来了： " + result.getOid());
            }
        }
    }
}

class ThreadTestDrive {
    public static void main(String[] args) {
        Runnable runnable = new ThreadDemo();
        Thread t = new Thread(runnable);

        t.start();

        System.out.println("1");
    }
}

//private String name;
//private UserCouponBizService userCouponBizService;
//    public ThreadDemo(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public void run() {
//        String openingCode = "nl7mokzukhwhY1NNCP";
//        UniqueCodeGenerator uniqueCodeGenerator = new DefaultUniqueCodeGeneratorImpl();
//        for (int i = 0; i < 300; i++) {
//            UserCouponModel userCouponModel = new UserCouponModel();
//
//            String uid = uniqueCodeGenerator.generateCodeAlphanumeric(32);
//            userCouponModel.setUid(uid);
//            userCouponModel.setOccurTime(new Date());
//
//            EventModel eventModel = new EventModel();
//            eventModel.setOpeningCode(openingCode);
//            userCouponModel.setEvent(eventModel);
//
//            UserCouponModel result = userCouponBizService.doDrawCoupon(userCouponModel);
//
//            //assertNotNull(result);
//
//            if (result.getCoupon().getOid() == 1) {
//                System.out.println(this.name + "一等奖开出来了： " + result.getOid());
//            }
//
//            if (result.getCoupon().getOid() == 2) {
//                System.out.println(this.name + "二等奖开出来了： " + result.getOid());
//            }
//
//            if (result.getCoupon().getOid() == 3) {
//                System.out.println(this.name + "三等奖开出来了： " + result.getOid());
//            }
//            if (result.getCoupon().getOid() == 4) {
//                System.out.println(this.name + "4" + result.getOid());
//            }
//
//            //try {
//            //    ObjectMapper objectMapper = new ObjectMapper();
//            //    String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
//            //    System.out.println(json);
//            //
//            //    //Thread.sleep(3000);
//            //} catch (Exception e) {
//            //    e.printStackTrace();
//            //}
//
//
//        }
//        try {
//            Thread.sleep((int) Math.random() * 10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }