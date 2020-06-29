package com.kuartz.api.issuetracker.service.controller;

import com.kuartz.api.issuetracker.common.client.ProjectRestService;
import com.kuartz.api.issuetracker.common.dto.ProjectModel;
import com.kuartz.api.issuetracker.service.service.ProjectService;
import com.kuartz.core.service.rest.KuartzCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "${kuartz.client.issue-tracker.projectService.path}")
@RestController
public class ProjectRestController extends KuartzCrudController<ProjectModel, ProjectService> implements ProjectRestService  {

}
