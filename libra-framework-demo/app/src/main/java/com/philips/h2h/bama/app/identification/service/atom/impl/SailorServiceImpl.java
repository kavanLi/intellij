package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.SailorRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Sailor;
import com.philips.h2h.bama.app.identification.service.atom.SailorService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class SailorServiceImpl implements SailorService {

    //fields
    @Autowired
    private SailorRepository sailorRepository;

    /**
     * save sailor
     *
     * @param sailor sailor info
     * @return saved sailor
     */
    @Override
    public Optional <Sailor> saveSailor(@NotNull Sailor sailor) {
        return sailorRepository.softlySave(sailor);
    }

    /**
     * find a sailor by oid
     *
     * @param sailorOid targe sailor oid
     * @return sailor or null
     */
    @Override
    public Optional <Sailor> findSailorById(@NotNull Long sailorOid) {
        Sailor sailor = sailorRepository.findOne(sailorOid);
        return Optional.ofNullable(sailor);
    }

    /**
     * delete target sailor info
     *
     * @param sailorOid target sailor oid
     */
    @Override
    public void deleteSailorByID(@NotNull Long sailorOid) {
        sailorRepository.softlyDelete(sailorOid);
    }

}
