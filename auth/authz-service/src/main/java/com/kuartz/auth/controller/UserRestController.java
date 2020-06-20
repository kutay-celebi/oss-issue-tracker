package com.kuartz.auth.controller;

import com.kuartz.auth.service.UserService;
import com.kuartz.core.auth.client.UserRestService;
import com.kuartz.core.auth.dto.UserModel;
import com.kuartz.core.auth.dto.query.UserQueryModel;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.rest.model.KuartzResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${kuartz.client.authzClient.userService.path}")
public class UserRestController implements UserRestService {

    @Autowired
    private DefaultTokenServices jwtProvider;

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
}
