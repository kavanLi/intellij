/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.dal.repository;

import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.platform.core.dal.repository.BaseRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

/**
 * Patient repository.
 */
public interface PatientRepository extends BaseRepository <Patient, Long>, PatientRepositoryExtend {
    Patient findByName(String name);

    List <Patient> findByGenderCode(String genderCode);

    Page <Patient> findByEthnicCodeAndActiveOrderByGenderCodeDesc(String ethnicCode, Boolean active, Pageable pageable);

    @EntityGraph(value = "Patient.lazyAttributes", type = EntityGraph.EntityGraphType.LOAD)
    Patient queryPatientByOid(Long patientOid);
}
