package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class NotFoundPilotException extends BusinessException {
    public NotFoundPilotException(String message) {
        super(message);
    }

    public NotFoundPilotException(String message, Throwable cause) {
        super(message, cause);
    }
}
