package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Barber;
import com.philips.h2h.bama.app.identification.domain.model.BarberModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface BarberBizService {

    BarberModel createBarber(@NotNull Barber model);

    BarberModel updateBarber(@NotNull Barber model);

    BarberModel findBarber(@NotNull Long barberOid);
}
