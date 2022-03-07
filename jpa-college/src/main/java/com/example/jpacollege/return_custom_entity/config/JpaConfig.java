package com.example.jpacollege.return_custom_entity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import javax.annotation.PostConstruct;

/**
 * 将自定义的Jpa转换器，添加到Jpa框架中
 */

@Configuration
public class JpaConfig {

    @PostConstruct
    public void init() {
        GenericConversionService genericConversionService = (GenericConversionService) DefaultConversionService.getSharedInstance();
        genericConversionService.addConverter(new JpaConvert());
    }
}
