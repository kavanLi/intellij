package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Archer;
import com.philips.h2h.bama.app.identification.domain.model.ArcherModel;
import com.philips.h2h.bama.app.identification.exception.InactiveArcherModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundArcherException;
import com.philips.h2h.bama.app.identification.service.atom.ArcherService;
import com.philips.h2h.bama.app.identification.service.business.ArcherBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class ArcherBizServiceImpl implements ArcherBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(ArcherBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private ArcherService archerService;

    //public methods

    /**
     * create a archer
     *
     * @param model archer info
     * @return saved archer
     */
    @Override
    public ArcherModel createArcher(@NotNull Archer model) {
        //biz logical codes go here and use atom service to save it
        Optional <Archer> archerOptional = archerService.saveArcher(model);
        return archerOptional.isPresent() ? beenMapper.map(archerOptional.get(), ArcherModel.class) : null;
    }

    /**
     * use model to updateArcher
     *
     * @param model target
     * @return updated archer
     */
    @Override
    public ArcherModel updateArcher(@NotNull Archer model) {
        Long archerOid = model.getOid();
        Archer archer;
        Optional <Archer> archerOptional = archerService.findArcherById(archerOid);
        if (archerOptional.isPresent()) {
            archer = archerOptional.get();
            //case 1: if target archer is inactive, we cannot modify it and throw a system exception
            if (!archer.getActive()) {
                throw new InactiveArcherModificationException("inactive archer,deny modifying");
            }
            //biz logic codes go here
            archer.setName(model.getName());
            archer.setGenderCode(model.getGenderCode());
            archer.setArcherId(model.getArcherId());
            Optional <Archer> archerOptional1 = archerService.saveArcher(archer);
        } else {
            //case 2:if not found target archer,throw a biz exception
            logger.debug("not found target", model, archerOid);
            throw new NotFoundArcherException("not found, can do anyting");
        }
        return archerOptional.isPresent() ? beenMapper.map(archerOptional.get(), ArcherModel.class) : null;
    }

    /**
     * findArcher by archerOid
     *
     * @param archerOid target oid
     * @return archer details
     */
    @Override
    public ArcherModel findArcher(@NotNull Long archerOid) {
        Optional <Archer> archerOptional = archerService.findArcherById(archerOid);
        return archerOptional.isPresent() ? beenMapper.map(archerOptional.get(), ArcherModel.class) : null;
    }
}
