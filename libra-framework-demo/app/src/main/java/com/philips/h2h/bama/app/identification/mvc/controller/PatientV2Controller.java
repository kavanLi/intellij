/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.mvc.controller;

import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.domain.model.PatientCompactModel;
import com.philips.h2h.bama.app.identification.domain.model.PatientComprehensiveModel;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;
import com.philips.h2h.bama.app.identification.service.atom.PatientService;
import com.philips.h2h.bama.app.identification.service.business.PatientBizService;
import com.philips.h2h.bama.app.identification.service.business.PatientBizV2Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for patient services v2. Call service based on HQL/Hibernate query.
 */
@RestController
@RequestMapping("/patients/v2")
public class PatientV2Controller {

    /* fields          ------------------------------------------------------*/

    @Autowired
    private PatientBizV2Service patientBizV2Service;

    /* public methods  ------------------------------------------------------*/

    /**
     * patient.show action. Show all full attributes one specific patient.
     *
     * @param patientOid target entity oid
     * @return entity model with details
     */
    @RequestMapping("/{patientOid}")
    public PatientComprehensiveModel getShow(@PathVariable Long patientOid) {
        PatientComprehensiveModel patient = patientBizV2Service.findPatient(patientOid);
        return patient;
    }

    /**
     * Query patients by search criteria along with page request.
     *
     * @param searchCriteria the criteria to query patients
     * @return all patients matched the search criteria
     */
    @RequestMapping(value = "/criteria")
    public List <Patient> queryBySearchCriteria(PatientSearchCriteriaModel searchCriteria) {
        List <Patient> patientList = patientBizV2Service.findAllBySearchCriteria(searchCriteria);
        return patientList;
    }
}
