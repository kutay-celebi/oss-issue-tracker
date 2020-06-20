package com.kuartz.auth.repository;

import com.kuartz.auth.entity.ContactEntity;
import com.kuartz.core.data.jpa.repository.KuartzRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends KuartzRepository<ContactEntity> {
}
