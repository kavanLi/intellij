package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Sailor;
import com.philips.h2h.bama.app.identification.domain.model.SailorModel;
import com.philips.h2h.bama.app.identification.exception.InactiveSailorModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundSailorException;
import com.philips.h2h.bama.app.identification.service.atom.SailorService;
import com.philips.h2h.bama.app.identification.service.business.SailorBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class SailorBizServiceImpl implements SailorBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(SailorBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private SailorService sailorService;

    //public methods

    /**
     * create a sailor
     *
     * @param model sailor info
     * @return saved sailor
     */
    @Override
    public SailorModel createSailor(@NotNull Sailor model) {
        //biz logical codes go here and use atom service to save it
        Optional <Sailor> sailorOptional = sailorService.saveSailor(model);
        return sailorOptional.isPresent() ? beenMapper.map(sailorOptional.get(), SailorModel.class) : null;
    }

    /**
     * use model to updateSailor
     *
     * @param model target
     * @return updated sailor
     */
    @Override
    public SailorModel updateSailor(@NotNull Sailor model) {
        Long sailorOid = model.getOid();
        Sailor sailor;
        Optional <Sailor> sailorOptional = sailorService.findSailorById(sailorOid);
        if (sailorOptional.isPresent()) {
            sailor = sailorOptional.get();
            //case 1: if target sailor is inactive, we cannot modify it and throw a system exception
            if (!sailor.getActive()) {
                throw new InactiveSailorModificationException("inactive sailor,deny modifying");
            }
            //biz logic codes go here
            sailor.setName(model.getName());
            sailor.setGenderCode(model.getGenderCode());
            sailor.setSailorId(model.getSailorId());
            Optional <Sailor> sailorOptional1 = sailorService.saveSailor(sailor);
        } else {
            //case 2:if not found target sailor,throw a biz exception
            logger.debug("not found target", model, sailorOid);
            throw new NotFoundSailorException("not found, can do anyting");
        }
        return sailorOptional.isPresent() ? beenMapper.map(sailorOptional.get(), SailorModel.class) : null;
    }

    /**
     * findSailor by sailorOid
     *
     * @param sailorOid target oid
     * @return sailor details
     */
    @Override
    public SailorModel findSailor(@NotNull Long sailorOid) {
        Optional <Sailor> sailorOptional = sailorService.findSailorById(sailorOid);
        return sailorOptional.isPresent() ? beenMapper.map(sailorOptional.get(), SailorModel.class) : null;
    }
}
