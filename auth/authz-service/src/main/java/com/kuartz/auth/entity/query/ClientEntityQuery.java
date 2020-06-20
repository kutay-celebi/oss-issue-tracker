package com.kuartz.auth.entity.query;

import com.kuartz.auth.entity.ClientEntity;
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
 * ClientEntityQuery is a Querydsl query type for ClientEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class ClientEntityQuery extends EntityPathBase<ClientEntity> {

    private static final long serialVersionUID = -1804761965L;

    public static final ClientEntityQuery clientEntity = new ClientEntityQuery("clientEntity");

    public final com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery _super = new com.kuartz.core.data.jpa.entity.query.KuartzEntityQuery(this);

    public final NumberPath<Integer> accessTokenValiditySeconds = createNumber("accessTokenValiditySeconds", Integer.class);

    public final StringPath additionalInformation = createString("additionalInformation");

    public final StringPath authorities = createString("authorities");

    public final StringPath authorizedGrantTypes = createString("authorizedGrantTypes");

    public final StringPath autoApproveScopes = createString("autoApproveScopes");

    public final StringPath clientId = createString("clientId");

    public final StringPath clientSecret = createString("clientSecret");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.util.Date> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final NumberPath<Integer> refreshTokenValiditySeconds = createNumber("refreshTokenValiditySeconds", Integer.class);

    public final StringPath registeredRedirectUri = createString("registeredRedirectUri");

    public final ListPath<com.kuartz.auth.entity.ResourceEntity, ResourceEntityQuery> reourceList = this.<com.kuartz.auth.entity.ResourceEntity, ResourceEntityQuery>createList("reourceList", com.kuartz.auth.entity.ResourceEntity.class, ResourceEntityQuery.class, PathInits.DIRECT2);

    public final StringPath scope = createString("scope");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath uuid = _super.uuid;

    public ClientEntityQuery(String variable) {
        super(ClientEntity.class, forVariable(variable));
    }

    public ClientEntityQuery(Path<? extends ClientEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public ClientEntityQuery(PathMetadata metadata) {
        super(ClientEntity.class, metadata);
    }

}

