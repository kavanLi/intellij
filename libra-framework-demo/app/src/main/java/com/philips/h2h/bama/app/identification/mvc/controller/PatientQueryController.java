/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.mvc.controller;

import com.philips.h2h.bama.app.identification.domain.model.PatientCompactModel;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;
import com.philips.h2h.bama.app.identification.service.business.PatientQueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for product query services.
 */
@RestController
@RequestMapping("/query/patients")
public class PatientQueryController {

    /* fields          ------------------------------------------------------*/

    @Autowired
    private PatientQueryService patientQueryService;

    /* public methods  ------------------------------------------------------*/

    /**
     * Query patients by ethnic code.
     *
     * @param ethnicCode ethnic code to query
     * @param pageable   page request
     * @return paging patient list
     */
    @RequestMapping("/by-ethnicCode/{ethnicCode}")
    public Page <PatientCompactModel> queryByEthnicCode(@PathVariable String ethnicCode, Pageable pageable) {
        Page <PatientCompactModel> patientPage = patientQueryService.findByEthnic(ethnicCode, pageable);
        return patientPage;
    }

    /**
     * List patients with page request.
     *
     * @param pageable page request
     * @return paging patient list
     */
    @RequestMapping("/paging")
    public Page <PatientCompactModel> queryAll(Pageable pageable) {
        Page <PatientCompactModel> patientPage = patientQueryService.findAllModelPageable(pageable);
        return patientPage;
    }

    /**
     * Query patients by search criteria along with page request.
     *
     * @param searchCriteria the criteria to query patients
     * @param pageable       page request
     * @return all patients matched the search criteria
     */
    @RequestMapping(value = "/criteria")
    public Page <PatientCompactModel> queryBySearchCriteria(PatientSearchCriteriaModel searchCriteria, Pageable pageable) {
        Page <PatientCompactModel> patientPage = patientQueryService.findModelBySearchCriteriaPageable(searchCriteria, pageable);
        return patientPage;
    }
}
