package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.PrisonerRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Prisoner;
import com.philips.h2h.bama.app.identification.service.atom.PrisonerService;

/**
 * Created by Ritchie on 9/24/2017.
 */
// implement PrisonerService interface
@Service
public class PrisonerServiceImpl implements PrisonerService {

    //fields

    @Autowired
    private PrisonerRepository prisonerRepository;

    //public methods

    @Override
    public Optional <Prisoner> savePrisoner(@NotNull Prisoner prisoner) {
        return prisonerRepository.softlySave(prisoner);
    }

    @Override
    public Optional <Prisoner> findPrisonerByID(@NotNull Long prisonerOid) {
        Prisoner prisoner = prisonerRepository.findOne(prisonerOid);
        return Optional.ofNullable(prisoner);
    }

    @Override
    public void deletePrisonerById(@NotNull Long prisonerOid) {
        prisonerRepository.softlyDelete(prisonerOid);
    }
}
