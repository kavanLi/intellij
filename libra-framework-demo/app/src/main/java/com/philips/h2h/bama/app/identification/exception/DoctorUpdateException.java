package com.philips.h2h.bama.app.identification.exception;

import com.philips.h2h.bama.platform.core.exception.BusinessException;

/**
 * Created by Ritchie on 9/21/2017.
 */
public class DoctorUpdateException extends BusinessException {
    public DoctorUpdateException(String message) {
        super(message);
    }

    public DoctorUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
