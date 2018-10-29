/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.service.atom.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querer.libra.app.event.dal.repository.SharedEventRepository;
import com.querer.libra.app.event.domain.entity.SharedEvent;
import com.querer.libra.app.event.service.atom.SharedEventService;

/**
 * 实现接口SharedEventService.
 */
@Service
public class SharedEventServiceImpl implements SharedEventService {

    /**
     * fields.
     */

    /**
     * 声明一个SharedEventRepository接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private SharedEventRepository sharedEventRepository;

    /* public methods ------------------------------------------------------ */

    /**
     * 覆盖save方法,调用sharedEventRepository的softlySave方法来存入sharedEvent, <br>
     * softlySave方法返回的是Optional对象.
     *
     * @param sharedEvent 要存入的sharedEvent.
     * @return 值为SharedEvent的optional实例.
     */
    @Override
    public Optional <SharedEvent> save(@NotNull SharedEvent sharedEvent) {
        return sharedEventRepository.softlySave(sharedEvent);
    }

    /**
     * 覆盖delete方法,调用sharedEventRepository的delete方法来删除匹配oid的sharedEvent.
     *
     * @param oid 目标oid.
     */
    @Override
    public void delete(@NotNull Long oid) {
        sharedEventRepository.delete(oid);
    }

    /**
     * 覆盖findById方法,通过sharedEventRepository的findOne方法来查询匹配oid的sharedEvent.findOne <br>
     * 方法返回的是SharedEvent,需要转换成optional.
     *
     * @param oid 目标oid.
     * @return 值为SharedEvent的Optional实例.
     */
    @Override
    public Optional <SharedEvent> findById(@NotNull Long oid) {
        return Optional.ofNullable(sharedEventRepository.findOne(oid));
    }
    //FIXME

    /**
     * 覆盖findByUidAndBetweenDates方法,通过调用sharedEventRepository的findByUidAndSharedSubmitTimeBetween <br>
     * 方法来查询匹配uid, startDate, endDate.的sharedEvent.findByUidAndSharedSubmitTimeBetween方法换回的是List.
     *
     * @param uid       目标oid.
     * @param startDate 目标当天startDate.
     * @param endDate   目标当天的endDate.
     * @return 值为sharedEvent的List.
     */
    @Override
    public List <SharedEvent> findByUidAndBetweenDates(@NotNull String uid, @NotNull Date startDate, @NotNull Date endDate) {
        return sharedEventRepository.findByUidAndSharedSubmitTimeBetween(uid, startDate, endDate);
    }

    /**
     * 覆盖findByEventOidAndUid方法,通过sharedEventRepository的findByEventOidAndUid方法来查询匹配eventOid, <br>
     * uid的sharedEvent,findByEventOidAndUid方法返回的是List.
     *
     * @param eventOid 目标eventOid.
     * @param uid      目标uid.
     * @return 返回值为sharedEvent的List.
     */
    @Override
    public List <SharedEvent> findByEventOidAndUid(@NotNull Long eventOid, @NotNull String uid) {
        return sharedEventRepository.findByEventOidAndUid(eventOid, uid);
    }
}
