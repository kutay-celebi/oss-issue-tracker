package com.kuartz.api.auth.controller;

import com.kuartz.api.auth.client.PrivilegeRestService;
import com.kuartz.api.auth.constants.UAAPrivilegeConstants;
import com.kuartz.api.auth.dto.PrivilegeModel;
import com.kuartz.api.auth.dto.query.PrivilegeQueryModel;
import com.kuartz.api.auth.service.PrivilegeService;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.rest.model.KuartzResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${kuartz.client.authzClient.privilegeService.path}")
public class PrivilegeRestController implements PrivilegeRestService {

    @Autowired
    private PrivilegeService privilegeService;

    @PreAuthorize(UAAPrivilegeConstants.PRIVILEGE_FULL)
    @Override
    public KuartzResponse<KzPage<PrivilegeModel>> getPage(@RequestBody PrivilegeQueryModel queryModel) {
        return new KuartzResponse<>(privilegeService.getPage(queryModel));
    }

    @PreAuthorize(UAAPrivilegeConstants.PRIVILEGE_FULL)
    @Override
    public KuartzResponse<PrivilegeModel> save(@RequestBody PrivilegeModel model) {
        return new KuartzResponse<>(privilegeService.save(model));
    }

    @PreAuthorize(UAAPrivilegeConstants.PRIVILEGE_FULL)
    @Override
    public KuartzResponse<PrivilegeModel> update(@RequestBody PrivilegeModel model) {
        return new KuartzResponse<>(privilegeService.update(model));
    }

    @PreAuthorize(UAAPrivilegeConstants.PRIVILEGE_FULL)
    @Override
    public KuartzResponse<Boolean> delete(@PathVariable("id") Long id) {
        return new KuartzResponse<>(privilegeService.delete(id));
    }

    @PreAuthorize(UAAPrivilegeConstants.PRIVILEGE_FULL)
    @Override
    public KuartzResponse<PrivilegeModel> get(@PathVariable("id") Long id) {
        return new KuartzResponse<>(privilegeService.get(id));
    }
}
