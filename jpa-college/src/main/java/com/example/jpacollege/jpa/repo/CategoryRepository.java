package com.example.jpacollege.jpa.repo;

import com.example.jpacollege.jpa.entity.manytomany.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
