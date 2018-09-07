package com.cloud.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: huangsj
 * @Date: 2018/9/6 20:03
 * @Description:
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
//        return restTemplate.getForObject("http://eureka-client/dc", String.class);
        //需要打开服务提供方的线程等待时间查看效果
        return restTemplate.getForObject("http://eureka-client/hello", String.class);
    }

    public String fallback() {
        return "fallback";
    }

}
