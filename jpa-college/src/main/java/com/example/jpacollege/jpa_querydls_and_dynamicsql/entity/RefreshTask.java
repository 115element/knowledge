package com.example.jpacollege.jpa_querydls_and_dynamicsql.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "t_refresh_task")
public class RefreshTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String actionType;//任务类型 url或dir
    private Date startTime;
    private Date endTime;
    private int status;     //任务状态 0成功 1失败，2进行中，3其他
    private String custom;  //所属客户

    @Transient
    private List<Map<String, String>> urlList;  //刷新的url及状态
    @Transient
    private List<RefreshError> refreshErrors;   //刷新异常url

    public RefreshTask() {}

    public RefreshTask(String actionType, Date startTime, int status, String custom) {
        this.actionType = actionType;
        this.startTime = startTime;
        this.status = status;
        this.custom = custom;
    }
}
