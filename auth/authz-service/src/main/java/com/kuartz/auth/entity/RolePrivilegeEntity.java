package com.kuartz.auth.entity;

import com.kuartz.core.auth.constraints.RolePrivilegeConstraints;
import com.kuartz.core.auth.constraints.UAAConstraints;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;
import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = RolePrivilegeConstraints.TABLE_NAME,
       schema = UAAConstraints.SCHEMA_NAME,
       uniqueConstraints = @UniqueConstraint(name = "UIDX_ROLEPRIVILEGE_PRIROLE", columnNames = {"PRIVILEGE_ID", "ROLE_ID", "DELETED_AT"}),
       indexes = {
               @Index(columnList = "PRIVILEGE_ID", name = "IDX_ROLEPRIVILEGE_PRIVILEGE"),
               @Index(columnList = "ROLE_ID", name = "IDX_ROLEPRIVILEGE_ROLE")
       })
@KuartzSequence(name = "ROLE_PRIVILEGE_SEQ")
public class RolePrivilegeEntity extends KuartzEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PRIVILEGE_ID", foreignKey = @ForeignKey(name = "FK_ROLEPRIVILEGE_PRIVILEGE0"))
    private PrivilegeEntity privilege;

    @JsonBackReference("rolePrivilege")
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ROLE_ID", foreignKey = @ForeignKey(name = "FK_ROLEPRIVILEGE_ROLE0"))
    private RoleEntity role;

    public RolePrivilegeEntity() {
    //    do nothing
    }

    public RolePrivilegeEntity(PrivilegeEntity privilege, RoleEntity role) {
        this.privilege = privilege;
        this.role      = role;
    }

    public PrivilegeEntity getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeEntity privilege) {
        this.privilege = privilege;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
