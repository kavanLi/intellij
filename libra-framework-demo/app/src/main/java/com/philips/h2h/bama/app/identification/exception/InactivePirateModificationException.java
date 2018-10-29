package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.SystemException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class InactivePirateModificationException extends SystemException {
    public InactivePirateModificationException(String message) {
        super(message);
    }

    public InactivePirateModificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
