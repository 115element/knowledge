package com.example.demo.jpa.entity;

import com.example.demo.ruler.Rulered;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_banner")
public class Banner implements Rulered {

    private static final long serialVersionUID = -7768338277585538696L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String img;
    private Integer priority; //优先级
    private String rulers; // 规则名集合，以英文逗号(,)分隔,支持英文感叹号取反

}
