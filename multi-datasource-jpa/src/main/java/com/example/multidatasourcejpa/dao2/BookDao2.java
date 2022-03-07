package com.example.multidatasourcejpa.dao2;

import com.example.multidatasourcejpa.bean2.Book2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao2 extends JpaRepository<Book2, Integer> {
}
