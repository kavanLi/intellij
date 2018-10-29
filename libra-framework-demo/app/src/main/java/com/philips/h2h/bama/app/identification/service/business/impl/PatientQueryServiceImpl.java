/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.service.business.impl;

import com.philips.h2h.bama.app.identification.domain.entity.Patient;
import com.philips.h2h.bama.app.identification.domain.model.PatientCompactModel;
import com.philips.h2h.bama.app.identification.domain.model.PatientSearchCriteriaModel;
import com.philips.h2h.bama.app.identification.dal.repository.PatientRepository;
import com.philips.h2h.bama.app.identification.service.business.PatientQueryService;

import org.apache.commons.collections4.CollectionUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation Class of PatientQueryService.
 */
@Service
public class PatientQueryServiceImpl implements PatientQueryService {

    /* fields          ------------------------------------------------------*/

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private Mapper beanMapper;

    /* public methods  ------------------------------------------------------*/

    /**
     * @see PatientQueryService#findByEthnic(String, Pageable)
     */
    @Override
    public Page <PatientCompactModel> findByEthnic(@NotNull String ethnicCode, @NotNull Pageable pageable) {
        Page <Patient> patientPage = patientRepository.findByEthnicCodeAndActiveOrderByGenderCodeDesc(ethnicCode, Boolean.TRUE, pageable);
        return convertToModelPage(patientPage, pageable);
    }

    /**
     * @see PatientQueryService#findAllPageable(Pageable)
     */
    @Override
    public Page <Patient> findAllPageable(@NotNull Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    /**
     * @see PatientQueryService#findAllModelPageable(Pageable)
     */
    @Override
    public Page <PatientCompactModel> findAllModelPageable(@NotNull Pageable pageable) {
        return convertToModelPage(findAllPageable(pageable), pageable);
    }

    /**
     * @see PatientQueryService#findAllBySearchCriteria(PatientSearchCriteriaModel)
     */
    @Override
    public List <Patient> findAllBySearchCriteria(@NotNull PatientSearchCriteriaModel searchCriteria) {
        return patientRepository.findBySearchCriteria(searchCriteria);
    }

    /**
     * @see PatientQueryService#findModelBySearchCriteriaPageable(PatientSearchCriteriaModel, Pageable)
     */
    @Override
    public Page <PatientCompactModel> findModelBySearchCriteriaPageable(@NotNull PatientSearchCriteriaModel searchCriteria, @NotNull Pageable pageable) {
        return convertToModelPage(findBySearchCriteriaPageable(searchCriteria, pageable), pageable);
    }

    /**
     * @see PatientQueryService#findBySearchCriteriaPageable(PatientSearchCriteriaModel, Pageable)
     */
    @Override
    public Page <Patient> findBySearchCriteriaPageable(@NotNull PatientSearchCriteriaModel searchCriteria, @NotNull Pageable pageable) {
        return patientRepository.findBySearchCriteriaPageable(searchCriteria, pageable);
    }

    /* private methods  -----------------------------------------------------*/

    private Page <PatientCompactModel> convertToModelPage(Page <Patient> patientPage, Pageable pageable) {
        List <Patient> patientList = patientPage.getContent();

        List <PatientCompactModel> modelList = new ArrayList <>();
        if (CollectionUtils.isNotEmpty(patientList)) {
            modelList = patientList.stream()
                    .map(e -> beanMapper.map(e, PatientCompactModel.class))
                    .collect(Collectors.toList());
        }

        long total = patientPage.getTotalElements();
        return new PageImpl <>(modelList, pageable, total);
    }
}
