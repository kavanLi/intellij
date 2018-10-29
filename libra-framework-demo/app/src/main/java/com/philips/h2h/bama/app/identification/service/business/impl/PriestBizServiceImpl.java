package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Priest;
import com.philips.h2h.bama.app.identification.domain.model.PriestModel;
import com.philips.h2h.bama.app.identification.exception.InactivePriestModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundPriestException;
import com.philips.h2h.bama.app.identification.service.atom.PriestService;
import com.philips.h2h.bama.app.identification.service.business.PriestBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class PriestBizServiceImpl implements PriestBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(PriestBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private PriestService priestService;

    //public methods

    /**
     * create a priest
     *
     * @param model priest info
     * @return saved priest
     */
    @Override
    public PriestModel createPriest(@NotNull Priest model) {
        //biz logical codes go here and use atom service to save it
        Optional <Priest> priestOptional = priestService.savePriest(model);
        return priestOptional.isPresent() ? beenMapper.map(priestOptional.get(), PriestModel.class) : null;
    }

    /**
     * use model to updatePriest
     *
     * @param model target
     * @return updated priest
     */
    @Override
    public PriestModel updatePriest(@NotNull Priest model) {
        Long priestOid = model.getOid();
        Priest priest;
        Optional <Priest> priestOptional = priestService.findPriestById(priestOid);
        if (priestOptional.isPresent()) {
            priest = priestOptional.get();
            //case 1: if target priest is inactive, we cannot modify it and throw a system exception
            if (!priest.getActive()) {
                throw new InactivePriestModificationException("inactive priest,deny modifying");
            }
            //biz logic codes go here
            priest.setName(model.getName());
            priest.setGenderCode(model.getGenderCode());
            priest.setPriestId(model.getPriestId());
            Optional <Priest> priestOptional1 = priestService.savePriest(priest);
        } else {
            //case 2:if not found target priest,throw a biz exception
            logger.debug("not found target", model, priestOid);
            throw new NotFoundPriestException("not found, can do anyting");
        }
        return priestOptional.isPresent() ? beenMapper.map(priestOptional.get(), PriestModel.class) : null;
    }

    /**
     * findPriest by priestOid
     *
     * @param priestOid target oid
     * @return priest details
     */
    @Override
    public PriestModel findPriest(@NotNull Long priestOid) {
        Optional <Priest> priestOptional = priestService.findPriestById(priestOid);
        return priestOptional.isPresent() ? beenMapper.map(priestOptional.get(), PriestModel.class) : null;
    }
}
