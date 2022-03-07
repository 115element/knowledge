package com.example.jpacollege.jpa.repo;

import com.example.jpacollege.jpa.entity.local_date_time.LocalDateTimeCollege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocalDateTimeRepository extends JpaRepository<LocalDateTimeCollege,Integer>, JpaSpecificationExecutor<LocalDateTimeCollege> {
}
