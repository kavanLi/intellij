/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.service.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querer.libra.app.event.domain.entity.Event;
import com.querer.libra.app.event.domain.entity.SharedEvent;
import com.querer.libra.app.event.domain.model.EventModel;
import com.querer.libra.app.event.domain.model.SharedEventModel;
import com.querer.libra.app.event.exception.EventClosedException;
import com.querer.libra.app.event.exception.InvalidEventException;
import com.querer.libra.app.event.exception.ParameterRequiredException;
import com.querer.libra.app.event.exception.SharedEventNotFoundException;
import com.querer.libra.app.event.service.atom.EventService;
import com.querer.libra.app.event.service.atom.SharedEventService;
import com.querer.libra.app.event.service.business.SharedEventBizService;

/**
 * 实现接口SharedEventBizService.
 */
//注释.
@Service
public class SharedEventBizServiceImpl implements SharedEventBizService {

    /**
     * fields.
     */

    /**
     * 声明一个SharedEventService接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private SharedEventService sharedEventService;

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
     * 分享活动.
     *
     * @param sharedEventModel target info.
     * @return 把分享活动的信息以sharedEventModel的形式返回.
     */
    @Override
    public SharedEventModel doSharedEvent(@NotNull SharedEventModel sharedEventModel) {
        /**
         * validate params.
         */
        //把shareDEventModel的uid赋值给字符串变量 uid.
        String uid = sharedEventModel.getUid();
        //声明字符串变量openingCode,并且空指针.
        String openingCode = null;
        //声明一个EventModel对象eventModel指向sharedEventModel中的Event对象.
        EventModel eventModel = sharedEventModel.getEvent();

        if (eventModel != null) {
            //如果eventModel指向的对象存在,则把Event对象的openingCode赋值给字符串openingCode.
            openingCode = eventModel.getOpeningCode();
        }
        if (StringUtils.isBlank(uid) && StringUtils.isBlank(openingCode)) {
            //如果字符串uid与字符串openingCode有一个为空,则抛出一个带有说明的异常:参数不完整异常.
            throw new ParameterRequiredException("share event error, uid or opening code is missing.");
        }

        /**
         * find event 现在获得了sharedEventModel的uid和openingCode.
         */
        Optional <Event> eventOptional = eventService.findByOpeningCode(openingCode);
        //通过findByOpeningCode查询匹配openingCode的Event并赋值给eventOptional.
        if (!eventOptional.isPresent()) {
            //如果eventOptional的值为空,则抛出一个带有说明的异常:分享没有找到异常.
            throw new SharedEventNotFoundException("shared event cannot be found.");
        }
        //把eventOptional的值,赋值给新声明的event.
        Event event = eventOptional.get();

        /**
         * validate event attributes 现在取得了event,需要验证event的属性是否完全.
         */
        /*
        声明Date类型的变量取得event开始和解释的日期和时间.
         */
        Date now = new Date();
        Date startTime = event.getStartTime();
        Date endTime = event.getEndTime();
        //如果event的开始和结束的时间都存在则进入该语句块.
        if (startTime != null && endTime != null) {
            //如果现在的日期时间小于event的开始时间或者大于event的结束时间,则进入该语句块.
            if (!(now.after(startTime) && now.before(endTime))) {
                //抛出一个带有说明的异常:活动关闭异常.
                throw new EventClosedException("the event is closed.");
            }
        } else {
            //否则抛出一个不可用event的异常.
            throw new InvalidEventException("the event has invalid start time or end time.");
        }

        /**
         * save share event event验证完毕,可以使用.
         */
        /*
        声明一个shareEvent entity,然后赋值属性uid, event_oid, sharedOccureTime, SharedSubmitTime.
         */
        SharedEvent sharedEvent = new SharedEvent();
        sharedEvent.setUid(uid);
        sharedEvent.setEventOid(event.getOid());
        sharedEvent.setSharedOccurTime(sharedEventModel.getSharedOccurTime());
        sharedEvent.setSharedSubmitTime(now);
        /*
        保存shareEvent进sharedEvent的数据库,save方法返回的是值为shareEvent的optional,在调用optional的
        get方法,把从数据库中取出来的shareEvent引用指向之前声明的shareEvent
         */
        sharedEvent = sharedEventService.save(sharedEvent).get();
        //把这个shareEvent转换给SharedEventModel,然后返回SharedEventModel.
        return beanMapper.map(sharedEvent, SharedEventModel.class);
    }

    @Override
    public List <SharedEventModel> findSharedEvents(@NotNull String openingCode, @NotNull String uid) {
        /**
         * validate params.
         */
        if (StringUtils.isBlank(uid) && StringUtils.isBlank(openingCode)) {
            //如果传进来的openingCode和uid都不存在则进入该语句块,抛出一个带有说明的异常:需求的数据不完整异常.
            throw new ParameterRequiredException("share event error, uid or opening code is missing.");
        }
        /**
         * find event 验证openingCode和uid后,根据其找到匹配的sharedEvent.
         */
        //通过findByOpeningCode查询匹配openingCode的Event并赋值给eventOptional.
        Optional <Event> eventOptional = eventService.findByOpeningCode(openingCode);

        if (!eventOptional.isPresent()) {
            //如果eventOptional为空,则进入该语句块,抛出一个带有说明的异常:分享没有找到异常.
            throw new SharedEventNotFoundException("shared event cannot be found.");
        }
        //把eventOptional的值赋值给新声明的event.
        Event event = eventOptional.get();
        //通过findByEventOidAndUid方法查询匹配的event_oid和uid的sharedEvent并赋值给集合sharedEventList.
        List <SharedEvent> sharedEventList = sharedEventService.findByEventOidAndUid(event.getOid(), uid);
        //声明一个类型为SharedEventModel的数组,名称是result.
        List <SharedEventModel> result = new ArrayList <>();
        //如果集合sharedEventList存在元素,就进入该语句块.
        if (CollectionUtils.isNotEmpty(sharedEventList)) {
            //把?? 转换以后把sharedEventModel赋值给result.
            result = sharedEventList.stream().map(e -> beanMapper.map(e, SharedEventModel.class)).collect(Collectors.toList());
        }
        //返回值为sharedEventModel的List.
        return result;
    }
}
