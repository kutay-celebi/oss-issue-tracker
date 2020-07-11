package com.kuartz.api.issuetracker.common.client;

import com.kuartz.api.issuetracker.common.dto.ProjectModel;
import com.kuartz.core.feign.client.KuartzCrudFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Kutay Çelebi
 * @since 27.06.2020
 */
@FeignClient(name = "projectRestService",
        path = "${kuartz.client.issue-tracker.projectService.path}",
        url = "${kuartz.client.issue-tracker.url}")
public interface ProjectRestService extends KuartzCrudFeignClient<ProjectModel> {
}
