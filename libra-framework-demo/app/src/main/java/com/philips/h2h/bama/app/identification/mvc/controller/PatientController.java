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
import com.philips.h2h.bama.app.identification.service.business.PatientBizService;
import com.philips.h2h.bama.app.identification.service.atom.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for patient services.
 */
@RestController
@RequestMapping("/patients")
public class PatientController {

    /* fields          ------------------------------------------------------*/

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientBizService patientBizService;

    /* public methods  ------------------------------------------------------*/

    /**
     * patient.show action. Show all full attributes one specific patient.
     *
     * @param patientOid target entity oid
     * @return entity model with details
     */
    @RequestMapping("/{patientOid}")
    public PatientComprehensiveModel getShow(@PathVariable Long patientOid) {
        PatientComprehensiveModel patient = patientBizService.findPatient(patientOid);
        return patient;
    }

    /**
     * patient.store action
     *
     * @param model target entity model to be stored
     * @return new patient oid
     */
    @RequestMapping(method = RequestMethod.POST)
    public Long postStore(@RequestBody Patient model) {
        PatientCompactModel patient = patientBizService.createPatient(model);
        return patient.getOid();
    }

    /**
     * patient.update action
     *
     * @param patientOid target entity oid to be updated
     * @param model      target entity model to be stored
     * @return updated entity oid
     */
    @RequestMapping(value = "/{patientOid}", method = RequestMethod.PUT)
    public Long putUpdate(@PathVariable Long patientOid, @RequestBody Patient model) {
        model.setOid(patientOid);
        PatientCompactModel patient = patientBizService.updatePatient(model);
        return patient.getOid();
    }

    /**
     * patient.delete action
     *
     * @param patientOid target project id to be deleted
     */
    @RequestMapping(value = "/{patientOid}", method = RequestMethod.DELETE)
    public void deletePatient(@PathVariable Long patientOid) {
        patientService.deletePatient(patientOid);
    }

    /**
     * update patient status.
     *
     * @param patientOid target entity oid to be updated
     * @param status     target status to be updated on patient
     * @return true if success otherwise false
     */
    @RequestMapping(value = "/status-update/{patientOid}", method = RequestMethod.POST)
    public Boolean postUpdatePatientStatus(@PathVariable Long patientOid, @RequestBody String status) {
        Boolean updated = patientBizService.updatePatientStatus(patientOid, status);
        return updated;
    }
}
