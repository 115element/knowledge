package com.example.multidatasourcejpa.service;


import com.example.multidatasourcejpa.dao1.BookDao1;
import com.example.multidatasourcejpa.dao2.BookDao2;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MultiTestService {

    @Autowired
    private BookDao1 bookDao1;
    @Autowired
    private BookDao2 bookDao2;


    //value值表示指定事务管理器
    @Transactional(value = "platformTransactionManager1")
    public void operationDatabaseOne(){
        val all = bookDao1.findAll();
        System.out.println("指定使用的事务管理器(操作库1)");
    }


    @Transactional(value = "platformTransactionManager2")
    public void operationDatabaseTwo(){
        val all = bookDao2.findAll();
        System.out.println("指定使用的事务管理器(操作库2)");
    }

}
