package com.example.jpacollege.jpa_advanced.repo;

import com.example.jpacollege.jpa_advanced.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import java.util.List;


//如果只需要简单的CRUD、分页、排序，则继承JpaRepository接口即可。
//如果还需要复杂查询，则可以再继承JpaSpecificationExecutor接口。
//当然，也可以直接继承JpaRepositoryImplementation接口。
public interface UserAdvancedDao extends JpaRepositoryImplementation<User, Long> {


    //MySQL的IF既可以作为表达式用，也可在存储过程中作为流程控制语句使用，如下是做为表达式使用：
    @Query(nativeQuery = true, value = "SELECT * FROM `t_user` where "
            + "if(:gender is not null, gender = :gender, 1=1) "
            + "and if(:age is not null, age = :age, 1=1) "
            + "order by id desc")
    List<User> dynamicQuery(@Param("gender") String gender, @Param("age") String age);

}
