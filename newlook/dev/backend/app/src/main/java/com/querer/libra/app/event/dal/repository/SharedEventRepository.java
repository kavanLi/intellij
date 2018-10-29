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

import com.querer.libra.app.event.domain.entity.SharedEvent;
import com.querer.libra.platform.core.dal.repository.BaseRepository;

/**
 * sharedEvent repository
 */
public interface SharedEventRepository extends BaseRepository <SharedEvent, Long> {
    /**
     * 找到匹配uid, sharedSubmitTime的sharedEvent信息.
     *
     * @param uid       target info.
     * @param startDate target info.
     * @param endDate   target info.
     * @return 值为sharedEvent的List实例.
     */
    List <SharedEvent> findByUidAndSharedSubmitTimeBetween(String uid, Date startDate, Date endDate);

    /**
     * 找到匹配eventOid, uid的sharedEvent.
     *
     * @param eventOid target info.
     * @param uid      target info.
     * @return 值为sharedEvent的List实例.
     */
    List <SharedEvent> findByEventOidAndUid(Long eventOid, String uid);
}
