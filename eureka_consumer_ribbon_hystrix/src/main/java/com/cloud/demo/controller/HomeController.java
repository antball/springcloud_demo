package com.cloud.demo.controller;

import com.cloud.demo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String dc() {
//        return restTemplate.getForObject("http://localhost:2001/"+"hello", String.class);
//        return restTemplate.getForObject("http://eureka-client/hello", String.class);
        return consumerService.consumer();
    }



}
