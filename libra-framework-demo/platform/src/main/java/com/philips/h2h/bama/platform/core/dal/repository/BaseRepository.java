/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.dal.repository;

import com.philips.h2h.bama.platform.core.domain.entity.BusinessEntity;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Base repository.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BusinessEntity, ID extends Serializable> extends LibraRepository <T, ID>, QueryDslPredicateExecutor <T> {
}
