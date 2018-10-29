package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.SoldierRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Soldier;
import com.philips.h2h.bama.app.identification.service.atom.SoldierService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class SoldierServiceImpl implements SoldierService {

    //fields
    @Autowired
    private SoldierRepository soldierRepository;

    /**
     * save soldier
     *
     * @param soldier soldier info
     * @return saved soldier
     */
    @Override
    public Optional <Soldier> saveSoldier(@NotNull Soldier soldier) {
        return soldierRepository.softlySave(soldier);
    }

    /**
     * find a soldier by oid
     *
     * @param soldierOid targe soldier oid
     * @return soldier or null
     */
    @Override
    public Optional <Soldier> findSoldierById(@NotNull Long soldierOid) {
        Soldier soldier = soldierRepository.findOne(soldierOid);
        return Optional.ofNullable(soldier);
    }

    /**
     * delete target soldier info
     *
     * @param soldierOid target soldier oid
     */
    @Override
    public void deleteSoldierByID(@NotNull Long soldierOid) {
        soldierRepository.softlyDelete(soldierOid);
    }

}
