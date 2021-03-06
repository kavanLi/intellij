/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.exception;

/**
 * Default system runtime exception.
 */
public class SystemException extends BaseRuntimeException {

    /* constructors ------------------------------------------------------ */
    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
