package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Pirate;
import com.philips.h2h.bama.app.identification.domain.model.PirateModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface PirateBizService {

    PirateModel createPirate(@NotNull Pirate model);

    PirateModel updatePirate(@NotNull Pirate model);

    PirateModel findPirate(@NotNull Long pirateOid);
}
