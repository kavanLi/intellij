package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.SystemException;

/**
 * Created by Ritchie on 9/21/2017.
 */
public class InactiveDoctorModificationException extends SystemException {
    public InactiveDoctorModificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InactiveDoctorModificationException(String message) {
        super(message);
    }
}
