package com.kuartz.auth.handler;

import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.common.exception.ExceptionMessage;
import com.kuartz.core.env.KuartzMessageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component
public class KuartzAuthenticationEntryPoint implements AuthenticationEntryPoint {

    public static final Logger LOG = LoggerFactory.getLogger(KuartzAuthenticationEntryPoint.class);

    @Autowired
    private KuartzMessageSource messageSource;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws
            IOException {
        LOG.error(e.getLocalizedMessage(), e);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        Locale locale = httpServletRequest.getLocale();
        String message = messageSource.getMessage("ex_duringAuth", null, locale);
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.getWriter().write(KuartzModelConverter.getMapper().writeValueAsString(new ExceptionMessage(message)));

    }
}
