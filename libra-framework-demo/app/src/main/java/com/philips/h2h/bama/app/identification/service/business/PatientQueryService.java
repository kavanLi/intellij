/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.service.business;

import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.domain.model.PatientCompactModel;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * Patient query service.
 */
@Validated
public interface PatientQueryService {
    /**
     * Find patients with ethnic code and order by gender code desc.
     *
     * @param ethnicCode patient ethnic code
     * @param pageable   the page request
     * @return matched paging patients
     */
    Page <PatientCompactModel> findByEthnic(@NotNull String ethnicCode, @NotNull Pageable pageable);

    /**
     * Find all patients with page request.
     *
     * @param pageable the page request
     * @return paging patients
     */
    Page <Patient> findAllPageable(@NotNull Pageable pageable);

    /**
     * Find all patients with page request.
     *
     * @param pageable the page request
     * @return paging patient models
     */
    Page <PatientCompactModel> findAllModelPageable(@NotNull Pageable pageable);

    /**
     * Find patients matching search criteria.
     *
     * @param searchCriteria the search criteria to do search
     * @return patients matched the criteria
     */
    List <Patient> findAllBySearchCriteria(@NotNull PatientSearchCriteriaModel searchCriteria);

    /**
     * Find patients matching search criteria and paging.
     *
     * @param searchCriteria the search criteria to do search
     * @param pageable       the page request for paging
     * @return page patients matched the criteria
     */
    Page <PatientCompactModel> findModelBySearchCriteriaPageable(@NotNull PatientSearchCriteriaModel searchCriteria, @NotNull Pageable pageable);

    /**
     * Find patients matching search criteria and paging.
     *
     * @param searchCriteria the search criteria to do search
     * @param pageable       the page request for paging
     * @return page patients matched the criteria
     */
    Page <Patient> findBySearchCriteriaPageable(@NotNull PatientSearchCriteriaModel searchCriteria, @NotNull Pageable pageable);
}