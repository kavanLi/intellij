package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.ChefRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Chef;
import com.philips.h2h.bama.app.identification.service.atom.ChefService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class ChefServiceImpl implements ChefService {

    //fields
    @Autowired
    private ChefRepository chefRepository;

    /**
     * save chef
     *
     * @param chef chef info
     * @return saved chef
     */
    @Override
    public Optional <Chef> saveChef(@NotNull Chef chef) {
        return chefRepository.softlySave(chef);
    }

    /**
     * find a chef by oid
     *
     * @param chefOid targe chef oid
     * @return chef or null
     */
    @Override
    public Optional <Chef> findChefById(@NotNull Long chefOid) {
        Chef chef = chefRepository.findOne(chefOid);
        return Optional.ofNullable(chef);
    }

    /**
     * delete target chef info
     *
     * @param chefOid target chef oid
     */
    @Override
    public void deleteChefByID(@NotNull Long chefOid) {
        chefRepository.softlyDelete(chefOid);
    }

}
