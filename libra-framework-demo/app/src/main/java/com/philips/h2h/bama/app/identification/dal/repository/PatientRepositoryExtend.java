/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.dal.repository;

import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Patient repository extend interfaces.
 */
public interface PatientRepositoryExtend {
    /**
     * Find patients matching search criteria.
     *
     * @param searchCriteria the search criteria to do search
     * @return patients matched the criteria
     */
    List <Patient> findBySearchCriteria(PatientSearchCriteriaModel searchCriteria);

    /**
     * Find patients matching search criteria and paging.
     *
     * @param searchCriteria the search criteria to do search
     * @param pageable       the page request for paging
     * @return page patients matched the criteria
     */
    Page <Patient> findBySearchCriteriaPageable(PatientSearchCriteriaModel searchCriteria, Pageable pageable);
}
