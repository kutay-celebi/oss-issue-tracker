package com.kuartz.api.auth.client;

import com.kuartz.api.auth.dto.CompanyModel;
import com.kuartz.api.auth.dto.query.CompanyQueryModel;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.rest.model.KuartzResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@FeignClient(name = "userRestService",
             path = "${kuartz.client.authzClient.companyService.path}",
             url = "${kuartz.client.authzClient.url}")
@Validated
public interface CompanyRestService {
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<CompanyModel> get(@NotNull @Positive @PathVariable("id") Long id);

    @RequestMapping(value = "/get/page", method = RequestMethod.POST,
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<KzPage<CompanyModel>> getPage(@Valid CompanyQueryModel queryModel);

    @RequestMapping(value = "/save", method = RequestMethod.POST,
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<CompanyModel> saveUpdate(@Valid CompanyModel company);
}
