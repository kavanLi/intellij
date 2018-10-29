/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.orm.hibernate;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.platform.core.domain.entity.BusinessEntity;
import com.philips.h2h.bama.platform.core.domain.model.common.BaseModel;

import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

/**
 * OneToManyValuesSetService interface to commonly processing many side
 * create/update logics.
 */
@Validated
public interface OneToManyValuesSetService {

    /**
     * Save (create/update) many side in one-to-many relationship.
     *
     * @param entitySet     many side entity set
     * @param modelList     many side model list to be saved
     * @param oneSideEntity one side entity
     */
    void updateValuesToManySide(@NotNull Set <? extends BusinessEntity> entitySet,
                                @NotNull List <? extends BaseModel> modelList, @NotNull BusinessEntity oneSideEntity);
}
