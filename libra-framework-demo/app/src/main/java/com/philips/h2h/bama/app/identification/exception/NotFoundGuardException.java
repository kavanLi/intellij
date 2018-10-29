package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class NotFoundGuardException extends BusinessException {
    public NotFoundGuardException(String message) {
        super(message);
    }

    public NotFoundGuardException(String message, Throwable cause) {
        super(message, cause);
    }
}
