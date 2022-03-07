package com.example.onerequestcount;

import com.example.onerequestcount.dao.UserRepository;
import com.example.onerequestcount.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OnerequestcountApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        System.out.println("123");
        List<User> all = userRepository.findAll();
        System.out.println(all);
    }

}
