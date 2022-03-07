package com.example.jpacollege.jpa_advanced.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//@Cacheable
@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String name;
    private String age;
    private String gender;
}
