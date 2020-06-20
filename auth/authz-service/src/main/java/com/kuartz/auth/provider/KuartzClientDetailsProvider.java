package com.kuartz.auth.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kuartz.auth.service.KuartzClientDetailsService;
import com.kuartz.core.auth.dto.ClientModel;
import com.kuartz.core.auth.dto.ResourceModel;
import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.common.util.KzUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class KuartzClientDetailsProvider implements ClientDetailsService {

    @Autowired
    private KuartzClientDetailsService detailsService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientModel client = detailsService.getByClientId(clientId);


        String resourceIds = client.getReourceList().stream().map(ResourceModel::getResourceName).collect(Collectors.joining(","));
        String scopes = String.join(",", client.getScope());
        String grantTypes = String.join(",", client.getAuthorizedGrantTypes());
        String authorities = String.join(",", client.getAuthorities());
        String redirectUris = String.join(",", client.getRegisteredRedirectUri());


        BaseClientDetails base = new BaseClientDetails(client.getClientId(), resourceIds, scopes, grantTypes, authorities, redirectUris);
        base.setClientSecret(client.getClientSecret());
        base.setAccessTokenValiditySeconds(client.getAccessTokenValiditySeconds());
        base.setRefreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds());
        Map<String, ?> additionalInformation = KuartzModelConverter.convert(client.getAdditionalInformation(),
                                                                            new TypeReference<Map<String, ?>>() {
                                                                            });
        if (!KzUtil.isEmpty(additionalInformation)) {
            base.setAdditionalInformation(additionalInformation);
        }
        base.setScope(StringUtils.commaDelimitedListToSet(client.getScope()));

        return base; // FIXME: @kutay-celebi 07.03.2020 entered 3-4 times. explore why?
    }
}
