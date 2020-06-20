package com.kuartz.auth.entity.query;

import com.kuartz.auth.entity.ContactEntity;
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
 * ContactEntityQuery is a Querydsl query type for ContactEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class ContactEntityQuery extends EntityPathBase<ContactEntity> {

    private static final long serialVersionUID = 1269692350L;

    public static final ContactEntityQuery contactEntity = new ContactEntityQuery("contactEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    public final StringPath adress = createString("adress");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    public final StringPath gsm1 = createString("gsm1");

    public final StringPath gsm2 = createString("gsm2");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final StringPath mail = createString("mail");

    public final StringPath tel = createString("tel");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath uuid = _super.uuid;

    public final StringPath web = createString("web");

    public ContactEntityQuery(String variable) {
        super(ContactEntity.class, forVariable(variable));
    }

    public ContactEntityQuery(Path<? extends ContactEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public ContactEntityQuery(PathMetadata metadata) {
        super(ContactEntity.class, metadata);
    }

}

