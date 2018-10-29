package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Warrior;
import com.philips.h2h.bama.app.identification.domain.model.WarriorModel;
import com.philips.h2h.bama.app.identification.exception.InactiveWarriorModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundWarriorException;
import com.philips.h2h.bama.app.identification.service.atom.WarriorService;
import com.philips.h2h.bama.app.identification.service.business.WarriorBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class WarriorBizServiceImpl implements WarriorBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(WarriorBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private WarriorService warriorService;

    //public methods

    /**
     * create a warrior
     *
     * @param model warrior info
     * @return saved warrior
     */
    @Override
    public WarriorModel createWarrior(@NotNull Warrior model) {
        //biz logical codes go here and use atom service to save it
        Optional <Warrior> warriorOptional = warriorService.saveWarrior(model);
        return warriorOptional.isPresent() ? beenMapper.map(warriorOptional.get(), WarriorModel.class) : null;
    }

    /**
     * use model to updateWarrior
     *
     * @param model target
     * @return updated warrior
     */
    @Override
    public WarriorModel updateWarrior(@NotNull Warrior model) {
        Long warriorOid = model.getOid();
        Warrior warrior;
        Optional <Warrior> warriorOptional = warriorService.findWarriorById(warriorOid);
        if (warriorOptional.isPresent()) {
            warrior = warriorOptional.get();
            //case 1: if target warrior is inactive, we cannot modify it and throw a system exception
            if (!warrior.getActive()) {
                throw new InactiveWarriorModificationException("inactive warrior,deny modifying");
            }
            //biz logic codes go here
            warrior.setName(model.getName());
            warrior.setGenderCode(model.getGenderCode());
            warrior.setWarriorId(model.getWarriorId());
            Optional <Warrior> warriorOptional1 = warriorService.saveWarrior(warrior);
        } else {
            //case 2:if not found target warrior,throw a biz exception
            logger.debug("not found target", model, warriorOid);
            throw new NotFoundWarriorException("not found, can do anyting");
        }
        return warriorOptional.isPresent() ? beenMapper.map(warriorOptional.get(), WarriorModel.class) : null;
    }

    /**
     * findWarrior by warriorOid
     *
     * @param warriorOid target oid
     * @return warrior details
     */
    @Override
    public WarriorModel findWarrior(@NotNull Long warriorOid) {
        Optional <Warrior> warriorOptional = warriorService.findWarriorById(warriorOid);
        return warriorOptional.isPresent() ? beenMapper.map(warriorOptional.get(), WarriorModel.class) : null;
    }
}
