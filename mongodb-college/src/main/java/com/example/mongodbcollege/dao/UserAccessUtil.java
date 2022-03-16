package com.example.mongodbcollege.dao;


import com.example.mongodbcollege.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserAccessUtil {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     */
    public void saveTest(User test) {
        mongoTemplate.save(test);
    }

    /**
     * 根据用户名查对象
     *
     * @param name
     * @return
     */
    public User findTestByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        User mgt = mongoTemplate.findOne(query, User.class);
        return mgt;
    }

    public void updateTest(User test) {
        Query query = new Query(Criteria.where("id").is(test.getId()));
        Update update = new Update().set("age", test.getAge()).set("name", test.getName());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, User.class);
        //更新查询返回结果集的所有
        //mongoTemplate.updateMulti(query,update,MongoTest.class);
    }

    /**
     * 删除对象
     *
     * @param id
     */
    public void deleteTestById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }


    /**
     * 查询所有数据
     *
     * @return
     */
    public List<User> findAll() {
        List<User> all = mongoTemplate.findAll(User.class);
        return all;
    }


    /**
     * 这里我们介绍一下聚合框架中常用的几个操作：
     * <p>
     * $project：修改输入文档的结构。可以用来重命名、增加或删除域，也可以用于创建计算结果以及嵌套文档。
     * $match：用于过滤数据，只输出符合条件的文档。$match使用MongoDB的标准查询操作。
     * $limit：用来限制MongoDB聚合管道返回的文档数。
     * $skip：在聚合管道中跳过指定数量的文档，并返回余下的文档。
     * $unwind：将文档中的某一个数组类型字段拆分成多条，每条包含数组中的一个值。
     * $group：将集合中的文档分组，可用于统计结果。
     * $sort：将输入文档排序后输出。
     * $geoNear：输出接近某一地理位置的有序文档。
     */
    public int aggregation() {
        //封装查询条件
        List<AggregationOperation> operations = new ArrayList<>();
        //operations.add(Aggregation.match(Criteria.where("name").is("alex")));
        operations.add(Aggregation.group("id").sum("age").as("age"));
        Aggregation aggregation = Aggregation.newAggregation(operations);

        //MongoDB中聚合(aggregate)主要用于处理数据(诸如统计平均值,求和等)，并返回计算后的数据结果。有点类似sql语句中的 count(*)。
        AggregationResults<User> aggregate = mongoTemplate.aggregate(aggregation, "mongoTest", User.class);
        Integer ageSum = aggregate.getUniqueMappedResult().getAge();
        return ageSum; //77
    }


    public void aggregation1() {
        Aggregation agg = Aggregation.newAggregation(
                // 第一步：挑选所需的字段，类似select *，*所代表的字段内容
                Aggregation.project("begin", "end", "userId", "distance"),
                // 第二步：sql where 语句筛选符合条件的记录
                //Aggregation.match(Criteria.where("userId").is(map.get("userId"))),
                // 第三步：分组条件，设置分组字段
                Aggregation.group("userId").sum("distance").as("distance"),
                // 第四部：排序（根据某字段排序 倒序）
                Aggregation.sort(Sort.Direction.DESC, "distance"),
                // 第五步：数量(分页)
                Aggregation.limit(5),
                // 第刘步：重新挑选字段
                Aggregation.project("userId", "distance")
        );
        AggregationResults<User> results = mongoTemplate.aggregate(agg, "collectionName", User.class);
        List<User> mappedResults = results.getMappedResults();
    }
}
