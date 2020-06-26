package com.kuartz.api.auth.client;

import com.kuartz.api.auth.dto.ChangePasswordModel;
import com.kuartz.api.auth.dto.UserModel;
import com.kuartz.api.auth.dto.query.UserQueryModel;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.common.exception.KzException;
import com.kuartz.core.common.model.KzMessageModel;
import com.kuartz.core.rest.model.KuartzResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@FeignClient(name = "userRestService",
             path = "${kuartz.client.authzClient.userService.path}",
             url = "${kuartz.client.authzClient.url}")
@Validated
public interface UserRestService {

    @RequestMapping(value = "/get/{usernameOrEmail}",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<UserModel> getUserByUsernameOrEmail(@NotBlank @PathVariable("usernameOrEmail") String usernameOrEmail);

    @RequestMapping(value = "/get/page",
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.POST,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<KzPage<UserModel>> getPage(@Valid UserQueryModel queryModel);

    @RequestMapping(value = "/save",
                    method = RequestMethod.POST,
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<UserModel> add(@Valid UserModel user);

    @RequestMapping(value = "/changePassword",
                    method = RequestMethod.POST,
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<KzMessageModel> changePassword(@Valid ChangePasswordModel changePasswordModel) throws KzException;
}
