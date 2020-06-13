package com.kuartz.auth.entity;

import com.kuartz.core.auth.constraints.ResourceConstraints;
import com.kuartz.core.auth.constraints.UAAConstraints;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = ResourceConstraints.TABLE_NAME,
       schema = UAAConstraints.SCHEMA_NAME,
       uniqueConstraints = @UniqueConstraint(name = "UIDX_RESOURCE_NAME", columnNames = {"RESOURCE_NAME", "DELETED_AT"}))
@KuartzSequence(name = "RESOURCE_SEQ")
public class ResourceEntity extends KuartzEntity {

    @NotNull
    @Column(name = "RESOURCE_NAME")
    private String resourceName;

    public ResourceEntity() {
        //    do nothing
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
