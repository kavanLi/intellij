package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.SystemException;

/**
 * Created by Ritchie on 9/24/2017.
 */
public class InactiveCaptainModificationException extends SystemException {
    public InactiveCaptainModificationException(String message) {
        super(message);
    }

    public InactiveCaptainModificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
