package com.kuartz.api.auth.entity.query;

import com.kuartz.api.auth.entity.RolePrivilegeEntity;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * RolePrivilegeEntityQuery is a Querydsl query type for RolePrivilegeEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class RolePrivilegeEntityQuery extends EntityPathBase<RolePrivilegeEntity> {

    private static final long serialVersionUID = 1705178617L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final RolePrivilegeEntityQuery rolePrivilegeEntity = new RolePrivilegeEntityQuery("rolePrivilegeEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final PrivilegeEntityQuery privilege;

    public final RoleEntityQuery role;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath uuid = _super.uuid;

    public RolePrivilegeEntityQuery(String variable) {
        this(RolePrivilegeEntity.class, forVariable(variable), INITS);
    }

    public RolePrivilegeEntityQuery(Path<? extends RolePrivilegeEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public RolePrivilegeEntityQuery(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public RolePrivilegeEntityQuery(PathMetadata metadata, PathInits inits) {
        this(RolePrivilegeEntity.class, metadata, inits);
    }

    public RolePrivilegeEntityQuery(Class<? extends RolePrivilegeEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.privilege = inits.isInitialized("privilege") ? new PrivilegeEntityQuery(forProperty("privilege"), inits.get("privilege")) : null;
        this.role = inits.isInitialized("role") ? new RoleEntityQuery(forProperty("role")) : null;
    }

}

