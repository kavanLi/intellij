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

import com.querer.libra.app.event.dal.repository.RuleRepository;
import com.querer.libra.app.event.domain.entity.Rule;
import com.querer.libra.app.event.service.atom.RuleService;
import com.querer.libra.app.event.util.DateTimeUtil;

/**
 * 实现接口RuleService.
 */
//注解.
@Service
public class RuleServiceImpl implements RuleService {

    /**
     * fields.
     */

    /**
     * 声明一个RuleRepository接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private RuleRepository ruleRepository;

    /**
     * public methods.
     */

    /**
     * 覆盖save方法,通过ruleRepository的softlySave方法存入rule,softlySave方法返回的是Optional对象.
     *
     * @param rule 需要存入的rule.
     * @return 返回值为rule的optional实例.
     */
    @Override
    public Optional <Rule> save(@NotNull Rule rule) {
        return ruleRepository.softlySave(rule);
    }

    /**
     * 覆盖delete方法,通过ruleRepository的delete方法删除匹配oid的rule.
     *
     * @param oid 目标oid.
     */
    @Override
    public void delete(@NotNull Long oid) {
        ruleRepository.delete(oid);
    }

    /**
     * 覆盖findById方法,通过ruleRepository的findOne方法查询匹配oid的rule,findOne方法返回的是rule对象 <br>
     * 需要转换.
     *
     * @param oid 目标oid.
     * @return 返回值为Rule的optional实例.
     */
    @Override
    public Optional <Rule> findById(@NotNull Long oid) {
        return Optional.ofNullable(ruleRepository.findOne(oid));
    }

    /**
     * 覆盖方法findRulesToday,声明一个Date类型的的引用变量now,引用指向新的Date对象. <br>
     * 通过DateTimeUtil的静态方法getStartOfDay直接调用取得当天开始的时间,并赋值给startDate. <br>
     * 通过DateTimeUtil的静态方法getEndifDay直接调用取得当天结束的时间,并赋值给endDate. <br>
     * 通过ruleRepository的find~~~~Priority方法查询匹配eventOid和日期的rule, <br>
     * find~~~~Priority方法返回的是值为rule的List.
     *
     * @param eventOid 目标eventOid,当天的开始和结束的时间.
     * @return 值为rule的List.
     */
    @Override
    public List <Rule> findRulesToday(@NotNull Long eventOid) {
        Date now = new Date();
        Date startDate = DateTimeUtil.getStartOfDay(now);
        Date endDate = DateTimeUtil.getEndOfDay(now);
        return ruleRepository.findByEventOidAndEnabledTrueAndTargetDayBetweenOrderByPriority(eventOid, startDate, endDate);
    }
}
