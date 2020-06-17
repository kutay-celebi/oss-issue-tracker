package com.kuartz.auth.service;

import com.kuartz.core.auth.dto.RoleModel;
import com.kuartz.core.auth.dto.query.RoleQueryModel;
import com.kuartz.core.common.domain.KzPage;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
public interface RoleService {
    List<RoleModel> getDefaultRoleList();

    KzPage<RoleModel> getPage(@Valid RoleQueryModel queryModel);

    Boolean delete(@NotNull @Positive Long id);

    RoleModel save(@Valid RoleModel roleModel);

    RoleModel update(@Valid RoleModel roleModel);

    RoleModel get(@NotNull @Positive Long id);

    Boolean addPrivilege(@NotNull @Positive Long roleId, @NotNull List<Long> privilegeId);
}
