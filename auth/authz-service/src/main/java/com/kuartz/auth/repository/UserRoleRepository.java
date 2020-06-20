package com.kuartz.auth.repository;

import com.kuartz.auth.entity.UserRoleEntity;
import com.kuartz.core.data.jpa.repository.KuartzRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends KuartzRepository<UserRoleEntity> {
}
