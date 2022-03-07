package com.example.onerequestcount.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_user")
@EntityListeners(AuditingEntityListener.class) //同样的从该类的注释也可以了解到该类的作用：这是一个JPA Entity Listener，用于捕获监听信息，当Entity发生持久化和更新操作时。
public class User implements Serializable {

    @Id
    private Long id;

    private String name;

    private String city;
}