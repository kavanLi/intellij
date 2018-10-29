package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Doctor;

import com.philips.h2h.bama.app.identification.domain.model.DoctorModel;
import com.philips.h2h.bama.app.identification.exception.DoctorNotFoundException;
import com.philips.h2h.bama.app.identification.exception.DoctorUpdateException;
import com.philips.h2h.bama.app.identification.exception.InactiveDoctorModificationException;
import com.philips.h2h.bama.app.identification.service.atom.DoctorService;
import com.philips.h2h.bama.app.identification.service.business.DoctorBizService;

/**
 * Created by Ritchie on 9/19/2017.
 */
@Service
public class DoctorBizServiceImpl implements DoctorBizService {
    /* fields          ------------------------------------------------------*/

    private final static Logger logger = LoggerFactory.getLogger(DoctorBizServiceImpl.class);

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private Mapper beanMapper;
    /* public methods  ------------------------------------------------------*/

    @Override
    public DoctorModel createDoctor(@NotNull Doctor model) {
        // biz logic code goes here
//        model.setActive(true);
        // reuse atom service to save
        Optional <Doctor> doctorOptional = doctorService.saveDoctor(model);

        return doctorOptional.isPresent() ? beanMapper.map(doctorOptional.get(), DoctorModel.class) : null;
    }

    @Override
    public DoctorModel findDoctor(@NotNull Long doctorOid) {
        Optional <Doctor> doctorOptional = doctorService.findDoctorById(doctorOid);
        return doctorOptional.isPresent() ? beanMapper.map(doctorOptional.get(), DoctorModel.class) : null;
    }

    @Override
    public DoctorModel updateDoctor(@NotNull Doctor model) {
        Long doctorOid = model.getOid();
        Doctor doctor;
        Optional <Doctor> doctorOptional = doctorService.findDoctorById(doctorOid);
        if (doctorOptional.isPresent()) {
            doctor = doctorOptional.get();
            if (!doctor.getActive()) {
                throw new InactiveDoctorModificationException("target doctor is inactive and cannot be modified any more");
            }

            doctor.setName(model.getName());
            doctor.setGenderCode(model.getGenderCode());
            doctor.setDoctorId(model.getDoctorId());

            try {

            } catch (ArrayIndexOutOfBoundsException e) {
                logger.warn("array index out of bounds in processing patient updates: {}", e);
                throw new DoctorUpdateException("update updates with internal error that doctor code is out of range.", e);
            }

            doctorOptional = doctorService.saveDoctor(doctor);

        } else {
            logger.debug("no doctor with doctorOid can be found: doctorOid is {} and model is {}.", doctorOid, model);
            throw new DoctorNotFoundException("target doctor is not found");
        }

        return doctorOptional.isPresent() ? beanMapper.map(doctorOptional.get(), DoctorModel.class) : null;
    }

    @Override
    public Boolean updateDoctorStatus(@NotNull Long doctorOid, @NotNull String status) {
        // TODO to be implement
        return null;
    }
}
