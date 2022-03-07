package com.example.seata1.one_off_two;


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

//使用注解开启分布式事务时，若要求事务回滚，必须将异常抛出到事务的发起方，
//被事务发起方的 @GlobalTransactional 注解感知到。provide 直接抛出异常，
//或定义错误码由 consumer 判断再抛出异常。

@Slf4j
@RequestMapping("one")
@RestController
public class One {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RestTemplate restTemplate;

    //验证Seata一个应用连续调用另外两个应用时，只要一个应用出现问题，三个都确实会回滚。
    @Global //此方式是：基于AOP手动控制
    @GetMapping("")
    public String reduceAccount() {
        log.error("(ONE)事务id：{}", RootContext.getXID());

        int update = jdbcTemplate.update("update t_user set account = account - 1 where id = 1");
        ResponseEntity<String> forEntity1 = restTemplate.getForEntity("http://localhost:8083/good-service/two1", String.class);
        ResponseEntity<String> forEntity2 = restTemplate.getForEntity("http://localhost:8084/apple-service/two2", String.class);
        return "!success";
    }

}
