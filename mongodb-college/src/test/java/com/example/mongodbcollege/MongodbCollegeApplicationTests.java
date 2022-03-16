package com.example.mongodbcollege;

import com.example.mongodbcollege.dao.UserAccessUtil;
import com.example.mongodbcollege.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MongodbCollegeApplicationTests {

    @Autowired
    private UserAccessUtil userAccessUtil;


    @Test
    public void saveTest() throws Exception {
        User mgtest = new User();
        mgtest.setId(111L);
        mgtest.setAge(33);
        mgtest.setName("ceshi");
        userAccessUtil.saveTest(mgtest);
    }

    @Test
    public void findTestByName() {
        User mgtest = userAccessUtil.findTestByName("ceshi");
        System.out.println("mgtest is " + mgtest);
    }

    @Test
    public void updateTest() {
        User mgtest = new User();
        mgtest.setId(11L);
        mgtest.setAge(44);
        mgtest.setName("ceshi2");
        userAccessUtil.updateTest(mgtest);
    }

    @Test
    public void deleteTestById() {
        userAccessUtil.deleteTestById(11);
    }

    @Test
    public void findAll(){
        List<User> all = userAccessUtil.findAll();
        System.out.println(all);
    }


    //聚合操作
    @Test
    public void aggregationTest(){
        int aggregation = userAccessUtil.aggregation();
        System.out.println(aggregation);
    }
}
