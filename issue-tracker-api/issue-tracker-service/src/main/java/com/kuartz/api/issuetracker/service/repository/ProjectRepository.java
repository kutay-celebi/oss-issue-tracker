package com.kuartz.api.issuetracker.service.repository;

import com.kuartz.api.issuetracker.service.entity.ProjectEntity;
import com.kuartz.core.data.jpa.repository.KuartzRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kutay Çelebi
 * @since 27.06.2020
 */
@Repository
public interface ProjectRepository extends KuartzRepository<ProjectEntity> {
}
