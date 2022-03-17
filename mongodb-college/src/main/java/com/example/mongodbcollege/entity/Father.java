package com.example.mongodbcollege.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "father")
public class Father {
    private Long id;
    private String name;
    private Son son;
    private String[] colors;
}
