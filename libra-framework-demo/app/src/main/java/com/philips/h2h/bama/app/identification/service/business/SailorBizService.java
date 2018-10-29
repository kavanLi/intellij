package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Sailor;
import com.philips.h2h.bama.app.identification.domain.model.SailorModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface SailorBizService {

    SailorModel createSailor(@NotNull Sailor model);

    SailorModel updateSailor(@NotNull Sailor model);

    SailorModel findSailor(@NotNull Long sailorOid);
}
