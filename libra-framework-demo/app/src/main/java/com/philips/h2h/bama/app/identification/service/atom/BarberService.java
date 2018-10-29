package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Barber;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface BarberService {

    Optional <Barber> saveBarber(@NotNull Barber barber);

    Optional <Barber> findBarberById(@NotNull Long barberOid);

    void deleteBarberByID(@NotNull Long barberOid);
}
