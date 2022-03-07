package com.example.jpacollege.jpa.repo;

import com.example.jpacollege.jpa.entity.onetomany.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
