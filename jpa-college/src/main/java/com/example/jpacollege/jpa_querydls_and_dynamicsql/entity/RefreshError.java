package com.example.jpacollege.jpa_querydls_and_dynamicsql.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;


@Data
@Entity
@Table(name = "t_refresh_error")
public class RefreshError {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long actionId;  //主任务id
    private String provider;
    private String taskId;
    private int status;     //刷新错误状态:  1.推送失败 2.推送接口不通 3.查询失败 4.查询接口不通
    private String errorUrl;//失败的url或dir
    private int processState = 0;//操作状态，0未操作，1已操作，2操作中
    private Date createDate;//错误消息创建时间
    private Date startTime;//错误消息创建时间

    @Transient
    private Set<String> urls;
}