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
import com.philips.h2h.bama.app.identification.domain.model.PatientComprehensiveModel;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * Product business service.
 */
@Validated
public interface PatientBizV2Service {
    /**
     * Load patient according to oid.
     *
     * @param patientOid target entity oid to find
     * @return target entitfy if exist otherwise null
     */
    PatientComprehensiveModel findPatient(@NotNull Long patientOid);

    /**
     * Find patients matching search criteria.
     *
     * @param searchCriteria the search criteria to do search
     * @return patients matched the criteria
     */
    List <Patient> findAllBySearchCriteria(@NotNull PatientSearchCriteriaModel searchCriteria);
}
