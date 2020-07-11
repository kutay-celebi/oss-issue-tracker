package com.kuartz.api.auth.entity.query;

import com.kuartz.api.auth.entity.UserRoleEntity;
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
 * UserRoleEntityQuery is a Querydsl query type for UserRoleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class UserRoleEntityQuery extends EntityPathBase<UserRoleEntity> {

    private static final long serialVersionUID = 286014953L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final UserRoleEntityQuery userRoleEntity = new UserRoleEntityQuery("userRoleEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final RoleEntityQuery role;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final UserEntityQuery user;

    //inherited
    public final StringPath uuid = _super.uuid;

    public UserRoleEntityQuery(String variable) {
        this(UserRoleEntity.class, forVariable(variable), INITS);
    }

    public UserRoleEntityQuery(Path<? extends UserRoleEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public UserRoleEntityQuery(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public UserRoleEntityQuery(PathMetadata metadata, PathInits inits) {
        this(UserRoleEntity.class, metadata, inits);
    }

    public UserRoleEntityQuery(Class<? extends UserRoleEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.role = inits.isInitialized("role") ? new RoleEntityQuery(forProperty("role")) : null;
        this.user = inits.isInitialized("user") ? new UserEntityQuery(forProperty("user"), inits.get("user")) : null;
    }

}

