package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Pilot;
import com.philips.h2h.bama.app.identification.domain.model.PilotModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface PilotBizService {

    PilotModel createPilot(@NotNull Pilot model);

    PilotModel updatePilot(@NotNull Pilot model);

    PilotModel findPilot(@NotNull Long pilotOid);
}
