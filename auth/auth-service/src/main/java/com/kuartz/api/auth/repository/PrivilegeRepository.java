package com.kuartz.api.auth.repository;

import com.kuartz.api.auth.entity.PrivilegeEntity;
import com.kuartz.core.data.jpa.repository.KuartzRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends KuartzRepository<PrivilegeEntity> {
}
