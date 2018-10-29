/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.sample;

import java.util.Date;
import java.util.Optional;

import com.querer.libra.app.event.domain.entity.Event;
import com.querer.libra.app.event.domain.model.EventModel;
import com.querer.libra.app.event.domain.model.UserCouponModel;

import com.querer.libra.app.event.service.atom.EventService;
import com.querer.libra.app.event.service.business.EventBizService;
import com.querer.libra.app.event.service.business.UserCouponBizService;
import com.querer.libra.app.event.service.business.impl.EventBizServiceImpl;
import com.querer.libra.app.event.service.business.impl.UserCouponBizServiceImpl;
import com.querer.libra.platform.code.UniqueCodeGenerator;
import com.querer.libra.platform.code.impl.DefaultUniqueCodeGeneratorImpl;
import org.dozer.Mapper;
import org.junit.Test;

import com.querer.libra.platform.core.test.BaseServiceIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;

public class SampleTest extends BaseServiceIntegrationTest
//        extends InMemoryDbIntegrationTest
{
    /* public methods  ------------------------------------------------------*/
    @Autowired
    private EventService eventService;

    @Autowired
    private EventBizService eventBizService;

    @Autowired
    private Mapper beanMapper;

    @Test
    public void testSample() {

        //Optional<Event> eventOptional = eventService.findById(1L);
        //EventModel eventModel = beanMapper.map(eventOptional.get(), EventModel.class);
        //System.out.println(toString(eventModel));

        //EventModel eventModel;
        //eventModel = eventBizService.findByOpeningCode("ml7mokzukhwhY1NNCP");

        System.out.println("Hello, it works!");
    }

    private String toString(EventModel eventModel) {
        return eventModel.getOid() + eventModel.getDescription() + eventModel.getEnabled() + eventModel.getEndTime() +
                eventModel.getName() + eventModel.getStartTime() + eventModel.getStoreName();
    }


}
