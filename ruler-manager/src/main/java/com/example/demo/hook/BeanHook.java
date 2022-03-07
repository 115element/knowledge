package com.example.demo.hook;

import com.example.demo.jpa.repo.RulerTemplateRepository;
import com.example.demo.ruler.RulerManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Getter
@Component
@RequiredArgsConstructor
public class BeanHook {

    private final ApplicationContext applicationContext;
    private final EntityManager entityManager;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    private final RulerTemplateRepository rulerTemplateRepository;
    private final RulerManager rulerManager;

    public static BeanHook SELF;

    /*从Spring Boot 2.6.0版本起,默认禁止了循环引用的结果*/
    //@Lazy
    @Autowired
    public void setSelf(BeanHook self) {
        SELF = self;
    }

    public static BeanHook self() {
        return SELF;
    }

    @Modifying
    @Transactional
    public void entityManager_remove(Object object) {
        entityManager.remove(object);
    }

    @Modifying
    @Transactional
    public <T> T entityManager_merge(T t) {
        return entityManager.merge(t);
    }
}
