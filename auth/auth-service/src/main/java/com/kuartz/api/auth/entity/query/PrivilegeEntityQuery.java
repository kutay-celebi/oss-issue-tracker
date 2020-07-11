package com.kuartz.api.auth.entity.query;

import com.kuartz.api.auth.entity.PrivilegeEntity;
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
 * PrivilegeEntityQuery is a Querydsl query type for PrivilegeEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class PrivilegeEntityQuery extends EntityPathBase<PrivilegeEntity> {

    private static final long serialVersionUID = -499425585L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final PrivilegeEntityQuery privilegeEntity = new PrivilegeEntityQuery("privilegeEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    public final StringPath code = createString("code");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    public final BooleanPath defaultPrivilege = createBoolean("defaultPrivilege");

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final PrivilegeEntityQuery parentPrivilege;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath uuid = _super.uuid;

    public PrivilegeEntityQuery(String variable) {
        this(PrivilegeEntity.class, forVariable(variable), INITS);
    }

    public PrivilegeEntityQuery(Path<? extends PrivilegeEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public PrivilegeEntityQuery(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public PrivilegeEntityQuery(PathMetadata metadata, PathInits inits) {
        this(PrivilegeEntity.class, metadata, inits);
    }

    public PrivilegeEntityQuery(Class<? extends PrivilegeEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentPrivilege = inits.isInitialized("parentPrivilege") ? new PrivilegeEntityQuery(forProperty("parentPrivilege"), inits.get("parentPrivilege")) : null;
    }

}

