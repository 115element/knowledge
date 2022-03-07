package com.example.jpacollege;

import com.example.jpacollege.jpa.entity.onetomany.Customer;
import com.example.jpacollege.jpa.repo.CustomerRepository;
import com.example.jpacollege.jpa_advanced.entity.User;
import com.example.jpacollege.jpa_advanced.repo.UserAdvancedDao;
import com.example.jpacollege.jpa_advanced.service.UserAdvancedService;
import com.example.jpacollege.jpa_advanced.service.UserNativeSqlQueryService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class JpaCollegeApplicationTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void contextLoads() {
        val x = customerRepository.findById(1).orElse(null);
        if (x == null) return;
        System.out.println(x); //①
        x.setAge(50);
        customerRepository.save(x);
        // System.out.println(save);
        System.out.println(x); //②

        //TODO Jpa的一个知识点
        /**
         * 根据id从数据库查询出一个实体X，
         * 然后修改这个实体x并保存，
         * 那么原来的指向x的属性，
         * 会变成新的已保存的值。
         */
    }

    @Test
    void test() {
        Customer customer = new Customer();
        customer.setAge(10);
        customer.setLastName("alex");
        customer.setBirth(new Date());
        customer.setEmail("123.com");
        customer.setCreatedTime(new Date());
        val save = customerRepository.save(customer);
        System.out.println(save.getId()); //2  可以获取ID
    }


    @Autowired
    UserNativeSqlQueryService userNativeQueryService;

    @Test
    void ttLink() {
        userNativeQueryService.unionQuery();
        userNativeQueryService.joinQuery();
    }

    @Test
    void tt() {
        userNativeQueryService.testNativeQuery();
        userNativeQueryService.testNativeQueryMap();
    }


    @Autowired
    UserAdvancedService userAdvancedService;

    @Test
    void ttt() {
        userAdvancedService.nativeSql();
        userAdvancedService.jpqlSql();
        User user = new User();
        user.setId(1L);
        user.setName("213");
        userAdvancedService.list(user);
    }


    @Autowired
    private UserAdvancedDao userAdvancedDao;

    @Test
    public void dynamicQuery1(){
        List<User> users1 = userAdvancedDao.dynamicQuery(null, null);
        System.out.println(users1);

        List<User> users2 = userAdvancedDao.dynamicQuery("nv", null);
        System.out.println(users2);
    }
}
