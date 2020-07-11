package com.kuartz.api.auth.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginModel {

    @NotBlank
    @Size(min = 3, max = 60) // TODO: @kutay-celebi 07.03.2020 get from constants
    private String usernameOrEmail;

    @NotBlank
    @Size(min = 3, max = 60) // TODO: @kutay-celebi 07.03.2020 get from constants
    private String password;

    public LoginModel() {
        //    do nothing
    }

    public LoginModel(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password        = password;
    }

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
