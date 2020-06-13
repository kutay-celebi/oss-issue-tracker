package com.kuartz.core.auth.dto;

import com.kuartz.core.common.model.KuartzModel;

import javax.validation.constraints.NotNull;

public class UserRoleModel extends KuartzModel {
    @NotNull
    private UserModel user;

    @NotNull
    private RoleModel role;


    public UserRoleModel() {
        //    do nothing
    }

    public UserRoleModel(@NotNull UserModel user, @NotNull RoleModel role) {
        this.user = user;
        this.role = role;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }
}
