package com.example.seata1.chain_test;

import com.example.seata1.aop.Global;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@Slf4j
@RequestMapping("step1")
@RestController
public class Step1 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RestTemplate restTemplate;

    //验证Seata一个应用链式调用其它应用时，只要一个应用出现问题，那么该请求链上的所有应用都确实会回滚。
    @Global //此方式是：基于AOP手动控制
    @GetMapping("")
    public String reduceAccount() {
        log.error("(STEP1)事务id：" + RootContext.getXID());

        int update = jdbcTemplate.update("update t_user set account = account - 1 where id = 1");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8083/good-service/step2", String.class);
        log.info("接口返回:{}", forEntity);
        return forEntity.getBody();
    }

}
