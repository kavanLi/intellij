/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.dal.repository.impl;

import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.domain.entity.QPatient;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;
import com.philips.h2h.bama.app.identification.dal.repository.PatientRepository;
import com.philips.h2h.bama.app.identification.dal.repository.PatientRepositoryExtend;
import com.philips.h2h.bama.platform.core.dal.repository.BaseAbstractRepository;
import com.philips.h2h.bama.platform.core.util.querydsl.PredicateUtil;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class of PatientRepositoryExtend.
 */
public class PatientRepositoryImpl extends BaseAbstractRepository implements PatientRepositoryExtend {

    /* fields -------------------------------------------------------------- */

    private final static Logger logger = LoggerFactory.getLogger(PatientRepositoryImpl.class);

    @Autowired
    private PatientRepository patientRepository;

    /* public methods ------------------------------------------------------ */

    /**
     * @see PatientRepositoryExtend#findBySearchCriteria(PatientSearchCriteriaModel)
     */
    @Override
    public List <Patient> findBySearchCriteria(PatientSearchCriteriaModel searchCriteria) {
        QPatient patient = QPatient.patient;
        List <Patient> patientList = getJPQLQueryFactory().selectFrom(patient).where(assembleSearchCriteria(searchCriteria)).fetch();
        return patientList;
    }

    /**
     * @see PatientRepositoryExtend#findBySearchCriteriaPageable(PatientSearchCriteriaModel, Pageable)
     */
    @Override
    public Page <Patient> findBySearchCriteriaPageable(PatientSearchCriteriaModel searchCriteria, Pageable pageable) {
        QPatient patient = QPatient.patient;
        JPQLQuery <Patient> query = getJPQLQueryFactory()
                .selectFrom(patient)
                .where(assembleSearchCriteria(searchCriteria));

        long count = query.fetchCount();

        List <Patient> patientList = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        if (CollectionUtils.isEmpty(patientList)) patientList = new ArrayList <>();

        return new PageImpl <>(patientList, pageable, count);
    }

    /* private methods  -----------------------------------------------------*/

    private BooleanBuilder assembleSearchCriteria(PatientSearchCriteriaModel searchCriteria) {
        QPatient patient = QPatient.patient;

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder
                .and(PredicateUtil.eq(patient.name, searchCriteria.getName()))
                .and(PredicateUtil.eq(patient.genderCode, searchCriteria.getGenderCode()))
                .and(PredicateUtil.eq(patient.ethnicCode, searchCriteria.getEthnicCode()))
                .and(PredicateUtil.eq(patient.idNo, searchCriteria.getIdNo()))

                .and(PredicateUtil.eq(patient.patientId, searchCriteria.getPatientId()))
                .and(PredicateUtil.eq(patient.inpatientId, searchCriteria.getInpatientId()))
                .and(PredicateUtil.eq(patient.outpatientId, searchCriteria.getOutpatientId()))
                .and(PredicateUtil.eq(patient.securityId, searchCriteria.getSecurityId()));

        return booleanBuilder;
    }
}
