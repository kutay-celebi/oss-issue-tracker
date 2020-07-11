package com.kuartz.api.auth.dto;

import com.kuartz.core.common.model.KuartzModel;

public class CompanyModel extends KuartzModel {

    private String name;

    // TODO: @kutay-celebi 22.03.2020 link country region table
    private String country;

    private String shortName;

    private ContactModel contact;

    public CompanyModel() {
        //    do nothing
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public ContactModel getContact() {
        return contact;
    }

    public void setContact(ContactModel contact) {
        this.contact = contact;
    }
}
