package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Priest;
import com.philips.h2h.bama.app.identification.domain.model.PriestModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface PriestBizService {

    PriestModel createPriest(@NotNull Priest model);

    PriestModel updatePriest(@NotNull Priest model);

    PriestModel findPriest(@NotNull Long priestOid);
}
