package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.PilotRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Pilot;
import com.philips.h2h.bama.app.identification.service.atom.PilotService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class PilotServiceImpl implements PilotService {

    //fields
    @Autowired
    private PilotRepository pilotRepository;

    /**
     * save pilot
     *
     * @param pilot pilot info
     * @return saved pilot
     */
    @Override
    public Optional <Pilot> savePilot(@NotNull Pilot pilot) {
        return pilotRepository.softlySave(pilot);
    }

    /**
     * find a pilot by oid
     *
     * @param pilotOid targe pilot oid
     * @return pilot or null
     */
    @Override
    public Optional <Pilot> findPilotById(@NotNull Long pilotOid) {
        Pilot pilot = pilotRepository.findOne(pilotOid);
        return Optional.ofNullable(pilot);
    }

    /**
     * delete target pilot info
     *
     * @param pilotOid target pilot oid
     */
    @Override
    public void deletePilotByID(@NotNull Long pilotOid) {
        pilotRepository.softlyDelete(pilotOid);
    }

}
