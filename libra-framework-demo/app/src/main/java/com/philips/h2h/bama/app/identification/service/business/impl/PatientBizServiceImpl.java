/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.service.business.impl;

import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.domain.model.PatientCompactModel;
import com.philips.h2h.bama.app.identification.domain.model.PatientComprehensiveModel;
import com.philips.h2h.bama.app.identification.exception.InactivePatientModificationException;
import com.philips.h2h.bama.app.identification.exception.PatientNotFoundException;
import com.philips.h2h.bama.app.identification.exception.PatientUpdateException;
import com.philips.h2h.bama.app.identification.service.business.PatientBizService;
import com.philips.h2h.bama.app.identification.service.atom.PatientService;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Implementation Class of {@link PatientBizService}.
 */
@Service
public class PatientBizServiceImpl implements PatientBizService {

    /* fields          ------------------------------------------------------*/

    private final static Logger logger = LoggerFactory.getLogger(PatientBizServiceImpl.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private Mapper beanMapper;

    /* public methods  ------------------------------------------------------*/

    /**
     * @see PatientBizService#createPatient(Patient)
     */
    @Override
    public PatientCompactModel createPatient(@NotNull Patient model) {
        // biz logic code goes here
//        model.setActive(true);
        // reuse atom service to save
        Optional <Patient> patientOptional = patientService.savePatient(model);

        return patientOptional.isPresent() ? beanMapper.map(patientOptional.get(), PatientCompactModel.class) : null;
    }

    /**
     * @see PatientBizService#updatePatient(Patient)
     */
    @Override
    public PatientCompactModel updatePatient(@NotNull Patient model) {
        Long patientOid = model.getOid();

        Patient patient;
        Optional <Patient> patientOptional = patientService.findPatientById(patientOid);
        if (patientOptional.isPresent()) {
            patient = patientOptional.get();

            // #case 1
            // if patient is inactive, violate update patient rule and throw system exception
            if (!patient.getActive()) {
                // if no patient can be found, throw biz exception, don't log any msg if you don't want to
                // logger.info("target patient is set as inactive and cannot be modified.");
                throw new InactivePatientModificationException("target patient is inactive and cannot be modified any more.");
            }

            // ... more biz logic goes here
            patient.setName(model.getName());

            // #case 2
            // un-caught exception and it throws out for platform to process
            ArrayList arrayList = null;
//            arrayList.get(0);

            // #case 3
            // catch an exception manually and process it
            arrayList = new ArrayList();
            try {
                //arrayList.get(0);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.warn("array index out of bounds in processing patient updates: {}", e);
                throw new PatientUpdateException("update updates with internal error that patient code is out of range.", e);
            }

            patientOptional = patientService.savePatient(patient);
        } else {
            // #case 4
            // if no patient can be found, throw biz exception
            logger.debug("no patient with patientOid can be found: patientOid is {} and model is {}.", patientOid, model);
            throw new PatientNotFoundException("target patient is not found");
        }


        return patientOptional.isPresent() ? beanMapper.map(patientOptional.get(), PatientCompactModel.class) : null;
    }

    /**
     * @see PatientBizService#findPatient(Long)
     */
    @Override
    public PatientComprehensiveModel findPatient(@NotNull Long patientOid) {
        Optional <Patient> patientOptional = patientService.findPatientById(patientOid);

        Patient patient = new Patient();

        return patientOptional.isPresent() ? beanMapper.map(patientOptional.get(), PatientComprehensiveModel.class) : null;
    }

    /**
     * @see PatientBizService#updatePatient(Patient)
     */
    @Override
    public Boolean updatePatientStatus(@NotNull Long patientOid, @NotNull String status) {
        // TODO to be implemented
        return null;
    }
}
