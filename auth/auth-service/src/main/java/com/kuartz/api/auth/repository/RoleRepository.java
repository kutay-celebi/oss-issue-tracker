package com.kuartz.api.auth.repository;

import com.kuartz.api.auth.entity.RoleEntity;
import com.kuartz.core.data.jpa.repository.KuartzRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends KuartzRepository<RoleEntity> {
}
