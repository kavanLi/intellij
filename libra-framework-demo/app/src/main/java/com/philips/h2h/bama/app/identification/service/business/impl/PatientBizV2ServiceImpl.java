/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.service.business.impl;

import com.philips.h2h.bama.app.identification.dal.dao.PatientDao;
import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.domain.model.PatientComprehensiveModel;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;
import com.philips.h2h.bama.app.identification.service.business.PatientBizV2Service;
import com.philips.h2h.bama.app.identification.service.business.PatientBizService;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * Implementation Class of {@link PatientBizService}.
 */
@Service
public class PatientBizV2ServiceImpl implements PatientBizV2Service {

    /* fields          ------------------------------------------------------*/

    private final static Logger logger = LoggerFactory.getLogger(PatientBizV2ServiceImpl.class);

    //    @Resource(name = "patientDaoDslImpl")
    @Resource(name = "patientDaoHqlImpl")
    private PatientDao patientDao;

    @Autowired
    private Mapper beanMapper;

    /* public methods  ------------------------------------------------------*/

    @Override
    public PatientComprehensiveModel findPatient(@NotNull Long patientOid) {
        Patient patient = patientDao.findById(patientOid);
        return beanMapper.map(patient, PatientComprehensiveModel.class);
    }

    @Override
    public List <Patient> findAllBySearchCriteria(@NotNull PatientSearchCriteriaModel searchCriteria) {
        return patientDao.findBySearchCriteria(searchCriteria);
    }
}
