package com.kuartz.api.auth.dto.query;

import com.kuartz.core.common.model.KuartzQueryModel;

public class CompanyQueryModel extends KuartzQueryModel {
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
