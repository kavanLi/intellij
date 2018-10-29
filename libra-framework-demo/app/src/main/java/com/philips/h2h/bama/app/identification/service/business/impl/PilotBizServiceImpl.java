package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Pilot;
import com.philips.h2h.bama.app.identification.domain.model.PilotModel;
import com.philips.h2h.bama.app.identification.exception.InactivePilotModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundPilotException;
import com.philips.h2h.bama.app.identification.service.atom.PilotService;
import com.philips.h2h.bama.app.identification.service.business.PilotBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class PilotBizServiceImpl implements PilotBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(PilotBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private PilotService pilotService;

    //public methods

    /**
     * create a pilot
     *
     * @param model pilot info
     * @return saved pilot
     */
    @Override
    public PilotModel createPilot(@NotNull Pilot model) {
        //biz logical codes go here and use atom service to save it
        Optional <Pilot> pilotOptional = pilotService.savePilot(model);
        return pilotOptional.isPresent() ? beenMapper.map(pilotOptional.get(), PilotModel.class) : null;
    }

    /**
     * use model to updatePilot
     *
     * @param model target
     * @return updated pilot
     */
    @Override
    public PilotModel updatePilot(@NotNull Pilot model) {
        Long pilotOid = model.getOid();
        Pilot pilot;
        Optional <Pilot> pilotOptional = pilotService.findPilotById(pilotOid);
        if (pilotOptional.isPresent()) {
            pilot = pilotOptional.get();
            //case 1: if target pilot is inactive, we cannot modify it and throw a system exception
            if (!pilot.getActive()) {
                throw new InactivePilotModificationException("inactive pilot,deny modifying");
            }
            //biz logic codes go here
            pilot.setName(model.getName());
            pilot.setGenderCode(model.getGenderCode());
            pilot.setPilotId(model.getPilotId());
            Optional <Pilot> pilotOptional1 = pilotService.savePilot(pilot);
        } else {
            //case 2:if not found target pilot,throw a biz exception
            logger.debug("not found target", model, pilotOid);
            throw new NotFoundPilotException("not found, can do anyting");
        }
        return pilotOptional.isPresent() ? beenMapper.map(pilotOptional.get(), PilotModel.class) : null;
    }

    /**
     * findPilot by pilotOid
     *
     * @param pilotOid target oid
     * @return pilot details
     */
    @Override
    public PilotModel findPilot(@NotNull Long pilotOid) {
        Optional <Pilot> pilotOptional = pilotService.findPilotById(pilotOid);
        return pilotOptional.isPresent() ? beenMapper.map(pilotOptional.get(), PilotModel.class) : null;
    }
}
