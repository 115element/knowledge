package com.example.seata2.controller;

import io.seata.core.context.RootContext;
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

@RestController
@RequestMapping("good")
public class GoodController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/reduce")
    public String reduceAmount() {
        int update = jdbcTemplate.update("update t_good set amount = amount - 1 where id = 1");

        //TODO 经过实验，超过两个组件的链式调用，第三个组件的分布式事务不会生效，必须由第二个组件，手动的向第三个组件传递事务id，那么第三个组件的事务才会生效
        HttpEntity<String> httpEntity = new HttpEntity<>("123", buildHeaders());
        val responseEntity = restTemplate.exchange("http://localhost:8084/apple-service/apple/reduce", HttpMethod.GET, httpEntity, String.class);
        return "success";
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
