package com.example.logmonitor.dao;

import com.example.logmonitor.entity.DomainClouldflat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DomainDao  extends JpaRepository<DomainClouldflat,Long> {

    @Query(nativeQuery = true ,value = "SELECT name  FROM t_domain_info where custom in (SELECT account FROM shiro.account where parent = '400' or id = '400' or id = '403')and status = '1'")
    List findAllDomain();

}
