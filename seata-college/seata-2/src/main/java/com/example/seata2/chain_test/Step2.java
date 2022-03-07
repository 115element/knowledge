package com.example.seata2.chain_test;


import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequestMapping("step2")
@RestController
public class Step2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("")
    public String reduceAmount() {
        log.error("(STEP2)事务id：" + RootContext.getXID());

        jdbcTemplate.update("update t_good set amount = amount - 1 where id = 1");
        // TODO 经过实验：A发起分布式事务 -> 调用B -> B再调用C；
        // TODO 那么发现C得不到分布式事务id，C出错也不会回滚，所以需要B手动在请求头中添加A传递过来的事务id，传递给C，那么C就会回滚了。
        HttpEntity<String> httpEntity = new HttpEntity<>("123", buildHeaders());
        val responseEntity = restTemplate.exchange("http://localhost:8084/apple-service/step3", HttpMethod.GET, httpEntity, String.class);
        log.info("接口返回:{}", responseEntity.getBody());
        return responseEntity.getBody();
    }


    public HttpHeaders buildHeaders() {
        String xid = RootContext.getXID();
        HttpHeaders headers = new HttpHeaders();
        headers.add(RootContext.KEY_XID, xid);
        return headers;
    }
    /**
     * 通过上述基本原理，我们可以很容易理解：
     * 跨服务调用场景下的事务传播，本质上就是要把 XID 通过服务调用传递到服务提供方，并绑定到 RootContext 中去。
     * 只要能做到这点，理论上 Seata 可以支持任意的微服务框架。
     */

}
