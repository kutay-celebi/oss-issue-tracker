package com.kuartz.auth.repository;

import com.kuartz.auth.entity.ClientEntity;
import com.kuartz.core.data.jpa.repository.KuartzRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KuartzClientDetailsRepository extends KuartzRepository<ClientEntity> {
}
