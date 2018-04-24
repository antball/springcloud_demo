package com.cloud.demo.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface ServiceApi {

    @GetMapping("/hello")
    String consumer();
}
