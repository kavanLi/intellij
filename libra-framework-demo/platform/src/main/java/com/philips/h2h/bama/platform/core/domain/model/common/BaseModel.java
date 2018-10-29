/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.domain.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Base model for all biz model class. It has a only oid field by default
 * mapping to its associated entity oid. If it's mapping on the fly then oid
 * field is redundant.
 * <p>
 * About model style guide, please refer:
 * https://google.github.io/styleguide/jsoncstyleguide.xml#Flattened_data_vs_Structured_Hierarchy
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseModel implements Serializable {

    /* fields ------------------------------------------------------ */

    protected Long oid; // mapping to associated entity oid

    /* getters/setters ------------------------------------------------------ */

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }
}
