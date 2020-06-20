package com.kuartz.auth.repository;

import com.kuartz.auth.entity.ResourceEntity;
import com.kuartz.core.data.jpa.repository.KuartzRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends KuartzRepository<ResourceEntity> {
}
