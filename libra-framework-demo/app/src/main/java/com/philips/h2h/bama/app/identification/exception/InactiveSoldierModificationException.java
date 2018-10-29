package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.SystemException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class InactiveSoldierModificationException extends SystemException {
    public InactiveSoldierModificationException(String message) {
        super(message);
    }

    public InactiveSoldierModificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
