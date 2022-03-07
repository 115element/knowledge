package com.example.mongodbcollege;

import com.example.mongodbcollege.dao.MongoDao;
import com.example.mongodbcollege.entity.MongoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MongodbCollegeApplicationTests {

    @Autowired
    private MongoDao mtdao;


    @Test
    public void saveTest() throws Exception {
        MongoTest mgtest = new MongoTest();
        mgtest.setId(111);
        mgtest.setAge(33);
        mgtest.setName("ceshi");
        mtdao.saveTest(mgtest);
    }

    @Test
    public void findTestByName() {
        MongoTest mgtest = mtdao.findTestByName("ceshi");
        System.out.println("mgtest is " + mgtest);
    }

    @Test
    public void updateTest() {
        MongoTest mgtest = new MongoTest();
        mgtest.setId(11);
        mgtest.setAge(44);
        mgtest.setName("ceshi2");
        mtdao.updateTest(mgtest);
    }

    @Test
    public void deleteTestById() {
        mtdao.deleteTestById(11);
    }

    @Test
    public void findAll(){
        List<MongoTest> all = mtdao.findAll();
        System.out.println(all);
    }


    //聚合操作
    @Test
    public void aggregationTest(){
        int aggregation = mtdao.aggregation();
        System.out.println(aggregation);
    }
}
