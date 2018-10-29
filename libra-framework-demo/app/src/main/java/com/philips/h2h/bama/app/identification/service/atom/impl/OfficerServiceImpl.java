package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.OfficerRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Officer;
import com.philips.h2h.bama.app.identification.service.atom.OfficerService;

/**
 * Created by Ritchie on 9/22/2017.
 */

/**
 * Implementation class of {@Link OfficerService}
 */
@Service
public class OfficerServiceImpl implements OfficerService {

    //fields
    @Autowired
    private OfficerRepository officerRepository;

    //public methods

    //@see OfficerService#saveOfficer(Officer officer)
    @Override
    public Optional <Officer> saveOfficer(@NotNull Officer officer) {
        return officerRepository.softlySave(officer);
    }

    //@see OfficeService#findOfficerById(Java.Lang.Long)
    @Override
    public Optional <Officer> findOfficerById(@NotNull Long officerOid) {
        Officer officer = officerRepository.findOne(officerOid);
        return Optional.ofNullable(officer);
    }

    //@see OfficerService#deleteOfficer(Java.Lang.Long)
    @Override
    public void deleteOfficer(@NotNull Long officerOid) {
        officerRepository.softlyDelete(officerOid);
    }
}
