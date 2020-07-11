package com.kuartz.api.auth.entity.query;

import com.kuartz.api.auth.entity.CompanyEntity;
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
 * CompanyEntityQuery is a Querydsl query type for CompanyEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class CompanyEntityQuery extends EntityPathBase<CompanyEntity> {

    private static final long serialVersionUID = 1691326043L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final CompanyEntityQuery companyEntity = new CompanyEntityQuery("companyEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    public final ContactEntityQuery contact;

    public final StringPath country = createString("country");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final StringPath name = createString("name");

    public final StringPath shortName = createString("shortName");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath uuid = _super.uuid;

    public CompanyEntityQuery(String variable) {
        this(CompanyEntity.class, forVariable(variable), INITS);
    }

    public CompanyEntityQuery(Path<? extends CompanyEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public CompanyEntityQuery(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public CompanyEntityQuery(PathMetadata metadata, PathInits inits) {
        this(CompanyEntity.class, metadata, inits);
    }

    public CompanyEntityQuery(Class<? extends CompanyEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.contact = inits.isInitialized("contact") ? new ContactEntityQuery(forProperty("contact")) : null;
    }

}

