package com.kuartz.api.auth.builder;

import com.kuartz.api.auth.dto.query.PrivilegeQueryModel;
import com.kuartz.api.auth.entity.query.PrivilegeEntityQuery;
import com.kuartz.core.common.util.KzUtil;
import com.kuartz.core.data.jpa.util.KuartzQueryBuilder;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrivilegeQueryBuilder extends KuartzQueryBuilder<PrivilegeQueryModel, PrivilegeEntityQuery> {
    @Override
    protected void prepareQuery(BooleanBuilder builder, PrivilegeQueryModel queryModel, PrivilegeEntityQuery entityQuery) {
        List<Long> idList = queryModel.getIdList();
        if (!KzUtil.isEmpty(idList)) {
            builder.and(entityQuery.id.in(idList));
        }
    }
}
