package com.kuartz.api.auth.dto.query;

import com.kuartz.core.common.model.KuartzQueryModel;

import java.util.List;

// FIXME: @kutay-celebi 07.03.2020 add constraints
public class RoleQueryModel extends KuartzQueryModel {
    private String code;

    private List<String> excludeCodeList;

    public RoleQueryModel() {
    //    do nothing
    }

    public RoleQueryModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getExcludeCodeList() {
        return excludeCodeList;
    }

    public void setExcludeCodeList(List<String> excludeCodeList) {
        this.excludeCodeList = excludeCodeList;
    }
}
