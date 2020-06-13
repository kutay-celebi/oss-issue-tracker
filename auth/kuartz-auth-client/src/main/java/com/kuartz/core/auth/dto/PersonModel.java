package com.kuartz.core.auth.dto;

import com.kuartz.core.auth.enumeration.Gender;
import com.kuartz.core.common.model.KuartzModel;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class PersonModel extends KuartzModel {

    private String identificationNumber;

    private String nationality; // TODO: @kutay-celebi 22.03.2020 create nationality country city table.

    @NotNull
    private String name;

    private String midName;

    @NotNull
    private String lastName;

    private String title;

    private Date birthday;

    private Gender gender;

    private ContactModel contact;

    private CompanyModel company;

    public PersonModel() {
        //    do nothing
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ContactModel getContact() {
        return contact;
    }

    public void setContact(ContactModel contact) {
        this.contact = contact;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }
}
