package com.example.demo.jpa.repo;

import com.example.demo.jpa.entity.RulerTemplate;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface RulerTemplateRepository extends JpaRepositoryImplementation<RulerTemplate, Long> {

    Optional<RulerTemplate> findByName(String name);
}
