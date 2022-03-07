package com.example.seata1.controller;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


//使用注解开启分布式事务时，若要求事务回滚，必须将异常抛出到事务的发起方，
//被事务发起方的 @GlobalTransactional 注解感知到。provide 直接抛出异常，
//或定义错误码由 consumer 判断再抛出异常。

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/reduce")
    //只需在全局事务发起方增加此注解，被调用方无需增加该注解。
    @GlobalTransactional(name = "TestName", timeoutMills = 60000, rollbackFor = Exception.class)
    public String reduceAccount() {
        int update = jdbcTemplate.update("update t_user set account = account - 1 where id = 1");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8083/good-service/good/reduce", String.class);
        log.info("接口返回:{}", forEntity);
        return forEntity.getBody();
    }

}
