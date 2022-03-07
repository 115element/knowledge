package com.example.onerequestcount.dao;

import com.example.onerequestcount.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
