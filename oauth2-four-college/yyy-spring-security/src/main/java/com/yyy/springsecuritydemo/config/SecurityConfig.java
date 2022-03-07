package com.yyy.springsecuritydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security 命名空间的引入可以简化我们的开发，它涵盖了大部分 Spring Security 常用的功能。
 * 它的设计是基于框架内大范围的依赖的，可以被划分为以下几块。
 * <p>
 * Web/Http 安全：这是最复杂的部分。通过建立 filter 和相关的 service bean 来实现框架的认证机制。
 * 当访问受保护的 URL 时会将用户引入登录界面或者是错误提示界面。业务对象或者方法的安全：控制方法访问权限的。
 * <p>
 * AuthenticationManager：处理来自于框架其他部分的认证请求。
 * <p>
 * AccessDecisionManager：为Web或方法的安全提供访问决策。会注册一个默认的，但是我们也可以通过普通 bean 注册的方式使用自定义的 AccessDecisionManager。
 * <p>
 * AuthenticationProvider：AuthenticationManager 是通过它来认证用户的。
 * <p>
 * UserDetailsService：跟 AuthenticationProvider 关系密切，用来获取用户信息的。
 */


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public CustomAuthenticationProvider authProvider() {
        return new CustomAuthenticationProvider(userDetailsService, passwordEncoder());
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider());
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略拦截
        //如果某一个请求地址不需要拦截的话，有两种方式实现：
        //①设置该地址匿名访问。
        //②直接过滤掉该地址，即该地址不走Spring Security过滤器链。
        web.ignoring().antMatchers("/verbose");
    }

    //安全拦截机制(最重要)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //开启登录配置
                .antMatchers("/r/r1").hasAuthority("p1")     //访问/r/r1，需要具有权限p1
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //定义登录页面，未登录时，访问一个需要登录之后才能访问的接口，会自动跳转到该页面
                .defaultSuccessUrl("/hello") //默认登录成功后跳转的页面
                .permitAll()
                .and()
                .logout()
                .permitAll()
                //关闭CSRF
                .and()
                .csrf()
                .disable();
        /**
         * authenticated()表示在执行该请求时，必须已经登录了应用。如果用户没有认证时，
         * permitAll()方法允许请求没有任何的安全限制。
         * 我们还可以使用hasRole()方法，它会自动适应“ROLE_”前缀
         */
        http.formLogin().failureHandler(authenticationFailureHandler);// 自定义认证失败处理器-非必须
        http.formLogin().successHandler(authenticationSuccessHandler);// 自定义认证成功处理器-非必须
    }

    @Autowired
    private AuthenticationFailureHandlerImpl authenticationFailureHandler;
    @Autowired
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandler;


    @Bean
    public PasswordEncoder passwordEncoder() {
        //BCryptPasswordEncoder强哈希+盐+密钥 (自带加盐功能，省去了加盐的烦恼)
        return new BCryptPasswordEncoder();
    }


}
