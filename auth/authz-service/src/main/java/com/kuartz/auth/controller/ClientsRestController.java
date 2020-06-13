package com.kuartz.auth.controller;

import com.kuartz.auth.service.KuartzClientDetailsService;
import com.kuartz.core.auth.client.ClientsRestService;
import com.kuartz.core.auth.dto.ClientModel;
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
