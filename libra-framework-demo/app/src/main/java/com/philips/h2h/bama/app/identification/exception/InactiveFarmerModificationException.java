package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.SystemException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class InactiveFarmerModificationException extends SystemException {
    public InactiveFarmerModificationException(String message) {
        super(message);
    }

    public InactiveFarmerModificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
