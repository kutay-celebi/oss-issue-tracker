package com.kuartz.api.auth.controller;

import com.kuartz.api.auth.client.CompanyRestService;
import com.kuartz.api.auth.dto.CompanyModel;
import com.kuartz.api.auth.dto.query.CompanyQueryModel;
import com.kuartz.api.auth.service.CompanyService;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.rest.model.KuartzResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${kuartz.client.authzClient.companyService.path}")
public class CompanyRestController implements CompanyRestService {

    @Autowired
    private CompanyService companyService;

    @Override
    public KuartzResponse<CompanyModel> get(@PathVariable("id") Long id) {
        return new KuartzResponse<>(companyService.get(id));
    }

    @Override
    public KuartzResponse<KzPage<CompanyModel>> getPage(@RequestBody CompanyQueryModel queryModel) {
        return new KuartzResponse<>(companyService.getPage(queryModel));
    }

    @Override
    public KuartzResponse<CompanyModel> saveUpdate(@RequestBody CompanyModel company) {
        return new KuartzResponse<>(companyService.saveUpdate(company));
    }
}
