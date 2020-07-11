package com.kuartz.api.auth.builder;

import com.kuartz.api.auth.dto.query.RoleQueryModel;
import com.kuartz.api.auth.entity.query.RoleEntityQuery;
import com.kuartz.core.common.util.KzUtil;
import com.kuartz.core.data.jpa.util.KuartzQueryBuilder;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleQueryBuilder extends KuartzQueryBuilder<RoleQueryModel, RoleEntityQuery> {
    @Override
    protected void prepareQuery(BooleanBuilder builder, RoleQueryModel queryModel, RoleEntityQuery entityQuery) {
        String code = queryModel.getCode();
        if (!KzUtil.isEmpty(code)) {
            builder.and(entityQuery.code.containsIgnoreCase(code));
        }

        List<String> excludeCodeList = queryModel.getExcludeCodeList();
        if (!KzUtil.isEmpty(excludeCodeList)) {
            builder.and(entityQuery.code.notIn(excludeCodeList));
        }
    }
}
