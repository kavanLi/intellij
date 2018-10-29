package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class NotFoundOfficerException extends BusinessException {
    public NotFoundOfficerException(String message) {
        super(message);
    }

    public NotFoundOfficerException(String message, Throwable cause) {
        super(message, cause);
    }
}
