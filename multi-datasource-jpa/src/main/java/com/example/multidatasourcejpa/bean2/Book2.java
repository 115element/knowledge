package com.example.multidatasourcejpa.bean2;

import javax.persistence.*;

@Entity(name = "t_book")
public class Book2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    //@Column(name = "to_upper_case") //TODO 为了解决JPA多数据源，驼峰处理失效问题，此方式可以解决，已找到更好的解决方式(请看配置①②③)
    private String toUpperCase;


    @Override
    public String toString() {
        return "Book2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", toUpperCase='" + toUpperCase + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getToUpperCase() {
        return toUpperCase;
    }

    public void setToUpperCase(String toUpperCase) {
        this.toUpperCase = toUpperCase;
    }
}


