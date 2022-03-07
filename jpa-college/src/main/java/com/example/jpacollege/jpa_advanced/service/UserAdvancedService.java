package com.example.jpacollege.jpa_advanced.service;


import com.example.jpacollege.jpa_advanced.entity.User;
import com.example.jpacollege.jpa_advanced.repo.UserAdvancedDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserAdvancedService {

    @PersistenceContext
    private EntityManager em;

    //@PersistenceContext
    //private EntityManager em;
    //注入的是实体管理器，执行持久化操作的，如果单独使用Hibernate框架，也就是不使用SpringBoot，需要配置文件/META-INFO/persistence.xml。(这是规定)
    //注入一堆保存实体类状态的数据结构，针对实体类的不同状态(四种,managed或detached等)可以做出不同的反应(merge,persist等等)，
    //其实就是把数据从数据库里提出，然后在内存里处理的，再返回数据库的法则。

    //@Resource
    //private EntityManager em;
    //是注入容器提供的资源对象，比如SessionContext MessageDrivenContext。或者你那个name指定的JNDI对象
    //可以理解为资源->数据源->也就是数据连接，基本上就是告诉程序数据库在哪里

    /**
     * CriteriaBuilder 安全查询创建工厂，,创建CriteriaQuery，创建查询具体具体条件Predicate 等。
     * CriteriaBuilder是一个工厂对象,安全查询的开始.用于构建JPA安全查询.可以从EntityManager 或 EntityManagerFactory类中获得CriteriaBuilder。
     */
    public List<User> list(User user) {
        //获取查询工厂
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //获取查询类
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        //查询条件
        List<Predicate> predicates = new LinkedList<>();
        //查询条件设置
        predicates.add(cb.equal(userRoot.get("id"), user.getId()));
        predicates.add(cb.like(userRoot.get("name"), user.getName()));
        //拼接where查询
        query.where(cb.or(predicates.toArray(new Predicate[0])));
        //用JPA 2.0的TypedQuery进行查询
        TypedQuery<User> typedQuery = em.createQuery(query);
        List<User> resultList = typedQuery.getResultList();
        return resultList;
    }


    //TODO NativeSql查询语法
    //SQL是标准化的查询语言，用于管理数据。下面的例子说明了怎样实现本地SQL查询：
    public void nativeSql() {
        //1.建立SQl查询
        String sql = "select * from t_user u where u.first_name = ?1";
        //2.创建查询实例
        Query nativeQuery = em.createNativeQuery(sql, User.class);
        //3.设置查询参数
        nativeQuery.setParameter(1, "john");
        //获取结果
        List resultList = nativeQuery.getResultList();
        System.out.println(resultList);
    }


    //TODO JPQL查询用法
    //JPQL是基于字符串的查询语言，语法类似于SQL。因此学习JPQL相当容易，只要有一定的SQL基础。看下面的代码：
    public void jpqlSql() {
        //1.建立JPQL查询
        String jpqlSql = "SELECT u FROM User u WHERE u.firstName = :firstName";
        //2.创建查询实例
        TypedQuery<User> query = em.createQuery(jpqlSql, User.class);
        //3.设置查询参数
        query.setParameter("firstName", "john");
        //4.获取结果
        List<User> resultList = query.getResultList();
        System.out.println(resultList);
    }
}
