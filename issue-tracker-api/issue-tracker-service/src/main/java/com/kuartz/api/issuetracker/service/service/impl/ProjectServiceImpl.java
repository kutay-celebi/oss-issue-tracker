package com.kuartz.api.issuetracker.service.service.impl;

import com.kuartz.api.issuetracker.common.dto.ProjectModel;
import com.kuartz.api.issuetracker.service.entity.ProjectEntity;
import com.kuartz.api.issuetracker.service.repository.ProjectRepository;
import com.kuartz.api.issuetracker.service.service.ProjectService;
import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.common.model.KzMessageModel;
import com.kuartz.core.data.jpa.TransactionalRollback;
import com.kuartz.core.service.AbstractKuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kutay Çelebi
 * @since 27.06.2020
 */
@Service
@TransactionalRollback
@Transactional
public class ProjectServiceImpl extends AbstractKuartzService implements ProjectService {

    @Autowired
    private ProjectRepository repository;


    @Override
    public ProjectModel save(ProjectModel model) {
        repository.saveFlush(KuartzModelConverter.convert(model, ProjectEntity.class));
        return null;
    }

    @Override
    public KzMessageModel deleteById(Long id) {
        return null;
    }

    @Override
    public ProjectModel get(Long id) {
        return null;
    }
}
