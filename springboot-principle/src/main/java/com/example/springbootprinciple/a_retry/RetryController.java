package com.example.springbootprinciple.a_retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryController {

    @Autowired
    RetryService retryService;


    @GetMapping("sss")
    public String sss() throws Exception {
        retryService.ss("aa", "bb");
        return "请求Retryable方法";
    }
}
