package com.cloud.demo.controller;

import com.cloud.demo.api.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    ServiceApi serviceApi;

    @GetMapping("/consumer")
    public String dc() {
        return serviceApi.consumer();
    }



}
