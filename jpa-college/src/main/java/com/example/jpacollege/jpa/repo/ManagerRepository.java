package com.example.jpacollege.jpa.repo;

import com.example.jpacollege.jpa.entity.onetoone.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
}
