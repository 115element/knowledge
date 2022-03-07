package com.example.demo.jpa.repo;

import com.example.demo.jpa.entity.Alert;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface AlertRepository extends JpaRepositoryImplementation<Alert,Long> {
}
