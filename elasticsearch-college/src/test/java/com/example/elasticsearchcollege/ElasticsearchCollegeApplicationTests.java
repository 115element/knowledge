package com.example.elasticsearchcollege;

import com.example.elasticsearchcollege.dao.UserDocumentDao;
import com.example.elasticsearchcollege.document.UserDocument;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@SpringBootTest
class ElasticsearchCollegeApplicationTests {

    @Test
    void contextLoads() {
    }


    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Resource
    private UserDocumentDao userDocumentDao;

    @Test
    public void createIndex(){
        elasticsearchRestTemplate.indexOps(UserDocument.class).create();
        UserDocument user = new UserDocument();
        user.setId("123456");
        user.setUserName("test");
        UserDocument saveUser = userDocumentDao.save(user);
        Assert.notNull(saveUser,"数据为空");
        System.out.println(userDocumentDao.findById(user.getId()));
        elasticsearchRestTemplate.indexOps(UserDocument.class).delete();

    }
}
