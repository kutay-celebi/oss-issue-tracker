package com.kuartz.api.auth.entity.query;

import com.kuartz.api.auth.entity.PersonEntity;
import com.kuartz.api.auth.enumeration.Gender;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * PersonEntityQuery is a Querydsl query type for PersonEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class PersonEntityQuery extends EntityPathBase<PersonEntity> {

    private static final long serialVersionUID = -1023353699L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final PersonEntityQuery personEntity = new PersonEntityQuery("personEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    public final DatePath<java.util.Date> birthday = createDate("birthday", java.util.Date.class);

    public final ContactEntityQuery contact;

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath identificationNumber = createString("identificationNumber");

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final StringPath lastName = createString("lastName");

    public final StringPath midName = createString("midName");

    public final StringPath name = createString("name");

    public final StringPath nationality = createString("nationality");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath uuid = _super.uuid;

    public PersonEntityQuery(String variable) {
        this(PersonEntity.class, forVariable(variable), INITS);
    }

    public PersonEntityQuery(Path<? extends PersonEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public PersonEntityQuery(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public PersonEntityQuery(PathMetadata metadata, PathInits inits) {
        this(PersonEntity.class, metadata, inits);
    }

    public PersonEntityQuery(Class<? extends PersonEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.contact = inits.isInitialized("contact") ? new ContactEntityQuery(forProperty("contact")) : null;
    }

}

