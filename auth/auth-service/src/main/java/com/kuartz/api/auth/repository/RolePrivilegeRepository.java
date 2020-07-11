package com.kuartz.api.auth.repository;

import com.kuartz.api.auth.entity.RolePrivilegeEntity;
import com.kuartz.core.data.jpa.repository.KuartzRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePrivilegeRepository extends KuartzRepository<RolePrivilegeEntity> {
}
