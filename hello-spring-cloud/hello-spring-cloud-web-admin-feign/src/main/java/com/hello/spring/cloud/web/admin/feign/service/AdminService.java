package com.hello.spring.cloud.web.admin.feign.service;

import com.hello.spring.cloud.web.admin.feign.requesheaderproblem.MyRequestInterceptor;
import com.hello.spring.cloud.web.admin.feign.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-spring-cloud-service-admin",
        fallback = AdminServiceHystrix.class,
        configuration = MyRequestInterceptor.class) //为了被调用方可以获取到请求头

//value标识出服务提供者
//fallback = AdminServiceHystrix.class [增加Feign熔断器]
public interface AdminService {

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);
}
