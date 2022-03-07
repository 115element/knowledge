package com.example.jpacollege;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
public class JpaCollegeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaCollegeApplication.class, args);
    }




    ////JPAQueryFactory的作用是结合Pom.xml中配置的maven插件来一起使用的。
    @Bean
    @Autowired
    public JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
//     <!--[[maven插件]]用以生成querydsl辅助类：Q开头的entity-->
//            <plugin>
//                <groupId>com.mysema.maven</groupId>
//                <artifactId>apt-maven-plugin</artifactId>
//                <version>1.1.3</version>
//                <executions>
//                    <execution>
//                        <goals>
//                            <goal>process</goal>
//                        </goals>
//                        <configuration>
//                            <!--执行mvn clean compile，生成的代码位置-->
//                            <outputDirectory>target/generated-sources/java</outputDirectory>
//                            <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
//                        </configuration>
//                    </execution>
//                </executions>
//            </plugin>
}
