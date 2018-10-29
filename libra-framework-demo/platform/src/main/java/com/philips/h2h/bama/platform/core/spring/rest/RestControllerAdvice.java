/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.spring.rest;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.philips.h2h.bama.platform.core.spring.rest.model.RestResponseEnvelope;

/**
 * Controller advice implementation for rest response.
 */
@ControllerAdvice
public class RestControllerAdvice implements ResponseBodyAdvice <Object> {

    /* public methods ------------------------------------------------------ */

    @Override
    public boolean supports(MethodParameter returnType, Class <? extends HttpMessageConverter <?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class <? extends HttpMessageConverter <?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        return body instanceof RestResponseEnvelope ? body : new RestResponseEnvelope(body);
    }
}
