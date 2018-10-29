package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Doctor;
import com.philips.h2h.bama.app.identification.domain.model.DoctorModel;
import com.philips.h2h.bama.app.identification.service.atom.DoctorService;
import com.philips.h2h.bama.app.identification.service.business.DoctorBizService;

/**
 * Created by Ritchie on 9/19/2017.
 */
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    /* fields          ------------------------------------------------------*/

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorBizService doctorBizService;


    /**
     * private DoctorServiceImpl doctorServiceImpl;
     */

    /* public methods  ------------------------------------------------------*/
    @RequestMapping("/{doctorOid}")
    public DoctorModel getShow(@PathVariable Long doctorOid) {
        DoctorModel doctor = doctorBizService.findDoctor(doctorOid);
        return doctor;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Long postStore(@RequestBody Doctor model) {
        DoctorModel doctor = doctorBizService.createDoctor(model);
        return doctor.getOid();
    }

    @RequestMapping(value = "/{doctorOid}", method = RequestMethod.PUT)
    public Long putUpdate(@PathVariable Long doctorOid, @RequestBody Doctor model) {
        model.setOid(doctorOid);
        DoctorModel doctor = doctorBizService.updateDoctor(model);
        return doctor.getOid();
    }

    @RequestMapping(value = "/{doctorOid}", method = RequestMethod.DELETE)
    public void deleteDoctor(@PathVariable Long doctorOid) {
        doctorService.deleteDoctor(doctorOid);
    }

    @RequestMapping(value = "/status-update/{doctorOid}", method = RequestMethod.POST)
    public Boolean postUpdateDoctorStatus(@PathVariable Long doctorOid, @RequestBody String status) {
        Boolean updated = doctorBizService.updateDoctorStatus(doctorOid, status);
        return updated;
    }
}
