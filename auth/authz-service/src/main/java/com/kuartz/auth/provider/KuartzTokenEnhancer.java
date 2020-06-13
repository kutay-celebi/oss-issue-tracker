package com.kuartz.auth.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kuartz.auth.entity.UserEntity;
import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.common.security.PrincipalAuthority;
import com.kuartz.core.common.security.PrincipalRole;
import com.kuartz.core.common.security.UserPrincipal;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class KuartzTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken defaultToken = new DefaultOAuth2AccessToken(accessToken);
        if (authentication.isAuthenticated()) {
            //UserPrincipal user = KuartzModelConverter.convert(authentication.getPrincipal(), UserPrincipal.class);
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

            defaultToken.getAdditionalInformation().put("principal", principalModel);
        }
        return defaultToken;
    }


}
