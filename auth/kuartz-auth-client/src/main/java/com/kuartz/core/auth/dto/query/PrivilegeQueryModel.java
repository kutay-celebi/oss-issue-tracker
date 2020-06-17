package com.kuartz.core.auth.dto.query;

import com.kuartz.core.common.model.KuartzQueryModel;

import java.util.List;

public class PrivilegeQueryModel extends KuartzQueryModel {

    private List<Long> idList;

    public PrivilegeQueryModel() {
        //    do nothing
    }

    public PrivilegeQueryModel(List<Long> idList) {
        this.idList = idList;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
