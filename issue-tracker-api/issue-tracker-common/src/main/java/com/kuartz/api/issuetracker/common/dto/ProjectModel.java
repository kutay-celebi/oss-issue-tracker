package com.kuartz.api.issuetracker.common.dto;

import com.kuartz.core.common.model.KuartzModel;

import java.util.Date;

/**
 * @author Kutay Çelebi
 * @since 27.06.2020
 */
public class ProjectModel extends KuartzModel {

    private String projectName;

    private String projectCode;

    private Date startedDate;

    private Date dueDate;

    private Boolean isEnabled = Boolean.TRUE;


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
