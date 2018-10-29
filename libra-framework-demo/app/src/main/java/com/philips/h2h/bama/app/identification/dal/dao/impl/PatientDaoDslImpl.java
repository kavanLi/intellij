/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.dal.dao.impl;

import com.philips.h2h.bama.app.identification.dal.dao.PatientDao;
import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.domain.entity.QPatient;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;
import com.philips.h2h.bama.platform.core.dal.dao.BaseDaoImpl;
import com.philips.h2h.bama.platform.core.util.querydsl.PredicateUtil;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.hibernate.HibernateQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * QueryDSL based implementation class of PatientDao.
 */
@Repository("patientDaoDslImpl")
public class PatientDaoDslImpl extends BaseDaoImpl <Patient, Long> implements PatientDao {

    /* public methods  ------------------------------------------------------*/

    /**
     * @see PatientDao#findById(Long)
     */
    @Override
    public Patient findById(Long patientOid) {
        Patient result = getHibernateTemplate().executeWithNativeSession((session -> {
            HibernateQueryFactory queryFactory = new HibernateQueryFactory(session);
            QPatient patient = QPatient.patient;
            return queryFactory
                    .selectFrom(patient)
                    .where(PredicateUtil.eq(patient.oid, patientOid))
                    .fetchOne();
        }));

        return result;
    }

    /**
     * @see PatientDao#findBySearchCriteria(PatientSearchCriteriaModel)
     */
    @Override
    public List <Patient> findBySearchCriteria(PatientSearchCriteriaModel searchCriteria) {
        List <Patient> result = getHibernateTemplate().executeWithNativeSession((session -> {
            JPQLQueryFactory queryFactory = new HibernateQueryFactory(session);
            QPatient patient = QPatient.patient;
            return queryFactory
                    .selectFrom(patient)
                    .where(new BooleanBuilder()
                            .and(PredicateUtil.eq(patient.name, searchCriteria.getName()))
                            .and(PredicateUtil.eq(patient.genderCode, searchCriteria.getGenderCode()))
                            .and(PredicateUtil.eq(patient.ethnicCode, searchCriteria.getEthnicCode()))
                            .and(PredicateUtil.eq(patient.idNo, searchCriteria.getIdNo()))

                            .and(PredicateUtil.eq(patient.patientId, searchCriteria.getPatientId()))
                            .and(PredicateUtil.eq(patient.inpatientId, searchCriteria.getInpatientId()))
                            .and(PredicateUtil.eq(patient.outpatientId, searchCriteria.getOutpatientId()))
                            .and(PredicateUtil.eq(patient.securityId, searchCriteria.getSecurityId())))
                    .fetch();
        }));

        return result;
    }
}
