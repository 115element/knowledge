package com.example.mdc1college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
/**
 * 在SpringBootApplication上使用@ServletComponentScan注解后，
 * Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册
 */
public class Mdc1CollegeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mdc1CollegeApplication.class, args);
    }

}
