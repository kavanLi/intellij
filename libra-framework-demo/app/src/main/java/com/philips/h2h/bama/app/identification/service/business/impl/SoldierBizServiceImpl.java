package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Soldier;
import com.philips.h2h.bama.app.identification.domain.model.SoldierModel;
import com.philips.h2h.bama.app.identification.exception.InactiveSoldierModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundSoldierException;
import com.philips.h2h.bama.app.identification.service.atom.SoldierService;
import com.philips.h2h.bama.app.identification.service.business.SoldierBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class SoldierBizServiceImpl implements SoldierBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(SoldierBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private SoldierService soldierService;

    //public methods

    /**
     * create a soldier
     *
     * @param model soldier info
     * @return saved soldier
     */
    @Override
    public SoldierModel createSoldier(@NotNull Soldier model) {
        //biz logical codes go here and use atom service to save it
        Optional <Soldier> soldierOptional = soldierService.saveSoldier(model);
        return soldierOptional.isPresent() ? beenMapper.map(soldierOptional.get(), SoldierModel.class) : null;
    }

    /**
     * use model to updateSoldier
     *
     * @param model target
     * @return updated soldier
     */
    @Override
    public SoldierModel updateSoldier(@NotNull Soldier model) {
        Long soldierOid = model.getOid();
        Soldier soldier;
        Optional <Soldier> soldierOptional = soldierService.findSoldierById(soldierOid);
        if (soldierOptional.isPresent()) {
            soldier = soldierOptional.get();
            //case 1: if target soldier is inactive, we cannot modify it and throw a system exception
            if (!soldier.getActive()) {
                throw new InactiveSoldierModificationException("inactive soldier,deny modifying");
            }
            //biz logic codes go here
            soldier.setName(model.getName());
            soldier.setGenderCode(model.getGenderCode());
            soldier.setSoldierId(model.getSoldierId());
            Optional <Soldier> soldierOptional1 = soldierService.saveSoldier(soldier);
        } else {
            //case 2:if not found target soldier,throw a biz exception
            logger.debug("not found target", model, soldierOid);
            throw new NotFoundSoldierException("not found, can do anyting");
        }
        return soldierOptional.isPresent() ? beenMapper.map(soldierOptional.get(), SoldierModel.class) : null;
    }

    /**
     * findSoldier by soldierOid
     *
     * @param soldierOid target oid
     * @return soldier details
     */
    @Override
    public SoldierModel findSoldier(@NotNull Long soldierOid) {
        Optional <Soldier> soldierOptional = soldierService.findSoldierById(soldierOid);
        return soldierOptional.isPresent() ? beenMapper.map(soldierOptional.get(), SoldierModel.class) : null;
    }
}
