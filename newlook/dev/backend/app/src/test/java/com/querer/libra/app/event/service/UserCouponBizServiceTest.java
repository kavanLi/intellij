/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.service;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
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

public class UserCouponBizServiceTest extends BaseServiceIntegrationTest
//        extends InMemoryDbIntegrationTest
{
    /* fields          ------------------------------------------------------*/

    @Autowired
    private UserCouponBizService userCouponBizService;

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

    @Test
    public void testBatchDrawCoupon() {

        //String openingCode = "nl7mokzukhwhY1NNCP";
        //UniqueCodeGenerator uniqueCodeGenerator = new DefaultUniqueCodeGeneratorImpl();
        //new Thread(new ThreadDemo("A店")).start();
        //new Thread(new ThreadDemo("B店")).start();
        //new Thread(new ThreadDemo("C店")).start();
        //new Thread(new ThreadDemo("D店")).start();

        for (int i = 0; i < 1; i++) {
            new Thread(new Runnable() {
                String name;

                @Override
                public void run() {
                    System.out.println(new Date());

                    String openingCode = "nl7mokzukhwhY1NNCP";
                    UniqueCodeGenerator uniqueCodeGenerator = new DefaultUniqueCodeGeneratorImpl();
                    for (int j = 0; j < 10; j++) {
                        UserCouponModel userCouponModel = new UserCouponModel();

                        String uid = uniqueCodeGenerator.generateCodeAlphanumeric(32);
                        userCouponModel.setUid(uid);
                        userCouponModel.setOccurTime(new Date());

                        EventModel eventModel = new EventModel();
                        eventModel.setOpeningCode(openingCode);
                        userCouponModel.setEvent(eventModel);

                        UserCouponModel result = userCouponBizService.doDrawCoupon(userCouponModel);


                        System.out.println(result.toString());
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
                            System.out.println("4" + result.getOid());
                        }
                    }
                    try {
                        Thread.sleep((int) Math.random() * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        //for (int i = 0; i < 72000; i++) {
        //    UserCouponModel userCouponModel = new UserCouponModel();
        //
        //    String uid = uniqueCodeGenerator.generateCodeAlphanumeric(32);
        //    userCouponModel.setUid(uid);
        //    userCouponModel.setOccurTime(new Date());
        //
        //    EventModel eventModel = new EventModel();
        //    eventModel.setOpeningCode(openingCode);
        //    userCouponModel.setEvent(eventModel);
        //
        //    UserCouponModel result = userCouponBizService.doDrawCoupon(userCouponModel);
        //
        //    //assertNotNull(result);
        //
        //    if (result.getCoupon().getOid() == 1) {
        //        System.out.println("一等奖开出来了： " + result.getOid());
        //    }
        //
        //    if (result.getCoupon().getOid() == 2) {
        //        System.out.println("二等奖开出来了： " + result.getOid());
        //    }
        //
        //    if (result.getCoupon().getOid() == 3) {
        //        System.out.println("三等奖开出来了： " + result.getOid());
        //    }
        //    if (result.getCoupon().getOid() == 4) {
        //        System.out.println("." + result.getOid());
        //    }

        //try {
        //    ObjectMapper objectMapper = new ObjectMapper();
        //    String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        //    System.out.println(json);
        //
        //    //Thread.sleep(3000);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}


        //}
    }
}
