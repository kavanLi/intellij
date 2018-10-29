/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.orm.hibernate;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.philips.h2h.bama.platform.core.domain.entity.BaseEntity;
import com.philips.h2h.bama.platform.core.domain.entity.BusinessEntity;
import com.philips.h2h.bama.platform.core.domain.model.common.BaseModel;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * BasicOneToManyValuesSetService. Basic logic flow to save many side in
 * one-to-many relationship.
 */
public abstract class BasicOneToManyValuesSetService implements OneToManyValuesSetService {

    /* public methods ------------------------------------------------------ */

    /**
     * @see OneToManyValuesSetService#updateValuesToManySide(Set, List,
     * BusinessEntity)
     */
    @Override
    public void updateValuesToManySide(@NotNull Set <? extends BusinessEntity> entitySet,
                                       @NotNull List <? extends BaseModel> modelList, @NotNull BusinessEntity oneSideEntity) {
        if (CollectionUtils.isEmpty(modelList)) {
            // model return null collection means no modification on collection
            // elements.
            return;
        }

        // case: client set value array to update
        if (CollectionUtils.isNotEmpty(entitySet)) {
            // update case

            // found the object that not exist in model list anymore
            List <BusinessEntity> toBeRemovedList = new ArrayList <>();
            entitySet.forEach(e -> {
                BusinessEntity found = null;
                for (BaseModel item : modelList) {
                    if (item.getOid() != null) {
                        if (NumberUtils.compare(e.getOid(), item.getOid()) == 0) {
                            // found the item in entity list
                            found = e;
                            break;
                        }
                    }
                }

                // if not found an entity, add it to be removed
                if (found == null) {
                    toBeRemovedList.add(e);
                }
            });

            // remove items in entity first
            if (CollectionUtils.isNotEmpty(toBeRemovedList)) {
                entitySet.removeAll(toBeRemovedList);
            }

            // then update and add new one
            modelList.forEach(e -> {
                if (e.getOid() == null) {
                    // case: new added attribute value

                    // update values from model to entity
                    addNewEntityToExistingMany(entitySet, e, oneSideEntity);
                } else {
                    // case: update

                    // update values from model to entity
                    for (BusinessEntity entity : entitySet) {
                        if (NumberUtils.compare(entity.getOid(), e.getOid()) != 0)
                            continue;
                        if (updateExistingEntity(entity, e) != null)
                            break;
                    }
                }
            });
        } else {
            // new product and all model values to be added to entity
            createManySideEntities(modelList, oneSideEntity);
        }
    }

    /* protected methods --------------------------------------------------- */

    /**
     * Create many side entities and copy model to it. Different subclass should
     * overwrite this method and provide its own biz process.
     *
     * @param modelList     the model list to add to many side
     * @param oneSideEntity the one side entity to set to many-side entity
     * @return values all set many side entity
     */
    protected abstract BusinessEntity createManySideEntities(List <? extends BaseModel> modelList,
                                                             BusinessEntity oneSideEntity);

    /**
     * Add new one to many side case. Different subclass should overwrite this
     * method and provide its own biz process.
     *
     * @param model         the model to add to many side
     * @param oneSideEntity the one side entity to set to many-side entity
     * @return values all set many side entity
     */
    protected abstract BusinessEntity addNewEntity(BaseModel model, BusinessEntity oneSideEntity);

    /**
     * Update existing one in many side case. Different subclass should
     * overwrite this method and provide its own biz process.
     *
     * @param entity the many side entity existing to be saved
     * @param model  the model with values to be set to entity
     * @return values updated set for entity
     */
    protected abstract BaseEntity updateExistingEntity(BusinessEntity entity, BaseModel model);

    /* private methods ------------------------------------------------------ */

    private void addNewEntityToExistingMany(Set entitySet, BaseModel model, BusinessEntity oneSideEntity) {
        BusinessEntity entity = addNewEntity(model, oneSideEntity);
        if (entity != null) {
            entitySet.add(entity);

            // Set<BusinessEntity> newEntitySet = new HashSet<>();
            // newEntitySet.addAll(entitySet);
            // newEntitySet.add(entity);
        }
    }
}
