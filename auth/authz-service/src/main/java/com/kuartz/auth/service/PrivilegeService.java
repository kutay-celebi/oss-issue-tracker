package com.kuartz.auth.service;

import com.kuartz.core.auth.dto.PrivilegeModel;
import com.kuartz.core.auth.dto.query.PrivilegeQueryModel;
import com.kuartz.core.common.domain.KzPage;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated
public interface PrivilegeService {
    KzPage<PrivilegeModel> getPage(@Valid PrivilegeQueryModel queryModel);

    PrivilegeModel save(@Valid PrivilegeModel model);

    PrivilegeModel update(@Valid PrivilegeModel model);

    Boolean delete(@NotNull @Positive Long id);

    PrivilegeModel get(@NotNull @Positive Long id);
}
