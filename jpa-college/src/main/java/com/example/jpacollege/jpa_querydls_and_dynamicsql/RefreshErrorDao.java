package com.example.jpacollege.jpa_querydls_and_dynamicsql;

import com.example.jpacollege.jpa_querydls_and_dynamicsql.entity.vo.JpaReq;
import com.example.jpacollege.jpa_querydls_and_dynamicsql.entity.RefreshError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public interface RefreshErrorDao extends JpaRepository<RefreshError, Long> {


    //TODO nativeQuery 动态SQL
    @Query(nativeQuery = true, value = "select * from t_refresh_error e where if(?2!=2, e.process_state=?2, 1=1) and if(?1!=0, action_id=?1, 1=1)")
    public List<RefreshError> query(long actionId, int processState);

    //模糊查询,参数是时间
    @Query(nativeQuery = true, value = "select * from t_refresh_error where "
            + "provider in (:list) "
            + "and IF (:from is not null AND :to is not null , start_time BETWEEN :from AND :to , 1 = 1) "
    )
    public List<RefreshError> portalSearch(
            @Param("list") List<String> list,
            @Param("from") Date from,
            @Param("to") Date to
    );


    // @Query()参数设置
    // ?x  和  :XXX不能混用
    // CONCAT函数,连接字符串
    // 在JPA查询中转义冒号':'
    @Query(nativeQuery = true, value = "select * from t_zone_ns_synch where "
            + "`name` LIKE CONCAT('%',:#{#re.zone},'%') "
            + " and `ttl` LIKE CONCAT('%',:#{#re.ttl},'%') "
            + " and `dname` LIKE CONCAT('%',:#{#re.value},'%') "
            + " and `status` in (:#{#re.statusList}) order by modify_time"
    )
    public List<RefreshError> search(@Param("re") JpaReq re);


    @Query(nativeQuery = true, value = "select * from t_refresh_error where action_id=?1 and provider=?2")
    public List<RefreshError> findByActionId(long actionId, String provider);


    @Modifying
    @Transactional(rollbackFor = SQLException.class)
    @Query(nativeQuery = true, value = "update t_refresh_error set process_state=1 where action_id=?1 and provider=?2")
    public void update(long actionId, String provider);


/*

@Query()参数设置
?x  和   :XX不能混用
在JPA查询中转义冒号':'

#stu.age        表示取stu的age属性。
#{#stu.age}     表示取stu的age属性的值。

@Modifying
@Query(value = "update Student s set s.name = :#{#stu.name}, s.age = :#{#stu.age}, " +
        "s.alias = :#{#stu.alias} where s.id = :#{#stu.id}")
int updatePayState2(@Param("stu") Student stu);

*/

}
