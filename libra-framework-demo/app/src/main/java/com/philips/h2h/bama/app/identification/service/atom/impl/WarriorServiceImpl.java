package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.WarriorRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Warrior;
import com.philips.h2h.bama.app.identification.service.atom.WarriorService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class WarriorServiceImpl implements WarriorService {

    //fields
    @Autowired
    private WarriorRepository warriorRepository;

    /**
     * save warrior
     *
     * @param warrior warrior info
     * @return saved warrior
     */
    @Override
    public Optional <Warrior> saveWarrior(@NotNull Warrior warrior) {
        return warriorRepository.softlySave(warrior);
    }

    /**
     * find a warrior by oid
     *
     * @param warriorOid targe warrior oid
     * @return warrior or null
     */
    @Override
    public Optional <Warrior> findWarriorById(@NotNull Long warriorOid) {
        Warrior warrior = warriorRepository.findOne(warriorOid);
        return Optional.ofNullable(warrior);
    }

    /**
     * delete target warrior info
     *
     * @param warriorOid target warrior oid
     */
    @Override
    public void deleteWarriorByID(@NotNull Long warriorOid) {
        warriorRepository.delete(warriorOid);
    }

}
