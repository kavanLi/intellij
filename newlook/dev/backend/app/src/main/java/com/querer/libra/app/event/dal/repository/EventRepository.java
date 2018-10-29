/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.dal.repository;

import java.util.Optional;

import com.querer.libra.app.event.domain.entity.Event;
import com.querer.libra.platform.core.dal.repository.BaseRepository;

/**
 * Event repository.
 */
public interface EventRepository extends BaseRepository <Event, Long> {
    /**
     * 找到匹配openingCode的event信息.
     *
     * @param openingCode target info.
     * @return 值为event的optional实例.
     */
    Optional <Event> findByOpeningCode(String openingCode);
}
