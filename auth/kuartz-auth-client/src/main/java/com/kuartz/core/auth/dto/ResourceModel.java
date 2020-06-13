package com.kuartz.core.auth.dto;

import com.kuartz.core.common.model.KuartzModel;

public class ResourceModel extends KuartzModel {

    // FIXME: @kutay-celebi 07.03.2020 add constraints
    private String resourceName;

    public ResourceModel() {
        // do nothing
    }

    public ResourceModel(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
