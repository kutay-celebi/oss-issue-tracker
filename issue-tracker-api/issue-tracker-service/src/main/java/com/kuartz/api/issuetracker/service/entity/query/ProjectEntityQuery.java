package com.kuartz.api.issuetracker.service.entity.query;

import com.kuartz.api.issuetracker.service.entity.ProjectEntity;
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
 * ProjectEntityQuery is a Querydsl query type for ProjectEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class ProjectEntityQuery extends EntityPathBase<ProjectEntity> {

    private static final long serialVersionUID = 1934903685L;

    public static final ProjectEntityQuery projectEntity = new ProjectEntityQuery("projectEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    public final DateTimePath<java.util.Date> dueDate = createDateTime("dueDate", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final BooleanPath isEnabled = createBoolean("isEnabled");

    public final StringPath projectCode = createString("projectCode");

    public final StringPath projectName = createString("projectName");

    public final DateTimePath<java.util.Date> startedDate = createDateTime("startedDate", java.util.Date.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath uuid = _super.uuid;

    public ProjectEntityQuery(String variable) {
        super(ProjectEntity.class, forVariable(variable));
    }

    public ProjectEntityQuery(Path<? extends ProjectEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public ProjectEntityQuery(PathMetadata metadata) {
        super(ProjectEntity.class, metadata);
    }

}

