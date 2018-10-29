package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.GuardRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Guard;
import com.philips.h2h.bama.app.identification.service.atom.GuardService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class GuardServiceImpl implements GuardService {

    //fields
    @Autowired
    private GuardRepository guardRepository;

    /**
     * save guard
     *
     * @param guard guard info
     * @return saved guard
     */
    @Override
    public Optional <Guard> saveGuard(@NotNull Guard guard) {
        return guardRepository.softlySave(guard);
    }

    /**
     * find a guard by oid
     *
     * @param guardOid targe guard oid
     * @return guard or null
     */
    @Override
    public Optional <Guard> findGuardById(@NotNull Long guardOid) {
        Guard guard = guardRepository.findOne(guardOid);
        return Optional.ofNullable(guard);
    }

    /**
     * delete target guard info
     *
     * @param guardOid target guard oid
     */
    @Override
    public void deleteGuardByID(@NotNull Long guardOid) {
        guardRepository.softlyDelete(guardOid);
    }

}
