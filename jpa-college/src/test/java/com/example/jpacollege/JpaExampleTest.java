package com.example.jpacollege;


import com.example.jpacollege.jpa_example.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//演示JPA，查询条件Example用法

@SpringBootTest
public class JpaExampleTest {

    @Autowired
    private PersonService personService;


    @Test
    public void t1(){
        personService.t1();
    }

    @Test
    public void tt(){
        personService.ttt();
    }

    @Test
    public void tt1(){
        personService.t2();
    }

}
