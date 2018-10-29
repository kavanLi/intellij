package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class NotFoundDriverException extends BusinessException {
    public NotFoundDriverException(String message) {
        super(message);
    }

    public NotFoundDriverException(String message, Throwable cause) {
        super(message, cause);
    }
}
