package com.kuartz.auth.entity.query;

import com.kuartz.auth.entity.ResourceEntity;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * ResourceEntityQuery is a Querydsl query type for ResourceEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class ResourceEntityQuery extends EntityPathBase<ResourceEntity> {

    private static final long serialVersionUID = -1992382122L;

    public static final ResourceEntityQuery resourceEntity = new ResourceEntityQuery("resourceEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final StringPath resourceName = createString("resourceName");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath uuid = _super.uuid;

    public ResourceEntityQuery(String variable) {
        super(ResourceEntity.class, forVariable(variable));
    }

    public ResourceEntityQuery(Path<? extends ResourceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public ResourceEntityQuery(PathMetadata metadata) {
        super(ResourceEntity.class, metadata);
    }

}

