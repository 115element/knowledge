package com.example.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

/**
 * 跨域配置
 *
 * C - Cross
 * O - Origin
 * R - Resource
 * S - Sharing
 */
@Configuration
public class CrossConfig {

    @Bean
    public CorsFilter corsFilter(){

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); //设置是否支持cookie跨域
        config.setAllowedOrigins(Collections.singletonList("*")); //原始域  例如：http:www.a.com
        config.setAllowedHeaders(Collections.singletonList("*")); //头
        config.setAllowedMethods(Collections.singletonList("*")); //请求方法
        config.setMaxAge(300L); //在几秒内，不在执行跨域检查

        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }
}
