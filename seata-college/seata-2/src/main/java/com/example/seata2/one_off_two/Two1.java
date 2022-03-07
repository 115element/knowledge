package com.example.seata2.one_off_two;


import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("two1")
@RestController
public class Two1 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //验证Seata一个应用连续调用另外两个应用时，只要一个应用出现问题，三个都确实会回滚。
    @GetMapping("")
    public String reduceAmount() {
        log.error("(TWO1)事务id：{}", RootContext.getXID());

        jdbcTemplate.update("update t_good set amount = amount - 1 where id = 1");
        return "success";
    }

}
