package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.CaptainRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Captain;
import com.philips.h2h.bama.app.identification.service.atom.CaptainService;

/**
 * Created by Ritchie on 9/24/2017.
 */
@Service
public class CaptainServiceImpl implements CaptainService {

    //fields
    @Autowired
    private CaptainRepository captainRepository;

    //public methods

    @Override
    public Optional <Captain> saveCaptain(@NotNull Captain captain) {
        return captainRepository.softlySave(captain);
    }

    @Override
    public Optional <Captain> findCaptainById(@NotNull Long captainOid) {
        Captain captain = captainRepository.findOne(captainOid);
        return Optional.ofNullable(captain);
    }

    @Override
    public void deleteCaptainById(@NotNull Long captainOid) {
        captainRepository.softlyDelete(captainOid);
    }
}
