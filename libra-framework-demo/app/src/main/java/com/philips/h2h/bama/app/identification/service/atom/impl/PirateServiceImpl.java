package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.PirateRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Pirate;
import com.philips.h2h.bama.app.identification.service.atom.PirateService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class PirateServiceImpl implements PirateService {

    //fields
    @Autowired
    private PirateRepository pirateRepository;

    /**
     * save pirate
     *
     * @param pirate pirate info
     * @return saved pirate
     */
    @Override
    public Optional <Pirate> savePirate(@NotNull Pirate pirate) {
        return pirateRepository.softlySave(pirate);
    }

    /**
     * find a pirate by oid
     *
     * @param pirateOid targe pirate oid
     * @return pirate or null
     */
    @Override
    public Optional <Pirate> findPirateById(@NotNull Long pirateOid) {
        Pirate pirate = pirateRepository.findOne(pirateOid);
        return Optional.ofNullable(pirate);
    }

    /**
     * delete target pirate info
     *
     * @param pirateOid target pirate oid
     */
    @Override
    public void deletePirateByID(@NotNull Long pirateOid) {
        pirateRepository.softlyDelete(pirateOid);
    }

}
