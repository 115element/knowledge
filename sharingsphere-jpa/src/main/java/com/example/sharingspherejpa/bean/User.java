package com.example.sharingspherejpa.bean;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/*
1. @MappedSupperclass注解
        (1) 该注解标注在类上，用来标识父类；
        (2) 该注解标识的类不能映射到数据库，被标识的类的属性必须通过子类来映射；
        (3) 该注解标识了类之后，不能再有@Entity和@Table注解标识该类
        (4) 标识有该注解的类，通常属性上用以下注解@Id @GeneratedVale(strategy=GenerationType.IDENTITY) 、
        @CreateDate 、 @CreateBy、@LastModifiedBy、@LastModifiedDate等注解用在父类上，子类基础该父类即可，
        并在子类标注@Table和@Entity
2.@EntityListeners(AuditingEntityListener.class)注解
        (1) 该注解用于监听实体类，在save、update之后的状态
        (2) 使用了@EntityListeners(AuditingEntityListener.class)之后，记得在Application
        启动类上加@EnableJpaAuditing，不然@CreateDate，@LastModifiedBy不生效
3.启用@EnableJpaAuditing，配置AuditorAware实现类
        (1)只有使用了@EnableJpaAuditing注解，@CreateDate @LastModifiedBy等注解才会生效；
        (2) 只有实现了AuditorAware接口，才会指定@CreateBy用户名信息。
*/

@Data
@Entity
@Table(name = "t_user")
@EntityListeners(AuditingEntityListener.class) //同样的从该类的注释也可以了解到该类的作用：这是一个JPA Entity Listener，用于捕获监听信息，当Entity发生持久化和更新操作时。
public class User implements Serializable {

    @Id
    private Long id;


    //@Column(name = "mobile")
    private String name;


    //@Column(name = "city")
    private String city;
}
