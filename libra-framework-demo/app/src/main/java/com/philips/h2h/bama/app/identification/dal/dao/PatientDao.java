/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.dal.dao;

import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;

import java.util.List;

/**
 * DAO interface for Patient.
 */
public interface PatientDao {
    /**
     * Find patient by its oid.
     *
     * @param patientOid the patient oid to searched
     * @return the found patient
     */
    Patient findById(Long patientOid);

    /**
     * Find patients matching search criteria.
     *
     * @param searchCriteria the search criteria to do search
     * @return patients matched the criteria
     */
    List <Patient> findBySearchCriteria(PatientSearchCriteriaModel searchCriteria);
}
