package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Pirate;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface PirateService {

    Optional <Pirate> savePirate(@NotNull Pirate pirate);

    Optional <Pirate> findPirateById(@NotNull Long pirateOid);

    void deletePirateByID(@NotNull Long pirateOid);
}
