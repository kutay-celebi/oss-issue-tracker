package com.kuartz.core.auth.dto.query;

import com.kuartz.core.auth.constraints.UserConstraints;
import com.kuartz.core.common.model.KuartzQueryModel;

import javax.validation.constraints.Size;

public class UserQueryModel extends KuartzQueryModel {

    @Size(max = UserConstraints.USERNAME_MAX)
    private String username;

    @Size(max = UserConstraints.EMAIL_MAX)
    private String email;

    public UserQueryModel() {
        //    bos yapici
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
