/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.security.enumeration;

/**
 * To classify roles to categories when there are hundreds of roles. User can be
 * assigned the role tagged with USER only and Organization can be assigned the
 * ORGANIZATION roles only.
 */
public enum RoleCategory {
    USER, // tag for roles used for subject only
    ORGANIZATION, // tag for role used for organization only
    GROUP, // not used yet
}
