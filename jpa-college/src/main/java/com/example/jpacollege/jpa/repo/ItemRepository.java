package com.example.jpacollege.jpa.repo;

import com.example.jpacollege.jpa.entity.manytomany.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
