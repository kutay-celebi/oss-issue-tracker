package com.kuartz.auth.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kuartz.auth.entity.UserEntity;
import com.kuartz.auth.service.UserService;
import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.common.security.PrincipalAuthority;
import com.kuartz.core.common.security.PrincipalRole;
import com.kuartz.core.common.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class KuartzJwtAccessTokenConverter extends JwtAccessTokenConverter {

    public KuartzJwtAccessTokenConverter() {
        this.setSigningKey("test");
        this.setVerifierKey("test");
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) super.enhance(accessToken, authentication);
        if (authentication.isAuthenticated() && !authentication.getOAuth2Request().isRefresh()) {
            UserEntity user = (UserEntity) authentication.getPrincipal();
            List<PrincipalRole> roles = user.getRoleList().stream().map(r -> new PrincipalRole(r.getRole().getCode())).collect(
                    Collectors.toList());
            Set<PrincipalAuthority> privileges = KuartzModelConverter.convert(user.getAuthorities(),
                                                                              new TypeReference<Set<PrincipalAuthority>>() {
                                                                              });

            UserPrincipal principalModel = new UserPrincipal();
            principalModel.setUsername(user.getUsername());
            principalModel.setEmail(user.getEmail());
            principalModel.setAuthority(privileges);
            principalModel.setRoles(roles);

            token.getAdditionalInformation().put("principal", principalModel);
        }
        return token;
    }
}
