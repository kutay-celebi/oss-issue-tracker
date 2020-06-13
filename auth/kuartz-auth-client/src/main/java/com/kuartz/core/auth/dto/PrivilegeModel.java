package com.kuartz.core.auth.dto;

import com.kuartz.core.common.model.KuartzModel;

public class PrivilegeModel extends KuartzModel {

    private String code;

    private PrivilegeModel parentPrivilege;

    public String getAuthority() {
        return this.code;
    }

    public PrivilegeModel() {
        // do nothing
    }

    public PrivilegeModel(String code, PrivilegeModel parentPrivilege) {
        this.code            = code;
        this.parentPrivilege = parentPrivilege;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PrivilegeModel getParentPrivilege() {
        return parentPrivilege;
    }

    public void setParentPrivilege(PrivilegeModel parentPrivilege) {
        this.parentPrivilege = parentPrivilege;
    }
}
