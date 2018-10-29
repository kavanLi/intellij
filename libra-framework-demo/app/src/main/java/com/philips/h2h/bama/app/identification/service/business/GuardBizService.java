package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Guard;
import com.philips.h2h.bama.app.identification.domain.model.GuardModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface GuardBizService {

    GuardModel createGuard(@NotNull Guard model);

    GuardModel updateGuard(@NotNull Guard model);

    GuardModel findGuard(@NotNull Long guardOid);
}
