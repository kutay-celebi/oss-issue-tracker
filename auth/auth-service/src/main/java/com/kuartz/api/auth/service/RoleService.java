package com.kuartz.api.auth.service;

import com.kuartz.api.auth.dto.RoleModel;
import com.kuartz.api.auth.dto.query.RoleQueryModel;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.common.model.KzMessageModel;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
public interface RoleService {
    List<RoleModel> getDefaultRoleList();

    KzPage<RoleModel> getPage(@Valid RoleQueryModel queryModel);

    KzMessageModel delete(@NotNull @Positive Long id);

    RoleModel save(@Valid RoleModel roleModel);

    RoleModel update(@Valid RoleModel roleModel);

    RoleModel get(@NotNull @Positive Long id);

    KzMessageModel addPrivilege(@NotNull @Positive Long roleId, @NotNull List<Long> privilegeId);

    KzMessageModel removePrivilegeFromRole(@NotNull @Positive Long relationId);
}
