package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.DoctorRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Doctor;
import com.philips.h2h.bama.app.identification.service.atom.DoctorService;

/**
 * Created by Ritchie on 9/19/2017.
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    /* fields ------------------------------------------------------ */

    @Autowired
    private DoctorRepository doctorRepository;

    /* public methods ------------------------------------------------------ */

    /*
     * @see DoctorService#saveDoctor(Doctor)
     */

    @Override
    public Optional <Doctor> saveDoctor(@NotNull Doctor doctor) {
        return doctorRepository.softlySave(doctor);
    }

    @Override
    public Optional <Doctor> findDoctorById(@NotNull Long doctorOid) {
        Doctor doctor = doctorRepository.findOne(doctorOid);
        return Optional.ofNullable(doctor);
    }

    @Override
    public void deleteDoctor(@NotNull Long doctorOid) {
        doctorRepository.delete(doctorOid);
    }
}
