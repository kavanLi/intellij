/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querer.libra.app.event.dal.repository.EventRepository;
import com.querer.libra.app.event.domain.entity.Event;
import com.querer.libra.app.event.service.atom.EventService;

/**
 * 实现接口EventService.
 */
//注解.
@Service
public class EventServiceImpl implements EventService {

    /**
     * fields.
     */

    /**
     * 声明一个EventRepository接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     * 纠正EventRepository是一个接口,调用的也是父接口的方法
     */
    @Autowired
    private EventRepository eventRepository;
    /**
     * public methods.
     */

    /**
     * 覆盖save方法,通过eventRepository的softlySave方法存入event,softlySave方法返回的是optional对象.
     *
     * @param event 用于存入的对象.
     * @return 返回值为event的optional实例.
     */
    @Override
    public Optional <Event> save(@NotNull Event event) {
        return eventRepository.softlySave(event);
    }

    /**
     * 覆盖delete方法,通过eventRepository的delete方法删除匹配oid的event.
     *
     * @param oid 目标oid.
     */
    @Override
    public void delete(@NotNull Long oid) {
        eventRepository.delete(oid);
    }

    /**
     * 覆盖findById方法,通过eventRepository的findOne方法查询匹配oid的event,findOne方法返回的是event,需要转换.
     *
     * @param oid target info.
     * @return 值为event的Optional实例.
     */
    @Override
    public Optional <Event> findById(@NotNull Long oid) {
        return Optional.ofNullable(eventRepository.findOne(oid));
    }

    /**
     * 覆盖findByOpeningCode方法,通过eventRepository的findByOpeningCode方法找到匹配openingCode的event. <br>
     * findByOpeningCode方法返回的是optional的对象.
     *
     * @param openingCode 目标openingCode.
     * @return 返回值为event的optional实例.
     */
    @Override
    public Optional <Event> findByOpeningCode(@NotNull String openingCode) {
        return eventRepository.findByOpeningCode(openingCode);
    }
}
