package com.cloud.demo.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(description = "测试源服务API接口")
@RestController
public class MainController {

    @Autowired
    DiscoveryClient discoveryClient;

    @ApiOperation(value = "加法", notes = "加法")
    @GetMapping("/hello")
    public String dc()  throws InterruptedException {
//        Thread.sleep(5000L);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }



    @ApiOperation(value = "加法", notes = "加法")
    @GetMapping("/add")
    public Integer add(Integer a, Integer b){
        return a + b;
    }


//    @Api() 用于类；表示标识这个类是swagger的资源
//    tags–表示说明
//    value–也是说明，可以使用tags替代
//
//    @ApiOperation() 用于方法；表示一个http请求的操作
//            value用于方法描述
//    notes用于提示内容
//
//
//    @ApiParam() 用于方法，参数，字段说明；表示对参数的添加元数据（说明或是否必填等）
//    name–参数名
//    value–参数说明
//    required–是否必填
//
//    @ApiModel()用于类 ；表示对类进行说明，用于参数用实体类接收
//    value–表示对象名
//
//    @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
//    value–字段说明
//    name–重写属性名字
//    dataType–重写属性类型
//    required–是否必填
//    example–举例说明
//    hidden–隐藏
//
//    @ApiImplicitParam() 用于方法
//    表示单独的请求参数
//
//    @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
//    name–参数ming
//    value–参数说明
//    dataType–数据类型
//    paramType–参数类型
//    example–举例说明
//
//    @ApiIgnore
//    作用于方法上，使用这个注解swagger将忽略这个接口



}
