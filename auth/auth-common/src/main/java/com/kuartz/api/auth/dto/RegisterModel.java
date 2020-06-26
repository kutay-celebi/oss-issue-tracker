package com.kuartz.api.auth.dto;

import com.kuartz.api.auth.enumeration.Gender;
import com.kuartz.core.common.model.KuartzModel;

import javax.validation.constraints.Email;
import java.util.Date;

// TODO: @kutay-celebi 17.03.2020 add constraints
public class RegisterModel extends KuartzModel {

    private String username;

    // FIXME: @kutay-celebi 07.03.2020 add password policy
    private String password;

    @Email
    private String email;

    private String name;

    private String surname;

    private Gender gender;

    private Date birthday;

    public RegisterModel() {
        // do nothing
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
