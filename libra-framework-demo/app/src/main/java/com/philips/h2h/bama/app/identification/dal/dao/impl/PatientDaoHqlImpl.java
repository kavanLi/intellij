/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.dal.dao.impl;

import com.philips.h2h.bama.app.common.util.AppConstants;
import com.philips.h2h.bama.app.identification.dal.dao.PatientDao;
import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;
import com.philips.h2h.bama.platform.core.dal.dao.BaseDaoImpl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * HQL based implementation class of PatientDao.
 */
@Repository("patientDaoHqlImpl")
public class PatientDaoHqlImpl extends BaseDaoImpl <Patient, Long> implements PatientDao {

    /* public methods  ------------------------------------------------------*/

    /**
     * @see PatientDao#findById(Long)
     */
    @Override
    public Patient findById(Long patientOid) {
        // deprecated usage in query with position query, use named query
        // Patient result = uniqueResult((List<Patient>)find("from Patient p where p.oid = ?", patientOid));
        Patient result = uniqueResult((List <Patient>) findByNamedParam("from Patient p where p.oid = :patientOid", "patientOid", patientOid));
        return result;
    }

    /**
     * @see PatientDao#findBySearchCriteria(PatientSearchCriteriaModel)
     */
    @Override
    public List <Patient> findBySearchCriteria(PatientSearchCriteriaModel searchCriteria) {
        List <String> paramNames = new ArrayList <>();
        List <Object> paramValues = new ArrayList <>();

        String hql = buildHqlByCriteria(searchCriteria, paramNames, paramValues);
        List result = findByNamedParam(hql, paramNames.stream().toArray(String[]::new),
                paramValues.toArray(new Object[paramValues.size()]));

        // TODO sample as below thr template
//        String query = "from InvestorMonthlyFees where feeDate = ? and feeState = ?";
//        List<InvestorMonthlyFees> results = getJpaTemplate().find(query, InvestorMonthlyFees.getFeeDateTime(year, month).getMillis(), feeState);

        if (CollectionUtils.isEmpty(result)) {
            result = new ArrayList <>();
        }
        return result;
    }

    /* private methods  -----------------------------------------------------*/

    private String buildHqlByCriteria(PatientSearchCriteriaModel searchCriteria, List <String> paramNames, List <Object> paramValues) {
        String fromHql = "select distinct p from Patient p ";
        String joinHql = " ";
        String whereHql = "where 1=1 ";

        if (StringUtils.isNotBlank(searchCriteria.getName())) {
            whereHql += "and p.name = :name ";

            paramNames.add("name");
            paramValues.add(searchCriteria.getName());
        }
        if (StringUtils.isNotBlank(searchCriteria.getGenderCode())) {
            whereHql += "and p.genderCode = :genderCode ";

            paramNames.add("genderCode");
            paramValues.add(searchCriteria.getGenderCode());
        }
        if (StringUtils.isNotBlank(searchCriteria.getEthnicCode())) {
            whereHql += "and p.ethnicCode = :ethnicCode ";

            paramNames.add("ethnicCode");
            paramValues.add(searchCriteria.getEthnicCode());
        }
        if (StringUtils.isNotBlank(searchCriteria.getIdNo())) {
            whereHql += "and p.idNo = :idNo ";

            paramNames.add("idNo");
            paramValues.add(searchCriteria.getIdNo());
        }
        if (StringUtils.isNotBlank(searchCriteria.getPatientId())) {
            whereHql += "and p.patientId like '%:patientId%' ";

            paramNames.add("patientId");
            paramValues.add(searchCriteria.getPatientId());
        }
        if (StringUtils.isNotBlank(searchCriteria.getInpatientId())) {
            whereHql += "and p.inpatientId = :inpatientId ";

            paramNames.add("inpatientId");
            paramValues.add(searchCriteria.getInpatientId());
        }
        if (StringUtils.isNotBlank(searchCriteria.getOutpatientId())) {
            whereHql += "and p.outpatientId = :outpatientId ";

            paramNames.add("outpatientId");
            paramValues.add(searchCriteria.getOutpatientId());
        }
        if (StringUtils.isNotBlank(searchCriteria.getSecurityId())) {
            whereHql += "and p.securityId = :securityId ";

            paramNames.add("securityId");
            paramValues.add(searchCriteria.getSecurityId());
        }

        whereHql += "and p.active = :active ";
        paramNames.add("active");
        paramValues.add(AppConstants.ENTITY_ACTIVE);

        String hql = fromHql + joinHql + whereHql;
        return hql;
    }
}
