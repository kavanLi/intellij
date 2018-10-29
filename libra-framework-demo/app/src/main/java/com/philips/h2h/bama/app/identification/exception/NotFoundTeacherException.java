package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class NotFoundTeacherException extends BusinessException {
    public NotFoundTeacherException(String message) {
        super(message);
    }

    public NotFoundTeacherException(String message, Throwable cause) {
        super(message, cause);
    }
}
