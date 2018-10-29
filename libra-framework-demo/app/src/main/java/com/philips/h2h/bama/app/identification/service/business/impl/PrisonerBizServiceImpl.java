package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Prisoner;
import com.philips.h2h.bama.app.identification.domain.model.PrisonerModel;
import com.philips.h2h.bama.app.identification.exception.InactivePatientModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundPrisonerException;
import com.philips.h2h.bama.app.identification.service.atom.PrisonerService;
import com.philips.h2h.bama.app.identification.service.business.PrisonerBizService;

/**
 * Created by Ritchie on 9/24/2017.
 */
// implement PrisonerBizService interface
@Service
public class PrisonerBizServiceImpl implements PrisonerBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(PrisonerBizServiceImpl.class);

    @Autowired
    private PrisonerService prisonerService;

    @Autowired
    private Mapper beanMapper;

    //public methods

    @Override
    public PrisonerModel createPrisoner(@NotNull Prisoner model) {
        Optional <Prisoner> prisonerOptional = prisonerService.savePrisoner(model);
        return prisonerOptional.isPresent() ? beanMapper.map(prisonerOptional.get(), PrisonerModel.class) : null;
    }

    @Override
    public PrisonerModel updatePrisoner(@NotNull Prisoner model) {
        Long prisonerOid = model.getOid();
        Prisoner prisoner;
        Optional <Prisoner> prisonerOptional = prisonerService.findPrisonerByID(prisonerOid);
        if (prisonerOptional.isPresent()) {
            prisoner = prisonerOptional.get();
            //case 1: if target prisoner is inactive, we cannot moodifi it and throw a system exception
            if (!prisoner.getActive()) {
                throw new InactivePatientModificationException("inactive,cannot modify");
            }
            //biz logic codes go here.
            prisoner.setName(model.getName());
            prisoner.setGenderCode(model.getGenderCode());
            prisoner.setPrisonerId(model.getPrisonerId());
            prisonerOptional = prisonerService.savePrisoner(prisoner);
        } else {
            //case 2: if we cannot find a target prisoner,throw a biz exception
            logger.debug("not found", model, prisonerOid);
            throw new NotFoundPrisonerException("not found");
        }

        return prisonerOptional.isPresent() ? beanMapper.map(prisonerOptional.get(), PrisonerModel.class) : null;
    }

    @Override
    public PrisonerModel findPrisoner(@NotNull Long prisonerOid) {
        Optional <Prisoner> prisonerOptional = prisonerService.findPrisonerByID(prisonerOid);
        return prisonerOptional.isPresent() ? beanMapper.map(prisonerOptional.get(), PrisonerModel.class) : null;
    }
}
