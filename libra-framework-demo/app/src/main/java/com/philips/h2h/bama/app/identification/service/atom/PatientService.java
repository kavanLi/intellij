/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.service.atom;

import com.philips.h2h.bama.app.identification.domain.entity.Patient;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

import java.util.Optional;

/**
 * Patient service.
 */
@Validated
public interface PatientService {

    /**
     * Save (create/update) pass-by patient entity to store.
     *
     * @param patient target patient entity to save.
     * @return saved entity
     */
    Optional <Patient> savePatient(@NotNull Patient patient);

    /**
     * Delete patient softly from store.
     *
     * @param patientOid the oid of target patient entity to delete
     */
    void deletePatient(@NotNull Long patientOid);

    /**
     * Find unique patient by id, associations are loaded lazily.
     *
     * @param patientOid target oid of patient entity to load
     * @return target patient if exist otherwise null
     */
    Optional <Patient> findPatientById(@NotNull Long patientOid);
}
