package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.dozer.MappingProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Farmer;
import com.philips.h2h.bama.app.identification.domain.model.FarmerModel;
import com.philips.h2h.bama.app.identification.exception.InactiveFarmerModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundFarmerException;
import com.philips.h2h.bama.app.identification.service.atom.FarmerService;
import com.philips.h2h.bama.app.identification.service.business.FarmerBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement FarmerBizService
@Service
public class FarmerBizServiceImpl implements FarmerBizService {

    //fields

    private final static Logger logger = LoggerFactory.getLogger(FarmerBizService.class);

    @Autowired
    private FarmerService farmerService;

    @Autowired
    private Mapper beanMapper;


    @Override
    public FarmerModel createFarmer(@NotNull Farmer model) {
        //biz logic codes go here, then use atom service to save
        Optional <Farmer> farmerOptional = farmerService.saveFarmer(model);
        return farmerOptional.isPresent() ? beanMapper.map(farmerOptional.get(), FarmerModel.class) : null;
    }

    @Override
    public FarmerModel updateFarmer(@NotNull Farmer model) {
        Long farmerOid = model.getOid();
        Farmer farmer;
        Optional <Farmer> farmerOptional = farmerService.findFarmerById(farmerOid);

        if (farmerOptional.isPresent()) {
            farmer = farmerOptional.get();
            //case 1:if farmer is inactive, we cannot modify it and throw system exception
            if (!farmer.getActive()) {
                throw new InactiveFarmerModificationException("inactive target,cannot modify it");
            }
            //biz logic codes go here
            farmer.setName(model.getName());
            farmer.setGenderCode(model.getGenderCode());
            farmer.setFarmerId(model.getFarmerId());

            farmerOptional = farmerService.saveFarmer(farmer);
        } else {
            //case 2:if target farmer cannot be found, throw a biz exception
            logger.debug("cannot found", farmerOid, model);
            throw new NotFoundFarmerException("nothing");
        }

        return farmerOptional.isPresent() ? beanMapper.map(farmerOptional.get(), FarmerModel.class) : null;
    }

    @Override
    public FarmerModel findFarmer(@NotNull Long farmerOid) {
        Optional <Farmer> farmerOptional = farmerService.findFarmerById(farmerOid);
        return farmerOptional.isPresent() ? beanMapper.map(farmerOptional.get(), FarmerModel.class) : null;
    }
}
