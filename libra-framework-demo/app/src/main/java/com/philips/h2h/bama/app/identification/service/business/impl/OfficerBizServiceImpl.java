package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;


import com.thoughtworks.xstream.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.OfficerRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Officer;
import com.philips.h2h.bama.app.identification.domain.model.OfficerModel;
import com.philips.h2h.bama.app.identification.exception.InactiveOfficerModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundOfficerException;
import com.philips.h2h.bama.app.identification.service.atom.OfficerService;
import com.philips.h2h.bama.app.identification.service.business.OfficerBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
// implement OfficerBizService
@Service
public class OfficerBizServiceImpl implements OfficerBizService {
    //fields
    private final static Logger logger = LoggerFactory.getLogger(OfficerBizService.class);

    @Autowired
    private OfficerService officerService;

    @Autowired
    private org.dozer.Mapper beanMapper;

    //public methods
    //@see OfficerBizService#creatOfficer(Officer model)
    @Override
    public OfficerModel createOfficer(@NotNull Officer model) {
        //biz logic codes go here, then use atom service to save it
        Optional <Officer> officerOptional = officerService.saveOfficer(model);
        return officerOptional.isPresent() ? beanMapper.map(officerOptional.get(), OfficerModel.class) : null;
    }

    //@see OfficerBizService#updateOfficer(Officer model)
    @Override
    public OfficerModel updateOfficer(@NotNull Officer model) {
        Long officerOid = model.getOid();
        ;
        Officer officer;
        Optional <Officer> officerOptional = officerService.findOfficerById(officerOid);
        if (officerOptional.isPresent()) {
            officer = officerOptional.get();
            //case 1:if entity is inactiue, throw a system exception
            if (!officer.getActive()) {
                throw new InactiveOfficerModificationException("inantive entity, cannot be modified");
            }
            //biz logic codes go here.
            officer.setName(model.getName());
            officer.setGenderCode(model.getGenderCode());
            officer.setOfficerId(model.getOfficerId());
            officerOptional = officerService.saveOfficer(officer);
        } else {
            //case 2:if entity cannot be found, throw a biz exception
            logger.debug("not exist entity", officerOid, model);
            throw new NotFoundOfficerException("cannot found entity");
        }
        return officerOptional.isPresent() ? beanMapper.map(officerOptional.get(), OfficerModel.class) : null;
    }

    //@see OfficerBizService#findOfficer(Long officeOid)
    @Override
    public OfficerModel findOfficer(@NotNull Long officerOid) {
        Optional <Officer> officerOptional = officerService.findOfficerById(officerOid);
        return officerOptional.isPresent() ? beanMapper.map(officerOptional.get(), OfficerModel.class) : null;
    }
}
