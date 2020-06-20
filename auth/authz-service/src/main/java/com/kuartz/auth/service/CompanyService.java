package com.kuartz.auth.service;

import com.kuartz.core.auth.dto.CompanyModel;
import com.kuartz.core.auth.dto.query.CompanyQueryModel;
import com.kuartz.core.common.domain.KzPage;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated
public interface CompanyService {
    CompanyModel saveUpdate(@Valid CompanyModel company);

    KzPage<CompanyModel> getPage(@Valid CompanyQueryModel queryModel);

    CompanyModel get(@NotNull @Positive Long id);
}
