package com.kuartz.auth.controller;

import com.kuartz.auth.constants.UAAPrivilegeConstants;
import com.kuartz.auth.service.RoleService;
import com.kuartz.core.auth.client.RoleRestService;
import com.kuartz.core.auth.dto.RoleModel;
import com.kuartz.core.auth.dto.query.RoleQueryModel;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.rest.model.KuartzResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "${kuartz.client.authzClient.roleService.path}")
public class RoleRestController implements RoleRestService {

    @Autowired
    private RoleService roleService;

    @PreAuthorize(UAAPrivilegeConstants.ROLE_FULL)
    @Override
    public KuartzResponse<KzPage<RoleModel>> getPage(@RequestBody RoleQueryModel queryModel) {
        return new KuartzResponse<>(roleService.getPage(queryModel));
    }

    @PreAuthorize(UAAPrivilegeConstants.ROLE_FULL)
    @Override
    public KuartzResponse<RoleModel> save(@RequestBody RoleModel roleModel) {
        return new KuartzResponse<>(roleService.save(roleModel));
    }

    @PreAuthorize(UAAPrivilegeConstants.ROLE_FULL)
    @Override
    public KuartzResponse<RoleModel> update(@RequestBody RoleModel roleModel) {
        return new KuartzResponse<>(roleService.update(roleModel));
    }

    @PreAuthorize(UAAPrivilegeConstants.ROLE_FULL)
    @Override
    public KuartzResponse<Boolean> delete(@PathVariable("id") Long id) {
        return new KuartzResponse<>(roleService.delete(id));
    }

    @PreAuthorize(UAAPrivilegeConstants.ROLE_FULL)
    @Override
    public KuartzResponse<RoleModel> get(@PathVariable("id") Long id) {
        return new KuartzResponse<>(roleService.get(id));
    }

    @PreAuthorize(UAAPrivilegeConstants.ROLE_FULL)
    @Override
    public KuartzResponse<Boolean> addPrivilegeList(@RequestParam("roleId") Long roleId, @RequestBody List<Long> privilegeId) {
        return new KuartzResponse<>(roleService.addPrivilege(roleId, privilegeId));
    }
}
