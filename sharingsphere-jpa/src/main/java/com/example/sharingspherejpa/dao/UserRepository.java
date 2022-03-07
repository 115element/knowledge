package com.example.sharingspherejpa.dao;

import com.example.sharingspherejpa.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
