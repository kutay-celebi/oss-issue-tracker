package com.kuartz.api.auth.entity;

import com.kuartz.api.auth.constraints.ContactConstraints;
import com.kuartz.api.auth.constraints.UAAConstraints;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: @kutay-celebi 22.03.2020 when the region city etc. created link there
@Entity
@Table(name = ContactConstraints.TABLE_NAME, schema = UAAConstraints.SCHEMA_NAME)
@KuartzSequence(name = "UAA_CONTACT_SEQ")
public class ContactEntity extends KuartzEntity {

    @Column(name = "ADRESS")
    private String adress;

    @Column(name = "GSM1")
    private String gsm1;

    @Column(name = "GSM2")
    private String gsm2;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "WEB")
    private String web;


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGsm1() {
        return gsm1;
    }

    public void setGsm1(String gsm1) {
        this.gsm1 = gsm1;
    }

    public String getGsm2() {
        return gsm2;
    }

    public void setGsm2(String gsm2) {
        this.gsm2 = gsm2;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
