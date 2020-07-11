package com.kuartz.api.auth.dto;

import com.kuartz.api.auth.constraints.UserConstraints;
import com.kuartz.core.common.model.KuartzModel;
import com.kuartz.core.common.security.PrincipalAuthority;
import com.kuartz.core.common.util.KzUtil;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// FIXME: @kutay-celebi 07.03.2020 add constraints also entity
public class UserModel extends KuartzModel {

    @Size(min = UserConstraints.USERNAME_MIN, max = UserConstraints.USERNAME_MAX)
    @NotNull
    private String username;

    private String password;

    @Email
    @NotNull
    private String email;

    private Boolean enabled = Boolean.TRUE;

    private List<UserRoleModel> roleList;

    @NotNull
    private PersonModel person;

    public UserModel() {
        //    do nothing
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Set<PrincipalAuthority> getAuthorities() {
        Set<PrincipalAuthority> authorities = new HashSet<>();
        List<RolePrivilegeModel> rolePrivilegeRelList = new ArrayList<>();
        if (!KzUtil.isEmpty(roleList)) {
            roleList.stream().map(UserRoleModel::getRole).map(RoleModel::getRolePrivilegeRelationList).forEach(
                    rolePrivilegeRelList::addAll);
            rolePrivilegeRelList.forEach(rel -> authorities.add(new PrincipalAuthority(rel.getPrivilege().getCode())));
        }
        return authorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserRoleModel> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UserRoleModel> roleList) {
        this.roleList = roleList;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public PersonModel getPerson() {
        return person;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }
}
