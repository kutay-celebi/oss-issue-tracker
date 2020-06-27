package com.kuartz.api.issuetracker.service.controller;

import com.kuartz.api.issuetracker.common.client.ProjectRestService;
import com.kuartz.core.rest.model.KuartzResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${kuartz.client.issue-tracker.projectService.path}")
public class ProjectRestController implements ProjectRestService {

    @Override
    public KuartzResponse<String> getInfo() {
        return new KuartzResponse<>("OK");
    }
}
