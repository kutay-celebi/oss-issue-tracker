package com.kuartz.core.auth.client;

import com.kuartz.core.auth.dto.PrivilegeModel;
import com.kuartz.core.auth.dto.query.PrivilegeQueryModel;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.rest.model.KuartzResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@FeignClient(name = "privilegeRestService",
             path = "${kuartz.client.authzClient.privilegeService.path}",
             url = "${kuartz.client.authzClient.url}")
public interface PrivilegeRestService {

    @RequestMapping(value = "/page",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<KzPage<PrivilegeModel>> getPage(@Valid PrivilegeQueryModel queryModel);

    @RequestMapping(value = "/save",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<PrivilegeModel> save(@Valid PrivilegeModel model);

    @RequestMapping(value = "/update",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<PrivilegeModel> update(@Valid PrivilegeModel model);

    @RequestMapping(value = "/delete/{id}",
                    method = RequestMethod.DELETE,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<Boolean> delete(@NotNull @Positive @PathVariable("id") Long id);

    @RequestMapping(value = "/get/{id}",
                    method = RequestMethod.GET,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<PrivilegeModel> get(@NotNull @Positive @PathVariable("id") Long id);
    
}
