package com.kuartz.api.auth.controller;

import com.kuartz.api.auth.client.ClientsRestService;
import com.kuartz.api.auth.dto.ClientModel;
import com.kuartz.api.auth.service.KuartzClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${kuartz.client.authzClient.clientsService.path}")
public class ClientsRestController implements ClientsRestService {

    @Autowired
    private KuartzClientDetailsService detailsService;

    @Override
    public void save(@RequestBody ClientModel model) {
        detailsService.save(model);
    }
}
