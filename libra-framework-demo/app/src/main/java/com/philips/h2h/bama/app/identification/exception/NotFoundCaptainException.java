package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Created by Ritchie on 9/24/2017.
 */
public class NotFoundCaptainException extends BusinessException {
    public NotFoundCaptainException(String message) {
        super(message);
    }

    public NotFoundCaptainException(String message, Throwable cause) {
        super(message, cause);
    }
}
