/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.exception;

import org.springframework.core.NestedCheckedException;

/**
 * Base checked exception used internally in current application.
 */
public abstract class BaseCheckedException extends NestedCheckedException {

    /* constructors ------------------------------------------------------ */

    public BaseCheckedException(String message) {
        super(message);
    }

    public BaseCheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
