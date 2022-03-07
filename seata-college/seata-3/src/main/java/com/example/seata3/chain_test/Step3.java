package com.example.seata3.chain_test;


import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("step3")
@RestController
public class Step3 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public String reduceAmount() {

        log.error("(STEP3)事务id：" + RootContext.getXID());

        jdbcTemplate.update("update t_apple set amount = amount - 1 where id = 1");
        int i = 1/0;
        return "success";
    }
}
