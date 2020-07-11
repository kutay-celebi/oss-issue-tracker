package com.kuartz.api.auth.entity;

import com.kuartz.api.auth.constraints.PrivilegeConstraints;
import com.kuartz.api.auth.constraints.UAAConstraints;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = PrivilegeConstraints.TABLE_NAME,
       schema = UAAConstraints.SCHEMA_NAME,
       uniqueConstraints = @UniqueConstraint(name = "UIDX_PRIVILEGE_CODE", columnNames = {"CODE","DELETED_AT"}),
       indexes = {
               @Index(columnList = "PARENT_PRIVILEGE_ID", name = "IDX_PARENTPRIVILEGE"),
       })
@KuartzSequence(name = "PRIVILEGE_SEQ")
public class PrivilegeEntity extends KuartzEntity implements GrantedAuthority {

    @NotNull
    @Column(name = "CODE")
    private String code;

    @Column(name = "DEFAULT_PRIVILEGE")
    private Boolean defaultPrivilege;

    @ManyToOne
    @JoinColumn(name = "PARENT_PRIVILEGE_ID", foreignKey = @ForeignKey(name = "FK_PRIVILEGE_PARENTPRIVELEGE"))
    private PrivilegeEntity parentPrivilege;

    @Override
    public String getAuthority() {
        return this.code;
    }

    public PrivilegeEntity() {
    //     do nothing
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getDefaultPrivilege() {
        return defaultPrivilege;
    }

    public void setDefaultPrivilege(Boolean defaultPrivilege) {
        this.defaultPrivilege = defaultPrivilege;
    }

    public PrivilegeEntity getParentPrivilege() {
        return parentPrivilege;
    }

    public void setParentPrivilege(PrivilegeEntity parentPrivilege) {
        this.parentPrivilege = parentPrivilege;
    }
}
