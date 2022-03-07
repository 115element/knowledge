package com.example.jpacollege;


import com.example.jpacollege.jpa_advanced.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootTest
public class JpaCacheTests {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @BeforeEach
    public void before() {
        //Spring Boot项目中默认不写版本引入的JUnit依赖应该是JUnit5，在JUnit5中@Before 和@After 被 @BeforeEach 和@AfterEach给替代了. 还有一些其他的的注解也被替代了。
        System.out.println("before...");
    }


    //TODO 此方法只会发送一次SQL查询语句，因为使用的是同一个EntityManager。
    @Test
    public void testFirstLevelCache1() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user1 = entityManager.find(User.class, 1L);
        User user2 = entityManager.find(User.class, 1L);
        System.out.println("演示一级缓存...");
    }


    //TODO 如果开启二级缓存，并在User类上，添加@Cacheable注解，此方法只发送一条SQL语句。否则发送两次SQL语句。
    @Test
    public void testFirstLevelCache2() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user1 = entityManager.find(User.class, 1L);
        entityManager.close();
        entityManager = entityManagerFactory.createEntityManager();
        User user2 = entityManager.find(User.class, 1L);
        System.out.println("演示二级缓存...");
    }


    @AfterEach
    public void after() {
        //Spring Boot项目中默认不写版本引入的JUnit依赖应该是JUnit5，在JUnit5中@Before 和@After 被 @BeforeEach 和@AfterEach给替代了. 还有一些其他的的注解也被替代了。
        System.out.println("after...");
    }

}
