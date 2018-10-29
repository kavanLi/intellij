package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Doctor;
import com.philips.h2h.bama.app.identification.domain.model.DoctorModel;

/**
 * Created by Ritchie on 9/19/2017.
 */
@Validated
public interface DoctorBizService {

    DoctorModel createDoctor(@NotNull Doctor model);

    DoctorModel findDoctor(@NotNull Long doctorOid);

    DoctorModel updateDoctor(@NotNull Doctor model);

    Boolean updateDoctorStatus(@NotNull Long doctorOid, @NotNull String status);
}
