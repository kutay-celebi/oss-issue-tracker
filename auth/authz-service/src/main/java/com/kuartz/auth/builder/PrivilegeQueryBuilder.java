package com.kuartz.auth.builder;

import com.kuartz.auth.entity.query.PrivilegeEntityQuery;
import com.kuartz.core.auth.dto.query.PrivilegeQueryModel;
import com.kuartz.core.data.jpa.util.KuartzQueryBuilder;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Component;

@Component
public class PrivilegeQueryBuilder extends KuartzQueryBuilder<PrivilegeQueryModel, PrivilegeEntityQuery> {
    @Override
    protected void prepareQuery(BooleanBuilder builder, PrivilegeQueryModel queryModel, PrivilegeEntityQuery entityQuery) {
        // TODO: @kutay-celebi 07.03.2020
    }
}
