package com.kuartz.api.auth.entity;

import com.kuartz.api.auth.constraints.UAAConstraints;
import com.kuartz.api.auth.constraints.UserRoleConstraints;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = UserRoleConstraints.TABLE_NAME,
       schema = UAAConstraints.SCHEMA_NAME,
       uniqueConstraints = @UniqueConstraint(name = "UIDX_USERROLE_USERROLE", columnNames = {"USER_ID", "ROLE_ID", "DELETED_AT"}),
       indexes = {
               @Index(columnList = "USER_ID", name = "IDX_USERROLE_PRIVILEGE"),
               @Index(columnList = "ROLE_ID", name = "IDX_USERROLE_ROLE")
       })
@KuartzSequence(name = "USER_ROLE_SEQ")
public class UserRoleEntity extends KuartzEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_USERROLE_USER0"))
    private UserEntity user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ROLE_ID", foreignKey = @ForeignKey(name = "FK_USERROLE_ROLE0"))
    private RoleEntity role;

    public UserRoleEntity() {
    //    do nothing
    }

    public UserRoleEntity(UserEntity user, RoleEntity role) {
        this.user = user;
        this.role = role;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
