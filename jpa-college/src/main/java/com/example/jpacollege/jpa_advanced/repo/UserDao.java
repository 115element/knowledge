package com.example.jpacollege.jpa_advanced.repo;

import com.example.jpacollege.jpa_advanced.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//如果只需要简单的CRUD、分页、排序，则继承JpaRepository接口即可。
//如果还需要复杂查询，则可以再继承JpaSpecificationExecutor接口。
//当然，也可以直接继承JpaRepositoryImplementation接口。
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(value = "select * from user u where u.first_name = ?1", nativeQuery = true)
    Page<User> findByFirstName(String firstName, Pageable pageable);


    @Query("select u from User u where u.firstName = :firstName")
    Page<User> findByFirstNameJpql(@Param("firstName") String firstName, Pageable pageable);
}
