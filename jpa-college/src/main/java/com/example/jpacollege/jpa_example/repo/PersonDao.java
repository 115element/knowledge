package com.example.jpacollege.jpa_example.repo;

import com.example.jpacollege.jpa_example.entity.Person;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;


//如果只需要简单的CRUD、分页、排序，则继承JpaRepository接口即可。
//如果还需要复杂查询，则可以再继承JpaSpecificationExecutor接口。
//当然，也可以直接继承JpaRepositoryImplementation接口。
public interface PersonDao extends JpaRepositoryImplementation<Person, Long> {
}
