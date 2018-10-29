package com.gcbi.damo.config;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.gcbi.base.web.WebResult;
import com.gcbi.cloud.common.constant.ResultCode;
import com.gcbi.cloud.common.core.exception.BusinessException;
import com.gcbi.cloud.common.core.exception.BusinessExceptionUtils;
import com.gcbi.cloud.common.core.exception.SystemException;
import com.gcbi.cloud.common.core.web.controller.AjaxControllerAnn;
import com.gcbi.cloud.common.core.web.controller.HtmlControllerAnn;
import com.gcbi.cloud.common.model.base.GeneralResult;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class WebExceptionHandler implements HandlerExceptionResolver {

    String errPage;

    public void setErrPage(String errPage) {
        this.errPage = errPage;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            if (hm.getBeanType().getAnnotation(AjaxControllerAnn.class) != null) {
                handleAjaxException(request, response, ex);
            } else if (hm.getBeanType().getAnnotation(HtmlControllerAnn.class) != null) {
                handleHtmlException(request, response, ex);
            }
        }

        return new ModelAndView();
    }


    @SuppressWarnings("rawtypes")
    private ModelAndView handleAjaxException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        GeneralResult <?> generalResult = new GeneralResult();
        if (ex instanceof BusinessException) {
            BusinessException be = (BusinessException) ex;
            log.error("Handle request[" + request.getRequestURI() + "] error[BusinessException]!", be);
            generalResult.setResultCode(be.getBusinessCode());
            generalResult.setDetailDescription(BusinessExceptionUtils.getBusinessInfo(be));
        } else if (ex instanceof com.gcbi.commons.core.exception.BusinessException) {
            com.gcbi.commons.core.exception.BusinessException be = (com.gcbi.commons.core.exception.BusinessException) ex;
            log.error("Handle request[" + request.getRequestURI() + "] error[BusinessException]!", be);
            generalResult.setResultCode(be.getBusinessCode());
            generalResult.setDetailDescription(com.gcbi.commons.core.utils.BusinessExceptionUtils.getBusinessInfo(be));

        } else if (ex instanceof SystemException) {
            SystemException se = (SystemException) ex;
            generalResult.setResultCode(ResultCode.ERR_SERVER);
            generalResult.setDetailDescription(se.getMessage());
            log.error("Handle request[" + request.getRequestURI() + "] error[SystemException]!", se);
        } else {
            generalResult.setResultCode(ResultCode.ERR_SERVER);
            generalResult.setDetailDescription(ex.getMessage());
            log.error("Handle request[" + request.getRequestURI() + "] error!", ex);
        }
        try {
            String json = JSON.toJSONString(generalResult);
            OutputStream os = response.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.flush();
        } catch (Exception e) {
            log.error("Output error webResult error!", e);
        }

        return new ModelAndView();
    }


    private ModelAndView handleHtmlException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        String errCode, errMsg;
        if (ex instanceof BusinessException) {
            BusinessException be = (BusinessException) ex;
            log.error("Handle request[" + request.getRequestURI() + "] error[BusinessException]!", be);
            errCode = be.getBusinessCode();
            errMsg = BusinessExceptionUtils.getBusinessInfo(be);
        } else if (ex instanceof SystemException) {
            SystemException se = (SystemException) ex;
            errCode = ResultCode.ERR_SERVER;
            errMsg = se.getMessage();
            log.error("Handle request[" + request.getRequestURI() + "] error[SystemException]!", se);
        } else {
            errCode = ResultCode.ERR_SERVER;
            errMsg = ex.getMessage();
            log.error("Handle request[" + request.getRequestURI() + "] error!", ex);
        }

        ModelAndView mav = new ModelAndView(errPage);
        mav.addObject("errCode", errCode);
        mav.addObject("errMsg", errMsg);

        return mav;
    }
}
