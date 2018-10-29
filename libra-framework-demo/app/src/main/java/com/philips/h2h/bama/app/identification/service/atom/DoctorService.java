package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Doctor;

/**
 * Created by Ritchie on 9/19/2017.
 */
@Validated
public interface DoctorService {
    Optional <Doctor> saveDoctor(@NotNull Doctor doctor);

    Optional <Doctor> findDoctorById(@NotNull Long doctorOid);

    void deleteDoctor(@NotNull Long doctorOid);
}
