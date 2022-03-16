package com.example.mongodbcollege.dao;

import com.example.mongodbcollege.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

//Mongodb Dao的另外一种用法
public interface UserDao extends PagingAndSortingRepository<User,Long> {
}
