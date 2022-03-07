package com.example.multidatasourcejpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.multidatasourcejpa.dao2", //Jpa接口所在包
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBean2",
        transactionManagerRef = "platformTransactionManager2")
public class JpaConfig2 {

    @Autowired
    @Qualifier("dsTwo")
    private DataSource dsTwo;

    @Autowired
    private JpaProperties jpaProperties;

    //①为了解决JPA多数据源时,大小写转换问题,牛逼
    @Autowired
    private HibernateProperties hibernateProperties;

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean2(EntityManagerFactoryBuilder builder) {

        //②可以解决JPA多数据源时,驼峰转换下划线不生效问题,牛逼
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());

        return builder.dataSource(dsTwo)
                .properties(properties)
                .persistenceUnit("persistenceUnit2")
                .packages("com.example.multidatasourcejpa.bean2") //Jpa实体所在包
                .build();
    }


    @Bean
    public PlatformTransactionManager platformTransactionManager2(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean2(builder).getObject()));
    }
}
