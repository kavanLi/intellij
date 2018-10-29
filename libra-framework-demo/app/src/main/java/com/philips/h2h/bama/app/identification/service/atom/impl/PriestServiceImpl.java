package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.PriestRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Priest;
import com.philips.h2h.bama.app.identification.service.atom.PriestService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class PriestServiceImpl implements PriestService {

    //fields
    @Autowired
    private PriestRepository priestRepository;

    /**
     * save priest
     *
     * @param priest priest info
     * @return saved priest
     */
    @Override
    public Optional <Priest> savePriest(@NotNull Priest priest) {
        return priestRepository.softlySave(priest);
    }

    /**
     * find a priest by oid
     *
     * @param priestOid targe priest oid
     * @return priest or null
     */
    @Override
    public Optional <Priest> findPriestById(@NotNull Long priestOid) {
        Priest priest = priestRepository.findOne(priestOid);
        return Optional.ofNullable(priest);
    }

    /**
     * delete target priest info
     *
     * @param priestOid target priest oid
     */
    @Override
    public void deletePriestByID(@NotNull Long priestOid) {
        priestRepository.softlyDelete(priestOid);
    }

}
