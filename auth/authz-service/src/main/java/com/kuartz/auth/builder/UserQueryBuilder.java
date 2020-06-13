package com.kuartz.auth.builder;

import com.kuartz.auth.entity.query.UserEntityQuery;
import com.kuartz.core.auth.dto.query.UserQueryModel;
import com.kuartz.core.common.util.KzUtil;
import com.kuartz.core.data.jpa.util.KuartzQueryBuilder;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserQueryBuilder extends KuartzQueryBuilder<UserQueryModel, UserEntityQuery> {
    @Override
    protected void prepareQuery(BooleanBuilder builder, UserQueryModel queryModel, UserEntityQuery entityQuery) {
        String username = queryModel.getUsername();
        if (!KzUtil.isEmpty(username)) {
            builder.and(entityQuery.username.contains(username));
        }

        String email = queryModel.getEmail();
        if (!KzUtil.isEmpty(email)) {
            builder.and(entityQuery.email.contains(email));
        }
    }
}
