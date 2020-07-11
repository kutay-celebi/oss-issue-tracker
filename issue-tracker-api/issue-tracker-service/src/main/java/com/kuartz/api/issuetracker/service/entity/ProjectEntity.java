package com.kuartz.api.issuetracker.service.entity;

import com.kuartz.api.issuetracker.common.constraints.IssueTrackerConstraints;
import com.kuartz.api.issuetracker.common.constraints.ProjectConstraints;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Kutay Çelebi
 * @since 27.06.2020
 */
@Entity
@Table(name = ProjectConstraints.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = "UIDX_PROJECT_CODE", columnNames = {"CODE", "DELETED_AT"}),
},
        schema = IssueTrackerConstraints.DB_SCHEMA_NAME)
@KuartzSequence(name = "KIT_PROJECT_SEC")
public class ProjectEntity extends KuartzEntity {

    @Column(name = "NAME")
    @Size(min = ProjectConstraints.NAME_MIN, max = ProjectConstraints.NAME_MAX)
    private String projectName;

    @Column(name = "CODE")
    @Size(min = ProjectConstraints.CODE_MIN, max = ProjectConstraints.CODE_MAX)
    private String projectCode;

    @Column(name = "STARTED_DATE")
    private Date startedDate;

    @Column(name = "DUE_DATE")
    private Date dueDate;

    @Column(name = "IS_ENABLED")
    private Boolean isEnabled;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }
}
