/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.service.atom.impl;

import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.dal.repository.PatientRepository;
import com.philips.h2h.bama.app.identification.service.atom.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import java.util.Optional;

/**
 * Implementation class of {@link PatientService}.
 */
@Service
public class PatientServiceImpl implements PatientService {

    /* fields ------------------------------------------------------ */

    @Autowired
    private PatientRepository patientRepository;

    /* public methods ------------------------------------------------------ */

    /*
     * @see PatientService#savePatient(Patient)
     */
    @Override
    public Optional <Patient> savePatient(@NotNull Patient patient) {
        return patientRepository.softlySave(patient);
    }

    /*
     * @see PatientService#deletePatient(java.lang.Long)
     */
    @Override
    public void deletePatient(@NotNull Long patientOid) {
        patientRepository.softlyDelete(patientOid);
    }

    /*
     * @see PatientService#findPatientById(java.lang.Long)
     */
    @Override
    public Optional <Patient> findPatientById(@NotNull Long patientOid) {
        Patient patient = patientRepository.findOne(patientOid);
        return Optional.ofNullable(patient);
    }

}
