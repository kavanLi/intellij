package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class NotFoundArcherException extends BusinessException {
    public NotFoundArcherException(String message) {
        super(message);
    }

    public NotFoundArcherException(String message, Throwable cause) {
        super(message, cause);
    }
}
