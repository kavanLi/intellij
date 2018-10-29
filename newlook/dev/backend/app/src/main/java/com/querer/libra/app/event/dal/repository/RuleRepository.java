/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.dal.repository;

import java.util.Date;
import java.util.List;

import com.querer.libra.app.event.domain.entity.Rule;
import com.querer.libra.platform.core.dal.repository.BaseRepository;

/**
 * Rule repository.
 */
public interface RuleRepository extends BaseRepository <Rule, Long> {
    /**
     * 找到匹配eventOid, enabled = true, targetDay的rule信息.
     *
     * @param eventOid target info.
     * @param statDate target info.
     * @param endDate  target info.
     * @return 值为rule的List实例.
     */
    List <Rule> findByEventOidAndEnabledTrueAndTargetDayBetweenOrderByPriority(Long eventOid, Date statDate, Date endDate);
}
