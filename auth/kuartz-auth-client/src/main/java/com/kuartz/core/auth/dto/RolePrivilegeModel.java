package com.kuartz.core.auth.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kuartz.core.common.model.KuartzModel;

import javax.validation.constraints.NotNull;

// FIXME: @kutay-celebi 07.03.2020 add constraints @see RolePrivilegeEntity
public class RolePrivilegeModel extends KuartzModel {

    @NotNull
    private PrivilegeModel privilege;

    @JsonBackReference("rolePrivilege")
    @NotNull
    private RoleModel role;

    public RolePrivilegeModel() {
        // do nothing
    }

    public RolePrivilegeModel(@NotNull PrivilegeModel privilege, @NotNull RoleModel role) {
        this.privilege = privilege;
        this.role      = role;
    }

    public PrivilegeModel getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeModel privilege) {
        this.privilege = privilege;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }
}
