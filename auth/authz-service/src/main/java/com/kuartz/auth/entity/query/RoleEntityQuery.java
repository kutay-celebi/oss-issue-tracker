package com.kuartz.auth.entity.query;

import com.kuartz.auth.entity.RoleEntity;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.ListPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * RoleEntityQuery is a Querydsl query type for RoleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class RoleEntityQuery extends EntityPathBase<RoleEntity> {

    private static final long serialVersionUID = -933748162L;

    public static final RoleEntityQuery roleEntity = new RoleEntityQuery("roleEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    public final StringPath code = createString("code");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    public final BooleanPath defaultRole = createBoolean("defaultRole");

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final StringPath name = createString("name");

    public final ListPath<com.kuartz.auth.entity.RolePrivilegeEntity, RolePrivilegeEntityQuery> rolePrivilegeRelationList = this.<com.kuartz.auth.entity.RolePrivilegeEntity, RolePrivilegeEntityQuery>createList("rolePrivilegeRelationList", com.kuartz.auth.entity.RolePrivilegeEntity.class, RolePrivilegeEntityQuery.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath uuid = _super.uuid;

    public RoleEntityQuery(String variable) {
        super(RoleEntity.class, forVariable(variable));
    }

    public RoleEntityQuery(Path<? extends RoleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public RoleEntityQuery(PathMetadata metadata) {
        super(RoleEntity.class, metadata);
    }

}

