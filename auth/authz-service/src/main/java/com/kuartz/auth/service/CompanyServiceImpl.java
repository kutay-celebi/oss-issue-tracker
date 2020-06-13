package com.kuartz.auth.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kuartz.auth.builder.CompanyQueryBuilder;
import com.kuartz.auth.entity.CompanyEntity;
import com.kuartz.auth.entity.query.CompanyEntityQuery;
import com.kuartz.auth.repository.CompanyRepository;
import com.kuartz.core.auth.dto.CompanyModel;
import com.kuartz.core.auth.dto.query.CompanyQueryModel;
import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.data.jpa.TransactionalRollback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@TransactionalRollback
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private CompanyQueryBuilder queryBuilder;

    @Override
    public CompanyModel saveUpdate(CompanyModel company) {
        CompanyEntity entity = repository.saveFlush(KuartzModelConverter.convert(company, CompanyEntity.class));
        return KuartzModelConverter.convert(entity, CompanyModel.class);
    }

    @Transactional(readOnly = true)
    @Override
    public KzPage<CompanyModel> getPage(CompanyQueryModel queryModel) {
        KzPage<CompanyEntity> page = repository.findAll(queryBuilder.buildQuery(queryModel, CompanyEntityQuery.companyEntity),
                                                        queryModel.getPageable());

        return KuartzModelConverter.convert(page, new TypeReference<KzPage<CompanyModel>>() {
        });
    }

    @Transactional(readOnly = true)
    @Override
    public CompanyModel get(Long id) {
        Optional<CompanyEntity> optional = repository.findById(id);
        return KuartzModelConverter.convert(optional.orElse(null), CompanyModel.class);
    }
}
