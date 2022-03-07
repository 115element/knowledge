package com.example.jpacollege.jpa_example.service;


import com.example.jpacollege.jpa_example.entity.Person;
import com.example.jpacollege.jpa_example.repo.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    //演示Probe用法。   probe v. 调查，打探，探究；
    public void t1() {
        Person person = new Person();
        person.setAge("x");

        Example<Person> example = Example.of(person);

        List<Person> all = personDao.findAll(example);
        System.out.println(all);
        /**
         * Hibernate:
         *     select
         *         person0_.id as id1_10_,
         *         person0_.age as age2_10_,
         *         person0_.first_name as first_na3_10_,
         *         person0_.gender as gender4_10_,
         *         person0_.name as name5_10_
         *     from
         *         t_person person0_
         *     where
         *         person0_.age=?
         *
         *  可以发现，试用Example查询，默认情况下会忽略空值，官方文档也有说明：
         *
         *  This is a simple domain object. You can use it to create an Example.
         *  By default, fields having null values are ignored, and strings are matched using the store specific defaults.
         *  Examples can be built by either using the of factory method or by using ExampleMatcher. Example is immutable.
         */
    }

    //自定义匹配器规则
    public void ttt() {
        Person person = new Person();
        person.setFirstName("x");
        person.setName("x");
        person.setAge("x");

        ExampleMatcher matcher = ExampleMatcher.matching()
                //模糊查询匹配开头，即{first_name}%
                .withMatcher("first_name", ExampleMatcher.GenericPropertyMatchers.startsWith())
                ////全部模糊查询，即%{name}%
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                //忽略字段，既不管age是什么值都不加入查询条件
                .withIgnorePaths("age");
        Example<Person> example = Example.of(person, matcher);
        List<Person> peoples = personDao.findAll(example);
        System.out.println(peoples);
        /**
         * Hibernate:
         *     select
         *         person0_.id as id1_10_,
         *         person0_.age as age2_10_,
         *         person0_.first_name as first_na3_10_,
         *         person0_.gender as gender4_10_,
         *         person0_.name as name5_10_
         *     from
         *         t_person person0_
         *     where
         *         (
         *             person0_.name like ? escape ?
         *         )
         *         and person0_.first_name=?
         */
    }


    //官方创建ExampleMatcher例子（1.8 lambda）
    public void t2() {
        Person person = new Person();
        person.setFirstName("x");
        person.setName("x");
        person.setAge("x");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("first_name", match -> match.endsWith())
                .withMatcher("age", match -> match.startsWith());

        Example<Person> example = Example.of(person, matcher);
        List<Person> peoples = personDao.findAll(example);
        System.out.println(peoples);

        /**
         * Hibernate:
         *     select
         *         person0_.id as id1_10_,
         *         person0_.age as age2_10_,
         *         person0_.first_name as first_na3_10_,
         *         person0_.gender as gender4_10_,
         *         person0_.name as name5_10_
         *     from
         *         t_person person0_
         *     where
         *         (
         *             person0_.age like ? escape ?
         *         )
         *         and person0_.first_name=?
         *         and person0_.name=?
         */
    }


//    StringMatcher 参数
//    Matching	                        生成的语句	                                    说明
//-------------------------------------------------------------------------------------------------------------
//    DEFAULT (case-sensitive)	        firstname = ?0	                                默认（大小写敏感）
//    DEFAULT (case-insensitive)	    LOWER(firstname) = LOWER(?0)	                默认（忽略大小写）
//    EXACT (case-sensitive)	        firstname = ?0	                                精确匹配（大小写敏感）
//    EXACT (case-insensitive)	        LOWER(firstname) = LOWER(?0)	                精确匹配（忽略大小写）
//    STARTING (case-sensitive)	        firstname like ?0 + ‘%’	                        前缀匹配（大小写敏感）
//    STARTING (case-insensitive)	    LOWER(firstname) like LOWER(?0) + ‘%’	        前缀匹配（忽略大小写）
//    ENDING (case-sensitive)	        firstname like ‘%’ + ?0	                        后缀匹配（大小写敏感）
//    ENDING (case-insensitive)	        LOWER(firstname) like ‘%’ + LOWER(?0)	        后缀匹配（忽略大小写）
//    CONTAINING (case-sensitive)	    firstname like ‘%’ + ?0 + ‘%’	                模糊查询（大小写敏感）
//    CONTAINING (case-insensitive)	    LOWER(firstname) like ‘%’ + LOWER(?0) + ‘%’	    模糊查询（忽略大小写）
//-------------------------------------------------------------------------------------------------------------
// 说明：
// 1. 在默认情况下（没有调用withIgnoreCase()）都是大小写敏感的。
// 2. api之中还有个regex，但是我在mysql下测试报错，不了解具体作用。
// 3. 用Example查询，默认情况下会忽略空值。 所以在model类里面的字段不要写基本数据类型，应该写包装类型。
}
