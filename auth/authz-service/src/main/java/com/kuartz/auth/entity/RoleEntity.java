package com.kuartz.auth.entity;

import com.kuartz.core.auth.constraints.RoleConstraints;
import com.kuartz.core.auth.constraints.UAAConstraints;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = RoleConstraints.TABLE_NAME,
       schema = UAAConstraints.SCHEMA_NAME,
       uniqueConstraints = @UniqueConstraint(name = "UIDX_ROLECODE", columnNames = {"CODE", "DELETED_AT"}))
@KuartzSequence(name = "ROLE_SEQ")
public class RoleEntity extends KuartzEntity {

    @NotNull
    @Column(name = "CODE")
    private String code;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DEFAULT_ROLE")
    private Boolean defaultRole;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT) // TODO: @kutay-celebi 17.03.2020  analyze why?
    private List<RolePrivilegeEntity> rolePrivilegeRelationList;

    public RoleEntity() {
        //    do nothing
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(Boolean defaultRole) {
        this.defaultRole = defaultRole;
    }

    public List<RolePrivilegeEntity> getRolePrivilegeRelationList() {
        return rolePrivilegeRelationList;
    }

    public void setRolePrivilegeRelationList(List<RolePrivilegeEntity> rolePrivilegeRelationList) {
        this.rolePrivilegeRelationList = rolePrivilegeRelationList;
    }
}
