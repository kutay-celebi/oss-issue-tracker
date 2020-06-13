package com.kuartz.core.auth.client;

import com.kuartz.core.auth.dto.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "clientRestService",
        path = "${kuartz.client.authzClient.clientsService.path}",
        url = "${kuartz.client.authzClient.url}")
public interface ClientsRestService {

    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    void save(@RequestBody ClientModel model);

}