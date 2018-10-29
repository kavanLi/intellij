package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Pirate;
import com.philips.h2h.bama.app.identification.domain.model.PirateModel;
import com.philips.h2h.bama.app.identification.exception.InactivePirateModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundPirateException;
import com.philips.h2h.bama.app.identification.service.atom.PirateService;
import com.philips.h2h.bama.app.identification.service.business.PirateBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class PirateBizServiceImpl implements PirateBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(PirateBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private PirateService pirateService;

    //public methods

    /**
     * create a pirate
     *
     * @param model pirate info
     * @return saved pirate
     */
    @Override
    public PirateModel createPirate(@NotNull Pirate model) {
        //biz logical codes go here and use atom service to save it
        Optional <Pirate> pirateOptional = pirateService.savePirate(model);
        return pirateOptional.isPresent() ? beenMapper.map(pirateOptional.get(), PirateModel.class) : null;
    }

    /**
     * use model to updatePirate
     *
     * @param model target
     * @return updated pirate
     */
    @Override
    public PirateModel updatePirate(@NotNull Pirate model) {
        Long pirateOid = model.getOid();
        Pirate pirate;
        Optional <Pirate> pirateOptional = pirateService.findPirateById(pirateOid);
        if (pirateOptional.isPresent()) {
            pirate = pirateOptional.get();
            //case 1: if target pirate is inactive, we cannot modify it and throw a system exception
            if (!pirate.getActive()) {
                throw new InactivePirateModificationException("inactive pirate,deny modifying");
            }
            //biz logic codes go here
            pirate.setName(model.getName());
            pirate.setGenderCode(model.getGenderCode());
            pirate.setPirateId(model.getPirateId());
            Optional <Pirate> pirateOptional1 = pirateService.savePirate(pirate);
        } else {
            //case 2:if not found target pirate,throw a biz exception
            logger.debug("not found target", model, pirateOid);
            throw new NotFoundPirateException("not found, can do anyting");
        }
        return pirateOptional.isPresent() ? beenMapper.map(pirateOptional.get(), PirateModel.class) : null;
    }

    /**
     * findPirate by pirateOid
     *
     * @param pirateOid target oid
     * @return pirate details
     */
    @Override
    public PirateModel findPirate(@NotNull Long pirateOid) {
        Optional <Pirate> pirateOptional = pirateService.findPirateById(pirateOid);
        return pirateOptional.isPresent() ? beenMapper.map(pirateOptional.get(), PirateModel.class) : null;
    }
}
