package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class NotFoundPlumberException extends BusinessException {
    public NotFoundPlumberException(String message) {
        super(message);
    }

    public NotFoundPlumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
