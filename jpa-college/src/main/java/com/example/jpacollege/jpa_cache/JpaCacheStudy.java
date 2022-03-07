package com.example.jpacollege.jpa_cache;

import com.example.jpacollege.jpa_advanced.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class JpaCacheStudy {

    /**
     * #如何开启JPA一级缓存？
     * hibernate-jpa默认开启一级缓存，jpa的一级缓存是针对于EntityManager，即同个EntityManager实例，
     * 如果不进行事务提交，那么查询的结果会有缓存，而我们平时使用@transaction开启事务，
     * 实际上开启的事务是注册到spring容器上下文创建的EntityManager实例（下面会说明），
     * 并不是我在config类中创建的EntityManager实例，所以使用config类中的EntityManager实例去查询数据会一直有缓存。
     */


    /**
     * #如何开启二级缓存？
     * application.properties配置文件中新增以下配置(并引入EhCache的pom坐标)：
     * #开启二级缓存
     * spring.jpa.properties.hibernate.cache.use_second_level_cache=true
     * spring.jpa.properties.cache.use_query_cache=true
     * #表示，在指定实体上增加@Cacheable时，该类才会被二级缓存
     * spring.jpa.properties.javax.persistence.sharedCache.mode=ENABLE_SELECTIVE
     * #指定缓存provider
     * spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.EhCacheRegionFactory
     *
     *
     * @Entity
     * @Table(name = "students")
     * @Cacheable(true) //添加Cacheable
     * @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "entityCache") //添加Cache
     * public class Students {}
     */

    @Autowired
    private EntityManagerFactory entityManagerFactory;



    //TODO 此方法只会发送一次SQL查询语句，因为使用的是同一个EntityManager。
    public void testFirstLevelCache1() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user1 = entityManager.find(User.class, 1L);
        User user2 = entityManager.find(User.class, 1L);
        System.out.println("演示一级缓存...");
    }


    //TODO 如果开启二级缓存，并在User类上，添加@Cacheable注解，此方法只发送一条SQL语句。否则发送两次SQL语句。
    public void testFirstLevelCache2() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user1 = entityManager.find(User.class, 1L);
        entityManager.close();
        entityManager = entityManagerFactory.createEntityManager();
        User user2 = entityManager.find(User.class, 1L);
        System.out.println("演示二级缓存...");
    }

}
