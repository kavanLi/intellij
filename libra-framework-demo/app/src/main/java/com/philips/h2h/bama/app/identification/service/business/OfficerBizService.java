package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Officer;
import com.philips.h2h.bama.app.identification.domain.model.OfficerModel;

/**
 * Created by Ritchie on 9/22/2017.
 */
//product business service
@Validated
public interface OfficerBizService {

    /**
     * Save passby entity to store
     *
     * @param model target model to be saved
     * @return saved entity
     */
    OfficerModel createOfficer(@NotNull Officer model);

    /**
     * Update passby entity model to product entity
     *
     * @param model target model to be saved
     * @return saved model
     */
    OfficerModel updateOfficer(@NotNull Officer model);

    /**
     * Load entity according to oid
     *
     * @param officerOid the oid to find target entity
     * @return existed target entity otherwise null
     */
    OfficerModel findOfficer(@NotNull Long officerOid);
}
