/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.common.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * All constants used in this app defined here.
 */
public final class AppConstants {

    // Unique query result
    public static final int QUERY_UNIQUE_RESULT = 1;

    // software delete flag. Entity is active or inactive.
    public static final Boolean ENTITY_ACTIVE = Boolean.TRUE;
    public static final Boolean ENTITY_INACTIVE = Boolean.FALSE;

    // Switcher on/off setting
    public static final Boolean SWITCHER_ON = Boolean.TRUE;
    public static final Boolean SWITCHER_OFF = Boolean.FALSE;

    // Chars
    public static final String EMPTY_STRING = StringUtils.EMPTY;
    public static final String DOT = ".";
    public static final String COMMA = ",";
    public static final String SLASH = "/";
    public static final String BACK_SLASH = "\\";
    public static final String UNDERSCORE = "_";
    public static final String INTEGER_ZERO = "0";
}
