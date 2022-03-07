package com.example.jpacollege.return_custom_entity.repo;

import com.example.jpacollege.return_custom_entity.entity.BandAndFlow;
import com.example.jpacollege.return_custom_entity.model.Other;
import com.example.jpacollege.return_custom_entity.model.Other1;
import com.example.jpacollege.return_custom_entity.model.UserName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

//TODO  演示返回自定义实体

public interface BandAndFlowRepo extends JpaRepository<BandAndFlow, Long> {


    //原生SQL
    //函数UNIX_TIMESTAMP(xx)，表示返回1970年到xx的毫秒值
    //注意：Other是接口，用法比较特殊。
    @Query(nativeQuery = true, value = "select UNIX_TIMESTAMP(record_time) as timestamp, sum(flow) as flow,sum(band_width) as bandwidth from t_band_and_flow")
    public List<Other> findByCriteria1();



    //使用HQL
    //注意使用的是Hql语句
    @Query("select NEW com.example.jpacollege.return_custom_entity.model.Other1(sum(bf.flow),sum(bf.bandWidth)) from BandAndFlow bf")
    public List<Other1> findByCriteria2();



    @Query(nativeQuery = true, value = "select UNIX_TIMESTAMP(record_time) as timestamp, sum(flow) as flow,sum(band_width) as bandwidth from t_band_and_flow")
    public Map findByCriteria3();



    @Query(nativeQuery = true, value = "select UNIX_TIMESTAMP(record_time) as timestamp, sum(flow) as flow,sum(band_width) as bandwidth from t_band_and_flow")
    public List<Object[]> findByCriteria4();



    //使用自定义转换器来解决返回自定义对象问题
    @Query(nativeQuery = true, value = "select sum(flow) as flow,sum(band_width) as bandwidth from t_band_and_flow")
    public UserName findByCriteria5();


    @Query(nativeQuery = true, value = "select sum(flow) from t_band_and_flow")
    public BigDecimal findByCriteria6();
}
