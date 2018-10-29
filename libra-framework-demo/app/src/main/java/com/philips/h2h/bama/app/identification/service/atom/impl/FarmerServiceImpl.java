package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.FarmerRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Farmer;
import com.philips.h2h.bama.app.identification.service.atom.FarmerService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement FarmerService interface
@Service
public class FarmerServiceImpl implements FarmerService {

    //fields
    @Autowired
    private FarmerRepository farmerRepository;

    //public methods

    /**
     * softly save a farmer to repository
     *
     * @param farmer target farmer entity
     * @return saved info
     */
    @Override
    public Optional <Farmer> saveFarmer(@NotNull Farmer farmer) {
        return farmerRepository.softlySave(farmer);
    }

    /**
     * find a farmer from repository
     *
     * @param farmerOid target farmrt oid
     * @return farmer or null
     */
    @Override
    public Optional <Farmer> findFarmerById(@NotNull Long farmerOid) {
        Farmer farmer = farmerRepository.findOne(farmerOid);
        return Optional.ofNullable(farmer);
    }

    /**
     * delete farmer softly from repository
     *
     * @param farmerOid target farmrt oid
     */
    @Override
    public void deleteFarmer(@NotNull Long farmerOid) {
        farmerRepository.softlyDelete(farmerOid);
    }
}
