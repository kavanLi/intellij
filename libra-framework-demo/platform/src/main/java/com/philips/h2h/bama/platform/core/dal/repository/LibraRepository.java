/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.dal.repository;

import com.philips.h2h.bama.platform.core.domain.entity.BusinessEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface LibraRepository<T extends BusinessEntity, ID extends Serializable> extends JpaRepository <T, ID> {
    /**
     * Softly save business entity that set active flag to 1.
     *
     * @param entity target business entity to save
     * @return saved entity
     */
    Optional <T> softlySave(T entity);

    /**
     * Delete business entity logically by id. Active flag will be set to 0.
     *
     * @param id target id of business entity
     */
    void softlyDelete(ID id);

    /**
     * Delete business entity logically. Active flag will be set to 0.
     *
     * @param entity target business entity
     */
    void softlyDelete(T entity);
}
