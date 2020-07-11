package com.kuartz.api.auth.entity.query;

import com.kuartz.api.auth.entity.UserEntity;
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
 * UserEntityQuery is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class UserEntityQuery extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = -825296429L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final UserEntityQuery userEntity = new UserEntityQuery("userEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    public final StringPath email = createString("email");

    public final BooleanPath enabled = createBoolean("enabled");

    public final DateTimePath<java.util.Date> expirationDate = createDateTime("expirationDate", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final DateTimePath<java.util.Date> lockedDate = createDateTime("lockedDate", java.util.Date.class);

    public final StringPath password = createString("password");

    public final PersonEntityQuery person;

    public final ListPath<com.kuartz.api.auth.entity.UserRoleEntity, UserRoleEntityQuery> roleList = this.<com.kuartz.api.auth.entity.UserRoleEntity, UserRoleEntityQuery>createList("roleList", com.kuartz.api.auth.entity.UserRoleEntity.class, UserRoleEntityQuery.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final StringPath username = createString("username");

    //inherited
    public final StringPath uuid = _super.uuid;

    public UserEntityQuery(String variable) {
        this(UserEntity.class, forVariable(variable), INITS);
    }

    public UserEntityQuery(Path<? extends UserEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public UserEntityQuery(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public UserEntityQuery(PathMetadata metadata, PathInits inits) {
        this(UserEntity.class, metadata, inits);
    }

    public UserEntityQuery(Class<? extends UserEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.person = inits.isInitialized("person") ? new PersonEntityQuery(forProperty("person"), inits.get("person")) : null;
    }

}

