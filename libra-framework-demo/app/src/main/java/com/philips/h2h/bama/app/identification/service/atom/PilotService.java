package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Pilot;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface PilotService {

    Optional <Pilot> savePilot(@NotNull Pilot pilot);

    Optional <Pilot> findPilotById(@NotNull Long pilotOid);

    void deletePilotByID(@NotNull Long pilotOid);
}
