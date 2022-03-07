package com.example.onerequestcount.controller;

import com.example.onerequestcount.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NController {


    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/s")
    public String s(){
        for (int i = 0; i < 3; i++) {
            userRepository.findAll();
        }
        return "s";
    }

    @GetMapping(value = "/s1")
    public String s1(){
        for (int i = 0; i < 4; i++) {
            userRepository.findAll();
        }
        return "s1";
    }
}
