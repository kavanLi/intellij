package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Guard;
import com.philips.h2h.bama.app.identification.domain.model.GuardModel;
import com.philips.h2h.bama.app.identification.exception.InactiveGuardModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundGuardException;
import com.philips.h2h.bama.app.identification.service.atom.GuardService;
import com.philips.h2h.bama.app.identification.service.business.GuardBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement interface
@Service
public class GuardBizServiceImpl implements GuardBizService {

    //fields
    private final static Logger logger = LoggerFactory.getLogger(GuardBizServiceImpl.class);

    @Autowired
    private Mapper beenMapper;

    @Autowired
    private GuardService guardService;

    //public methods

    /**
     * create a guard
     *
     * @param model guard info
     * @return saved guard
     */
    @Override
    public GuardModel createGuard(@NotNull Guard model) {
        //biz logical codes go here and use atom service to save it
        Optional <Guard> guardOptional = guardService.saveGuard(model);
        return guardOptional.isPresent() ? beenMapper.map(guardOptional.get(), GuardModel.class) : null;
    }

    /**
     * use model to updateGuard
     *
     * @param model target
     * @return updated guard
     */
    @Override
    public GuardModel updateGuard(@NotNull Guard model) {
        Long guardOid = model.getOid();
        Guard guard;
        Optional <Guard> guardOptional = guardService.findGuardById(guardOid);
        if (guardOptional.isPresent()) {
            guard = guardOptional.get();
            //case 1: if target guard is inactive, we cannot modify it and throw a system exception
            if (!guard.getActive()) {
                throw new InactiveGuardModificationException("inactive guard,deny modifying");
            }
            //biz logic codes go here
            guard.setName(model.getName());
            guard.setGenderCode(model.getGenderCode());
            guard.setGuardId(model.getGuardId());
            Optional <Guard> guardOptional1 = guardService.saveGuard(guard);
        } else {
            //case 2:if not found target guard,throw a biz exception
            logger.debug("not found target", model, guardOid);
            throw new NotFoundGuardException("not found, can do anyting");
        }
        return guardOptional.isPresent() ? beenMapper.map(guardOptional.get(), GuardModel.class) : null;
    }

    /**
     * findGuard by guardOid
     *
     * @param guardOid target oid
     * @return guard details
     */
    @Override
    public GuardModel findGuard(@NotNull Long guardOid) {
        Optional <Guard> guardOptional = guardService.findGuardById(guardOid);
        return guardOptional.isPresent() ? beenMapper.map(guardOptional.get(), GuardModel.class) : null;
    }
}
