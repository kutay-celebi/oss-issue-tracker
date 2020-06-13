package com.kuartz.core.auth.dto;

import com.kuartz.core.common.model.KuartzModel;

public class ContactModel extends KuartzModel {

    private String adress;

    private String gsm1;

    private String gsm2;

    private String tel;

    private String mail;

    private String web;

    public ContactModel() {
        //    do nothing
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
