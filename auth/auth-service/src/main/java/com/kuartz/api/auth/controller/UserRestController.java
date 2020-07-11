package com.kuartz.api.auth.controller;

import com.kuartz.api.auth.client.UserRestService;
import com.kuartz.api.auth.dto.ChangePasswordModel;
import com.kuartz.api.auth.dto.UserModel;
import com.kuartz.api.auth.dto.query.UserQueryModel;
import com.kuartz.api.auth.service.UserService;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.common.exception.KzException;
import com.kuartz.core.common.model.KuartzResponse;
import com.kuartz.core.common.model.KzMessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${kuartz.client.authzClient.userService.path}")
public class UserRestController implements UserRestService {

    @Autowired
    private UserService userService;

    @Override
    public KuartzResponse<UserModel> getUserByUsernameOrEmail(@PathVariable("usernameOrEmail") String usernameOrEmail) {
        return new KuartzResponse<>(userService.getUserByUsernameOrEmail(usernameOrEmail));
    }

    @Override
    public KuartzResponse<KzPage<UserModel>> getPage(@RequestBody UserQueryModel queryModel) {
        return new KuartzResponse<>(userService.getPage(queryModel));
    }

    @Override
    public KuartzResponse<UserModel> add(@RequestBody UserModel user) {
        return new KuartzResponse<>(userService.add(user));
    }

    @Override
    public KuartzResponse<KzMessageModel> changePassword(@RequestBody ChangePasswordModel changePasswordModel) throws KzException {
        return new KuartzResponse<>(userService.changePassword(changePasswordModel));
    }
}
