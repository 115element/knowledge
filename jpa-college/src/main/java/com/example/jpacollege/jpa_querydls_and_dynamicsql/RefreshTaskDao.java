package com.example.jpacollege.jpa_querydls_and_dynamicsql;

import com.example.jpacollege.jpa_querydls_and_dynamicsql.entity.RefreshTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Set;

/*
 * QueryDSL简介,QueryDsl通过maven配置，和JPAQueryFactory这个类，可以实现实体Bean自动生成。
 *
 * 然后就可以-使用以下用法：
 * queryFactory.select(qBlogInfo)
 *         .from(qBlogInfo)
 *         .where(qBlogInfo.id.eq(1)) 相当于 select blogTitle from blog_Info where id = 1;
 *
 * QueryDSL仅仅是一个通用的查询框架，专注于通过Java API构建类型安全的SQL查询。
 * Querydsl可以通过一组通用的查询API为用户构建出适合不同类型ORM框架或者是SQL的查询语句，也就是说QueryDSL是基于各种ORM框架以及SQL之上的一个通用的查询框架。
 * 借助QueryDSL可以在任何支持的ORM框架或者SQL平台上以一种通用的API方式来构建查询。目前QueryDSL支持的平台包括JPA,JDO,SQL,Java Collections,RDF,Lucene,Hibernate Search。
 * 官网地址:http://querydsl.com/static/querydsl/4.1.3/reference/html_single/
 */

public interface RefreshTaskDao extends JpaRepository<RefreshTask, Integer>/*, QuerydslPredicateExecutor<RefreshTask>*/ {


    // IF是一个函数，语法：IF(expr1,expr2,expr3)
    // 如果 expr1 是TRUE (expr1 <> 0 and expr1 <> NULL)，则 IF()的返回值为expr2; 否则返回值则为 expr3。
    // COALESCE是一个函数， (expression_1, expression_2, ..., expression_n)依次参考各参数表达式，
    // 遇到非null值即停止并返回该值。如果所有的表达式都是空值，最终将返回一个空值
    @Query(nativeQuery = true, value = "select * from t_refresh_task where if(coalesce(?1) is not null, id in (?1), 1=1) " +
            "and if(?2 is not null, custom=?2, 1=1) " +
            "and if(?3 is not null, action_type=?3, 1=1) " +
            "and if(?4 is not null, start_time between ?4 and ?5, 1=1) " +
            "order by start_time desc ")
    public List<RefreshTask> findByIdIn(Set<Long> id, String custom, String actionType, String startTime, String endTime);
}
