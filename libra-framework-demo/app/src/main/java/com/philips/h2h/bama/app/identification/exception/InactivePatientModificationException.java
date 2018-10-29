/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.SystemException;

/**
 * Exceptions occur when try to modify inactive patient.
 */
public class InactivePatientModificationException extends SystemException {

    /* constructors    ------------------------------------------------------*/

    public InactivePatientModificationException(String message) {
        super(message);
    }

    public InactivePatientModificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
