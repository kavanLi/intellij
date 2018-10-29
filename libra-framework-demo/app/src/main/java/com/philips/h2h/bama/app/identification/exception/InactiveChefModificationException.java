package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.SystemException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class InactiveChefModificationException extends SystemException {
    public InactiveChefModificationException(String message) {
        super(message);
    }

    public InactiveChefModificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
