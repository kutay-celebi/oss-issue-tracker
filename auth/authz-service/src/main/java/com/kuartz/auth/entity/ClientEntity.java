package com.kuartz.auth.entity;

import com.kuartz.core.auth.constraints.ClientDetailConstraints;
import com.kuartz.core.auth.constraints.UAAConstraints;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

@Entity
@Table(name = ClientDetailConstraints.TABLE_NAME,
       schema = UAAConstraints.SCHEMA_NAME,
       uniqueConstraints = @UniqueConstraint(name = "UIDX_CLIENTID", columnNames = {"CLIENT_ID", "DELETED_AT"}))
@KuartzSequence(name = "CLIENT_SEQ")
public class ClientEntity extends KuartzEntity {
    @Column(name = "CLIENT_ID")
    private String clientId;

    @Column(name = "CLIENT_SECRET")
    private String clientSecret;

    @Column(name = "SCOPE")
    private String scope;

    @Column(name = "AUTHORIZED_GRANT_TYPES")
    private String authorizedGrantTypes;

    @Column(name = "REGISTERED_REDIRECT_URI")
    private String registeredRedirectUri;

    @Column(name = "AUTHORITIES")
    private String authorities;

    @Column(name = "ACCES_TOKEN_VALIDITY_SECONDS")
    private Integer accessTokenValiditySeconds;

    @Column(name = "REFRESH_TOKEN_VALIDITY_SECONDS")
    private Integer refreshTokenValiditySeconds;

    @Column(name = "ADDITIONAL_INFORMATION")
    private String additionalInformation;

    @Column(name = "AUTO_APPROVE_SCOPES")
    private String autoApproveScopes;

    // TODO: @kutay-celebi 07.03.2020 convert relation table
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CLIENT_RESOURCE_RELATION",
               schema = UAAConstraints.SCHEMA_NAME,
               uniqueConstraints = @UniqueConstraint(name = "UC_CLIENT_RESOURCE", columnNames = {"CLIENT_ID", "RESOURCE_ID"}),
               joinColumns = @JoinColumn(name = "CLIENT_ID", referencedColumnName = ID_FIELD),
               inverseJoinColumns = @JoinColumn(name = "RESOURCE_ID", referencedColumnName = ID_FIELD))
    private List<ResourceEntity> reourceList;

    public ClientEntity() {
    //    do nothing
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getRegisteredRedirectUri() {
        return registeredRedirectUri;
    }

    public void setRegisteredRedirectUri(String registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoApproveScopes() {
        return autoApproveScopes;
    }

    public void setAutoApproveScopes(String autoApproveScopes) {
        this.autoApproveScopes = autoApproveScopes;
    }

    public List<ResourceEntity> getReourceList() {
        return reourceList;
    }

    public void setReourceList(List<ResourceEntity> reourceList) {
        this.reourceList = reourceList;
    }
}
