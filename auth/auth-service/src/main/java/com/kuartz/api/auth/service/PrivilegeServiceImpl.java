package com.kuartz.api.auth.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kuartz.api.auth.builder.PrivilegeQueryBuilder;
import com.kuartz.api.auth.dto.PrivilegeModel;
import com.kuartz.api.auth.dto.query.PrivilegeQueryModel;
import com.kuartz.api.auth.entity.PrivilegeEntity;
import com.kuartz.api.auth.entity.query.PrivilegeEntityQuery;
import com.kuartz.api.auth.repository.PrivilegeRepository;
import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.data.jpa.TransactionalRollback;
import com.kuartz.core.service.AbstractKuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@TransactionalRollback
public class PrivilegeServiceImpl extends AbstractKuartzService implements PrivilegeService {

    @Autowired
    private PrivilegeRepository repository;

    @Autowired
    private PrivilegeQueryBuilder queryBuilder;


    @Override
    @Transactional(readOnly = true)
    public KzPage<PrivilegeModel> getPage(PrivilegeQueryModel queryModel) {
        KzPage<PrivilegeEntity> page = repository.findAll(queryBuilder.buildQuery(queryModel, PrivilegeEntityQuery.privilegeEntity),
                                                          queryModel.getPageable());
        return KuartzModelConverter.convert(page, new TypeReference<KzPage<PrivilegeModel>>() {
        });
    }

    @Override
    public PrivilegeModel save(PrivilegeModel model) {
        PrivilegeEntity entity = repository.saveFlush(KuartzModelConverter.convert(model, PrivilegeEntity.class));
        return KuartzModelConverter.convert(entity, PrivilegeModel.class);
    }

    @Override
    public PrivilegeModel update(PrivilegeModel model) {
        PrivilegeEntity entity = repository.updateFlush(KuartzModelConverter.convert(model, PrivilegeEntity.class));
        return KuartzModelConverter.convert(entity, PrivilegeModel.class);
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return Boolean.TRUE;
    }

    @Transactional(readOnly = true)
    @Override
    public PrivilegeModel get(Long id) {
        return KuartzModelConverter.convert(repository.findById(id).get(), PrivilegeModel.class);
    }
}
