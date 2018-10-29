/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.security.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Exception will be thrown when doing login for account.
 */
public class LoginFailedException extends BusinessException {

    /* constructors ------------------------------------------------------ */

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
