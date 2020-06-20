package com.kuartz.auth.service;

import com.kuartz.core.auth.dto.RegisterModel;
import com.kuartz.core.auth.dto.UserModel;
import com.kuartz.core.auth.dto.query.UserQueryModel;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.common.exception.KzException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Validated
public interface UserService extends UserDetailsService {
    UserModel register(@Valid RegisterModel registerModel) throws KzException;

    UserModel getUserByUsernameOrEmail(@NotBlank String usernameOrEmail);

    KzPage<UserModel> getPage(@Valid UserQueryModel queryModel);

    UserModel add(@Valid UserModel user);
}
