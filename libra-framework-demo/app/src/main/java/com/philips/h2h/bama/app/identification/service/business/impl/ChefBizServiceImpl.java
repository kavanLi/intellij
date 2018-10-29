package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Chef;
import com.philips.h2h.bama.app.identification.domain.model.ChefModel;
import com.philips.h2h.bama.app.identification.exception.InactiveChefModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundChefException;
import com.philips.h2h.bama.app.identification.service.atom.ChefService;
import com.philips.h2h.bama.app.identification.service.business.ChefBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class ChefBizServiceImpl implements ChefBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(ChefBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private ChefService chefService;

    //public methods

    /**
     * create a chef
     *
     * @param model chef info
     * @return saved chef
     */
    @Override
    public ChefModel createChef(@NotNull Chef model) {
        //biz logical codes go here and use atom service to save it
        Optional <Chef> chefOptional = chefService.saveChef(model);
        return chefOptional.isPresent() ? beenMapper.map(chefOptional.get(), ChefModel.class) : null;
    }

    /**
     * use model to updateChef
     *
     * @param model target
     * @return updated chef
     */
    @Override
    public ChefModel updateChef(@NotNull Chef model) {
        Long chefOid = model.getOid();
        Chef chef;
        Optional <Chef> chefOptional = chefService.findChefById(chefOid);
        if (chefOptional.isPresent()) {
            chef = chefOptional.get();
            //case 1: if target chef is inactive, we cannot modify it and throw a system exception
            if (!chef.getActive()) {
                throw new InactiveChefModificationException("inactive chef,deny modifying");
            }
            //biz logic codes go here
            chef.setName(model.getName());
            chef.setGenderCode(model.getGenderCode());
            chef.setChefId(model.getChefId());
            Optional <Chef> chefOptional1 = chefService.saveChef(chef);
        } else {
            //case 2:if not found target chef,throw a biz exception
            logger.debug("not found target", model, chefOid);
            throw new NotFoundChefException("not found, can do anyting");
        }
        return chefOptional.isPresent() ? beenMapper.map(chefOptional.get(), ChefModel.class) : null;
    }

    /**
     * findChef by chefOid
     *
     * @param chefOid target oid
     * @return chef details
     */
    @Override
    public ChefModel findChef(@NotNull Long chefOid) {
        Optional <Chef> chefOptional = chefService.findChefById(chefOid);
        return chefOptional.isPresent() ? beenMapper.map(chefOptional.get(), ChefModel.class) : null;
    }
}
