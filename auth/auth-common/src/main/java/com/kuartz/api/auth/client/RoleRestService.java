package com.kuartz.api.auth.client;

import com.kuartz.api.auth.dto.RoleModel;
import com.kuartz.api.auth.dto.query.RoleQueryModel;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.common.model.KzMessageModel;
import com.kuartz.core.rest.model.KuartzResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@FeignClient(name = "userRestService",
             path = "${kuartz.client.authzClient.roleService.path}",
             url = "${kuartz.client.authzClient.url}")
@Validated
public interface RoleRestService {

    @RequestMapping(value = "/page",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<KzPage<RoleModel>> getPage(@Valid RoleQueryModel queryModel);

    @RequestMapping(value = "/save",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<RoleModel> save(@Valid RoleModel roleModel);

    @RequestMapping(value = "/update",
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<RoleModel> update(@Valid RoleModel roleModel);

    @RequestMapping(value = "/delete/{id}",
                    method = RequestMethod.DELETE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<KzMessageModel> delete(@NotNull @Positive @PathVariable("id") Long id);

    @RequestMapping(value = "/get/{id}",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<RoleModel> get(@NotNull @Positive @PathVariable("id") Long id);

    @RequestMapping(value = "/addPrivilegeList",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<KzMessageModel> addPrivilegeList(@NotNull @Positive @RequestParam("roleId") Long roleId,
                                                    @NotNull List<Long> privilegeIdList);

    @RequestMapping(value = "/removePrivilegeRelation/{relationId}",
                    method = RequestMethod.DELETE,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<KzMessageModel> removePrivilegeFromRole(@NotNull @Positive @PathVariable("relationId") Long roleId);

}
