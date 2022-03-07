package com.example.jpacollege.jpa.repo;

import com.example.jpacollege.jpa.entity.integer_type.IntegerDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IntRepository extends JpaRepository<IntegerDemo,Integer>, JpaSpecificationExecutor<IntegerDemo> {
}
