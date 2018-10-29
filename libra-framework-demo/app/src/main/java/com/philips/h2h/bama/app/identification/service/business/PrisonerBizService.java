package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Prisoner;
import com.philips.h2h.bama.app.identification.domain.model.PrisonerModel;

/**
 * Created by Ritchie on 9/24/2017.
 */
@Validated
public interface PrisonerBizService {

    PrisonerModel createPrisoner(@NotNull Prisoner model);

    PrisonerModel updatePrisoner(@NotNull Prisoner model);

    PrisonerModel findPrisoner(@NotNull Long prisonerOid);
}
