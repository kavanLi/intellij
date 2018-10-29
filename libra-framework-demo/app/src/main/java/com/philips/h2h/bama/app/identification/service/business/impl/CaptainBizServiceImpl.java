package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Captain;
import com.philips.h2h.bama.app.identification.domain.model.CaptainModel;
import com.philips.h2h.bama.app.identification.exception.InactiveCaptainModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundCaptainException;
import com.philips.h2h.bama.app.identification.service.atom.CaptainService;
import com.philips.h2h.bama.app.identification.service.atom.impl.CaptainServiceImpl;
import com.philips.h2h.bama.app.identification.service.business.CaptainBizService;

/**
 * Created by Ritchie on 9/24/2017.
 */
@Service
public class CaptainBizServiceImpl implements CaptainBizService {

    private final static Logger logger = LoggerFactory.getLogger(CaptainBizServiceImpl.class);

    @Autowired
    private CaptainService captainService;

    @Autowired
    private Mapper beanMapper;

    @Override
    public CaptainModel createCaptain(@NotNull Captain model) {
        Optional <Captain> captainOptional = captainService.saveCaptain(model);
        return captainOptional.isPresent() ? beanMapper.map(captainOptional.get(), CaptainModel.class) : null;
    }

    @Override
    public CaptainModel updateCaptain(@NotNull Captain model) {
        Long captainOid = model.getOid();
        Captain captain;
        Optional <Captain> captainOptional = captainService.findCaptainById(captainOid);
        if (captainOptional.isPresent()) {
            captain = captainOptional.get();

            if (!captain.getActive()) {
                throw new InactiveCaptainModificationException("inactive");
            }

            captain.setName(model.getName());
            captain.setGenderCode(model.getGenderCode());
            captain.setCaptainId(model.getCaptainId());
            captainOptional = captainService.saveCaptain(captain);
        } else {
            logger.debug("not found", model, captainOid);
            throw new NotFoundCaptainException("not found");
        }
        return captainOptional.isPresent() ? beanMapper.map(captainOptional.get(), CaptainModel.class) : null;
    }

    @Override
    public CaptainModel findCaptain(@NotNull Long captainOid) {
        Optional <Captain> captainOptional = captainService.findCaptainById(captainOid);
        return captainOptional.isPresent() ? beanMapper.map(captainOptional.get(), CaptainModel.class) : null;
    }
}
