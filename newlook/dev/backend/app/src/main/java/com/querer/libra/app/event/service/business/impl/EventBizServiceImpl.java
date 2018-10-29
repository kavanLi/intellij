/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querer.libra.app.event.domain.entity.Event;
import com.querer.libra.app.event.domain.model.EventModel;
import com.querer.libra.app.event.exception.EventNotFoundException;
import com.querer.libra.app.event.service.atom.EventService;
import com.querer.libra.app.event.service.business.EventBizService;

/**
 * 实现接口EventBizService.
 */
//注释.
@Service
public class EventBizServiceImpl implements EventBizService {

    /**
     * fields.
     */

    /**
     * 声明一个EventService接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private EventService eventService;

    /**
     * 声明一个Mapper接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private Mapper beanMapper;

    /**
     * public methods.
     */

    /**
     * 查询匹配openingCode的event.
     *
     * @param openingCode target info.
     * @return 带有event信息的EventModel.
     */
    @Override
    public EventModel findByOpeningCode(@NotNull String openingCode) {
        //声明一个名称为model的EventModel.
        EventModel model = null;
        //查询匹配openingCode的Event,赋值给evenOptional.
        Optional <Event> eventOptional = eventService.findByOpeningCode(openingCode);

        if (eventOptional.isPresent()) {
            //如果eventOptional存在值event,则把event转换成EventModel再赋值给model
            model = beanMapper.map(eventOptional.get(), EventModel.class);
        } else {
            //不存在,则抛出一个带有说明的异常:活动没有找到的异常
            throw new EventNotFoundException("cannot find event with opening code: " + openingCode);
        }
        //返回EventModel类型的model.
        return model;

    }
}
