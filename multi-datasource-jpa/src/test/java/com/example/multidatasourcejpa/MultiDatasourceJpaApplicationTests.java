package com.example.multidatasourcejpa;

import com.example.multidatasourcejpa.bean1.Book1;
import com.example.multidatasourcejpa.bean2.Book2;
import com.example.multidatasourcejpa.dao1.BookDao1;
import com.example.multidatasourcejpa.dao2.BookDao2;
import com.example.multidatasourcejpa.service.MultiTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MultiDatasourceJpaApplicationTests {

    @Autowired
    BookDao1 bookDao1;
    @Autowired
    BookDao2 bookDao2;

    @Test
    public void contextLoads() {
        List<Book1> all = bookDao1.findAll();
        System.out.println(all);
        List<Book2> all1 = bookDao2.findAll();
        System.out.println(all1);
    }


    @Autowired
    MultiTestService multiTestService;

    @Test
    public void t1(){
        multiTestService.operationDatabaseOne();
        multiTestService.operationDatabaseTwo();
    }
}
