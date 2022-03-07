package com.example.seata3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apple")
public class AppleController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/reduce")
    public String reduceAmount() {
        int update = jdbcTemplate.update("update t_apple set amount = amount - 1 where id = 1");
        int i = 1/0;
        return "success";
    }

}
