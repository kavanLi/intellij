/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.spring.rest.error;

import org.springframework.web.context.request.ServletWebRequest;

import com.philips.h2h.bama.platform.core.spring.rest.model.RestError;

/**
 * A {@code RestErrorResolver} resolves an exception and produces a
 * {@link RestError} instance that can be used to render a Rest error
 * representation to the response body.
 */
public interface RestErrorResolver {
    /**
     * Returns a {@code RestError} instance to render as the response body based
     * on the given exception.
     *
     * @param request   current {@link ServletWebRequest} that can be used to obtain
     *                  the source request/response pair.
     * @param handler   the executed handler, or <code>null</code> if none chosen at
     *                  the time of the exception (for example, if multipart
     *                  resolution failed)
     * @param exception the exception that was thrown during handler execution
     * @return a resolved {@code RestError} instance to render as the response
     * body or <code>null</code> for default processing
     */
    RestError resolveError(ServletWebRequest request, Object handler, Exception exception);
}
