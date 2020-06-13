package com.kuartz.auth.repository;

import com.kuartz.auth.entity.PersonEntity;
import com.kuartz.core.data.jpa.repository.KuartzRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends KuartzRepository<PersonEntity> {
}
