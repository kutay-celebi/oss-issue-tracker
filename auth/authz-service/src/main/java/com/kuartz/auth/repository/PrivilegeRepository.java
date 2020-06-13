package com.kuartz.auth.repository;

import com.kuartz.auth.entity.PrivilegeEntity;
import com.kuartz.core.data.jpa.repository.KuartzRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends KuartzRepository<PrivilegeEntity> {
}
