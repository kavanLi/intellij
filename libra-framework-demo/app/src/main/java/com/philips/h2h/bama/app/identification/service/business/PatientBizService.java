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

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Product business service.
 */
@Validated
public interface PatientBizService {
    /**
     * Save pass-by patient model to store.
     *
     * @param model target model to be saved
     * @return saved entity
     */
    PatientCompactModel createPatient(@NotNull Patient model);

    /**
     * Update pass-by patient model to Product entity.
     *
     * @param model target model to be saved
     * @return saved entity
     */
    PatientCompactModel updatePatient(@NotNull Patient model);

    /**
     * Load patient according to oid.
     *
     * @param patientOid target entity oid to find
     * @return target entitfy if exist otherwise null
     */
    PatientComprehensiveModel findPatient(@NotNull Long patientOid);

    /**
     * Update patient to target status.
     *
     * @param patientOid the target patient to update status
     * @param status     the status to be updated to
     * @return true if success otherwise false
     */
    Boolean updatePatientStatus(@NotNull Long patientOid, @NotNull String status);
}
