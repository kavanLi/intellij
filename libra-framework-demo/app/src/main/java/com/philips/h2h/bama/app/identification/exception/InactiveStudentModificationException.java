package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.SystemException;

/**
 * Created by Ritchie on 9/23/2017.
 */
public class InactiveStudentModificationException extends SystemException {
    public InactiveStudentModificationException(String message) {
        super(message);
    }

    public InactiveStudentModificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
