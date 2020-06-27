package com.kuartz.api.issuetracker.common.client;

import com.kuartz.core.rest.model.KuartzResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kutay Çelebi
 * @since 27.06.2020
 */
@FeignClient(name = "projectRestService",
        path = "${kuartz.client.issue-tracker.projectService.path}",
        url = "${kuartz.client.issue-tracker.url}")
public interface ProjectRestService {
    @RequestMapping(value = "/info",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    KuartzResponse<String> getInfo();
}
