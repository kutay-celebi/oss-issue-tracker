package com.kuartz.api.auth.service;

import com.kuartz.api.auth.dto.ClientModel;
import com.kuartz.api.auth.entity.ClientEntity;
import com.kuartz.api.auth.entity.query.ClientEntityQuery;
import com.kuartz.api.auth.repository.KuartzClientDetailsRepository;
import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.data.jpa.TransactionalRollback;
import com.kuartz.core.service.KuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@TransactionalRollback
public class KuartzClientDetailsServiceImpl extends KuartzService implements KuartzClientDetailsService {


    @Autowired
    private KuartzClientDetailsRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public ClientModel getByClientId(String clientId) throws ClientRegistrationException {
        Optional<ClientEntity> clientOptional = repository.findOne(ClientEntityQuery.clientEntity.clientId.eq(clientId));
        ClientEntity client = null;
        if (clientOptional.isPresent()) {
            client = clientOptional.get();
        } else {
            // TODO: @kutay-celebi 07.03.2020 throw exception 
        }

        return KuartzModelConverter.convert(client, ClientModel.class);
    }

    @Override
    public void save(ClientModel clientDetails) throws ClientAlreadyExistsException {
        ClientEntity details = KuartzModelConverter.convert(clientDetails, ClientEntity.class);
        details.setClientSecret(passwordEncoder.encode(clientDetails.getClientSecret()));
        repository.saveFlush(details);
    }

    @Override
    public void update(ClientModel clientDetails) throws NoSuchClientException {
        repository.updateFlush(KuartzModelConverter.convert(clientDetails, ClientEntity.class));
    }

    @Override
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
        Optional<ClientEntity> one = repository.findOne(ClientEntityQuery.clientEntity.clientId.eq(clientId));
        if (one.isPresent()) {
            ClientEntity client = one.get();
            client.setClientSecret(secret);
        } else {
            // TODO: @kutay-celebi 07.03.2020 throw exception 
        }
    }

    @Override
    public void removeByClientId(String clientId) throws NoSuchClientException {
        Optional<ClientEntity> one = repository.findOne(ClientEntityQuery.clientEntity.clientId.eq(clientId));
        if (one.isPresent()) {
            repository.deleteById(one.get().getId());
        } else {
            // TODO: @kutay-celebi 07.03.2020  
        }
    }

}
