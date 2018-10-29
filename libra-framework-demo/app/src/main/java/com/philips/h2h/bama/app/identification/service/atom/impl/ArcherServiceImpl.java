package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.ArcherRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Archer;
import com.philips.h2h.bama.app.identification.service.atom.ArcherService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class ArcherServiceImpl implements ArcherService {

    //fields
    @Autowired
    private ArcherRepository archerRepository;

    /**
     * save archer
     *
     * @param archer archer info
     * @return saved archer
     */
    @Override
    public Optional <Archer> saveArcher(@NotNull Archer archer) {
        return archerRepository.softlySave(archer);
    }

    /**
     * find a archer by oid
     *
     * @param archerOid targe archer oid
     * @return archer or null
     */
    @Override
    public Optional <Archer> findArcherById(@NotNull Long archerOid) {
        Archer archer = archerRepository.findOne(archerOid);
        return Optional.ofNullable(archer);
    }

    /**
     * delete target archer info
     *
     * @param archerOid target archer oid
     */
    @Override
    public void deleteArcherByID(@NotNull Long archerOid) {
        archerRepository.softlyDelete(archerOid);
    }

}
