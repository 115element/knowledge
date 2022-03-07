package com.example.logmonitor.daoaccess;


import com.example.logmonitor.entityaccess.AccessKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface AccessKeyDao extends JpaRepository<AccessKey,Long> {

    @Query(nativeQuery = true, value = "SELECT id, access_key_id,access_key_secret  FROM  `t_user_secret`  WHERE account in (SELECT custom FROM  cloudflat.`t_domain_info` WHERE `name`=?1)")
    AccessKey finByAccess(String domain);

}