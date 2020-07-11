package com.kuartz.api.auth.dto;

import com.kuartz.core.common.model.KuartzModel;

import javax.validation.constraints.NotNull;
import java.util.List;

// FIXME: @kutay-celebi 07.03.2020 add constraints
public class RoleModel extends KuartzModel {

    @NotNull
    private String code;

    @NotNull
    private String name;

    private String description;

    private Boolean defaultRole;

    //@JsonManagedReference("rolePrivilege")
    private List<RolePrivilegeModel> rolePrivilegeRelationList;

    public RoleModel() {
        // do nothing
    }

    public RoleModel(@NotNull String code, @NotNull String name) {
        this.code = code;
        this.name = name;
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

    public List<RolePrivilegeModel> getRolePrivilegeRelationList() {
        return rolePrivilegeRelationList;
    }

    public void setRolePrivilegeRelationList(List<RolePrivilegeModel> rolePrivilegeRelationList) {
        this.rolePrivilegeRelationList = rolePrivilegeRelationList;
    }
}
