package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Captain;
import com.philips.h2h.bama.app.identification.domain.model.CaptainModel;

/**
 * Created by Ritchie on 9/24/2017.
 */
@Validated
public interface CaptainBizService {

    CaptainModel createCaptain(@NotNull Captain model);

    CaptainModel updateCaptain(@NotNull Captain model);

    CaptainModel findCaptain(@NotNull Long captainOid);
}
