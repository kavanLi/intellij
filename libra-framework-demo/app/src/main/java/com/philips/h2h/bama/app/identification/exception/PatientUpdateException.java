/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Exceptions occur when target patient in update process.
 */
public class PatientUpdateException extends BusinessException {

    /* constructors    ------------------------------------------------------*/

    public PatientUpdateException(String message) {
        super(message);
    }

    public PatientUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
