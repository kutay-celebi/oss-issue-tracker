package com.kuartz.auth.service;

import com.kuartz.core.auth.dto.ClientModel;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;

public interface KuartzClientDetailsService {
    ClientModel getByClientId(String clientId) throws ClientRegistrationException;

    void save(ClientModel clientDetails) throws ClientAlreadyExistsException;

    void update(ClientModel clientDetails) throws NoSuchClientException;

    void updateClientSecret(String clientId, String secret) throws NoSuchClientException;

    void removeByClientId(String clientId) throws NoSuchClientException;
}
