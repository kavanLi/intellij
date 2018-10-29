/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.service;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.querer.libra.app.event.service.business.impl.UserCouponBizServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.querer.libra.app.event.domain.model.EventModel;
import com.querer.libra.app.event.domain.model.UserCouponModel;
import com.querer.libra.app.event.service.business.UserCouponBizService;
import com.querer.libra.platform.code.UniqueCodeGenerator;
import com.querer.libra.platform.code.impl.DefaultUniqueCodeGeneratorImpl;
import com.querer.libra.platform.core.test.BaseServiceIntegrationTest;

import static org.junit.Assert.assertNotNull;


public class UserCouponBizServiceTest_1 extends BaseServiceIntegrationTest
//        extends InMemoryDbIntegrationTest
{
    /* fields          ------------------------------------------------------*/

    @Autowired
    private UserCouponBizService userCouponBizService;

    private int number = 16;
    private CountDownLatch latch = new CountDownLatch(number);

    /* public methods  ------------------------------------------------------*/

    @Test
    public void testDrawCoupon() {
        UserCouponModel userCouponModel = new UserCouponModel();

        UniqueCodeGenerator uniqueCodeGenerator = new DefaultUniqueCodeGeneratorImpl();

        userCouponModel.setUid("86be404f0002605c0000000459731a93");
        //String uid = uniqueCodeGenerator.generateCodeAlphanumeric(32);
        //userCouponModel.setUid(uid);

        userCouponModel.setOccurTime(new Date());

        EventModel eventModel = new EventModel();
        eventModel.setOpeningCode("nl7mokzukhwhY1NNCP");
        userCouponModel.setEvent(eventModel);

        UserCouponModel result = userCouponBizService.doDrawCoupon(userCouponModel);

        assertNotNull(result);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

            //try {
            //    ObjectMapper objectMapper = new ObjectMapper();
            //    String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            //    System.out.println(json);
            //
            //    //Thread.sleep(3000);
            //} catch (Exception e) {
            //    e.printStackTrace();
            //}


        }
    }


    @Test
    public void testBatchDrawByThreads() {

        String openingCode = "nl7mokzukhwhY1NNCP";
        UniqueCodeGenerator uniqueCodeGenerator = new DefaultUniqueCodeGeneratorImpl();
        //声明16个线程
        for (int i = 0; i < number; i++) {
            String name = "Thread " + i;
            new Thread(() -> {
                System.out.println("start " + name);
                //每个线程抽奖1000次
                for (int j = 0; j < 1000; j++) {
                    String uid = uniqueCodeGenerator.generateCodeAlphanumeric(32);
                    drawOnce(name, uid, openingCode);
                    //System.out.println("uid " + uid);
                }


                System.out.println("end " + name);

                latch.countDown(); // 执行完毕，计数器减1
            }).start();
        }

        try {
            latch.await(); // 主线程等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void drawOnce(String name, String uid, String openingCode) {
        UserCouponModel userCouponModel = new UserCouponModel();

        //String uid = uniqueCodeGenerator.generateCodeAlphanumeric(32);
        userCouponModel.setUid(uid);
        userCouponModel.setOccurTime(new Date());

        EventModel eventModel = new EventModel();
        eventModel.setOpeningCode(openingCode);
        userCouponModel.setEvent(eventModel);

        UserCouponModel result = userCouponBizService.doDrawCoupon(userCouponModel);

        //assertNotNull(result);

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

        if (result.getCoupon().getOid() == 5) {
            System.out.println("五等奖开出来了： " + result.getOid());
        }
    }

    class Runner implements Runnable {

        @Override
        public void run() {

            System.out.println(123);
            latch.countDown(); // 执行完毕，计数器减1
        }
    }

}
