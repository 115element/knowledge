package com.example.jpacollege.jpa_advanced.service;

import com.example.jpacollege.jpa_advanced.entity.User;
import com.example.jpacollege.jpa_advanced.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.sql.Timestamp;


/**
 * Root root，代表了可以查询和操作的实体对象的根，通过 get(“属性名”) 来获取对应的值。
 * CriteriaQuery query，代表一个 specification 的顶层查询对象，它包含着查询的各个部分，比如 select 、from、where、group by、order by 等。
 * CriteriaBuilder cb，来构建 CriteriaQuery 的构建器对象，其实就相当于条件或者是条件组合，并以 Predicate 的形式返回
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    //分页查询
    public void t1() {
        int pageNum = 1;  //页码最小为1
        int pageSize = 10;//每页几条

        Sort sort = Sort.by(Sort.Direction.DESC, "age");
        Pageable pageable = PageRequest.of(pageNum - 1, 10, sort);
        userDao.findAll(pageable);
    }

    public void t2() {
        userDao.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //1.获取比较的属性，查询式的属性名，不是表的字段名
                Path<Object> name = root.get("sheId");
                //2.构造查询条件：select * from t_user where she_id = 3;

                /**
                 * 第一个参数：需要比较的属性(Path对象)
                 * 第二个参数：当前需要比较的值
                 */
                Predicate predicate = criteriaBuilder.equal(name, 3);//进行精准的匹配（比较的属性，比较属性的取值）

                return predicate;
            }
        });
    }

    public void t3() {
        /**
         * root：获取属性
         *  1.客户名
         *  2.所属行业
         *
         * cb：构造查询
         *  1.构造客户名的精准匹配查询
         *  2.构造所属行业的精准匹配查询
         *  3.将以上两个查询关联起来
         */
        userDao.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Expression<String> customerName = root.get("customerName").as(String.class); //客户名
                Expression<String> customerAddress = root.get("customerAddress").as(String.class); //地址

                //构造查询
                //1.构造客户名的精准查询
                Predicate p1 = criteriaBuilder.equal(customerName, "黑马");
                //2.构造客户地址的精准匹配
                Predicate p2 = criteriaBuilder.equal(customerAddress, "上海");

                //3.将多个查询条件组合到一起，组合(满足条件1并且满足条件2，与关系；满足条件1或满足条件2，或关系)
                Predicate and = criteriaBuilder.and(p1, p2);
                //以与的形式拼接多个查询条件
                //cb.or(); //以或的形式拼接多个查询条件

                return and;
            }
        });
    }


    public void t4() {
        userDao.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Expression<String> customerName = root.get("customerName").as(String.class); //客户名

                //构造模糊查询条件
                Predicate like = criteriaBuilder.like(customerName, "%黑马%");

                return like;
            }
        });
    }

    public void t5(String title, Timestamp registerTime) {
        userDao.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Predicate condition1 = null;
                if (title != null) {
                    condition1 = criteriaBuilder.like(root.get("title"), "%" + title + "%");
                } else {
                    condition1 = criteriaBuilder.like(root.get("title"), "%%");
                }

                Predicate condition2 = null;
                if (registerTime != null) {
                    condition2 = criteriaBuilder.greaterThan(root.get("registerTime"), registerTime);
                } else {
                    condition2 = criteriaBuilder.greaterThan(root.get("registerTime"), new Timestamp(155555555L));
                }

                //方式1(使用CriteriaQuery)
                //Predicate conditionX = criteriaBuilder.and(condition1, condition2);
                //criteriaQuery.where(conditionX);

                //方式2(使用CriteriaQuery)
                criteriaQuery.where(condition1, condition2);

                return null; //这种方式使用JPA的API设置了查询条件，所以不需要再返回查询条件Predicate给Spring Data Jpa，故最后return null；
            }
        });
    }


    //多个Specification组合查询
    public void t6() {
        Specification<User> specification1 = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Expression<String> customerName = root.get("name").as(String.class);
                Predicate like = criteriaBuilder.like(customerName, "%黑马%");
                return like;
            }
        };

        Specification<User> specification2 = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Expression<String> age = root.get("age").as(String.class);
                Predicate like = criteriaBuilder.like(age, "zhang");
                return like;
            }
        };

        Specification<User> specification3 = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Expression<String> gender = root.get("gender").as(String.class);
                Predicate like = criteriaBuilder.like(gender, "女");
                criteriaQuery.where(like);
                return null;
            }
        };

        Specification<User> spec = specification1.and(specification2).or(specification3);

        userDao.findAll(spec);
    }
}
