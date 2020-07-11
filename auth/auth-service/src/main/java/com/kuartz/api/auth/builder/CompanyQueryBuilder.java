package com.kuartz.api.auth.builder;

import com.kuartz.api.auth.dto.query.CompanyQueryModel;
import com.kuartz.api.auth.entity.query.CompanyEntityQuery;
import com.kuartz.core.common.util.KzUtil;
import com.kuartz.core.data.jpa.util.KuartzQueryBuilder;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Component;

@Component
public class CompanyQueryBuilder extends KuartzQueryBuilder<CompanyQueryModel, CompanyEntityQuery> {
    @Override
    protected void prepareQuery(BooleanBuilder builder, CompanyQueryModel queryModel,
                                CompanyEntityQuery entityQuery) {
        String companyName = queryModel.getCompanyName();
        if (!KzUtil.isEmpty(companyName)) {
            builder.and(entityQuery.name.containsIgnoreCase(companyName));
        }
    }
}
