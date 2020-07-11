package com.kuartz.api.auth.provider;

import com.kuartz.core.common.util.KzUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

// todo altyapiya alalim.
public class KuartzTokenExtractor implements TokenExtractor {


    @Override
    public Authentication extract(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token = null;
        String header = null;
        if (cookies != null) {
            token = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("access_token"))
                          .findFirst().map(Cookie::getValue).orElse(null);
        } else {
            header = request.getHeader(HttpHeaders.AUTHORIZATION);
        }

        if (!KzUtil.isEmpty(token)) {
            return new PreAuthenticatedAuthenticationToken(token, "");
        } else if (!KzUtil.isEmpty(header)) {
            return new PreAuthenticatedAuthenticationToken(header, "");
        }
        return new PreAuthenticatedAuthenticationToken("access-token", "");
    }
}
