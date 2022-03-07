package com.example.demo;

import com.example.demo.jpa.entity.Alert;
import com.example.demo.jpa.entity.Banner;
import com.example.demo.jpa.entity.RulerTemplate;
import com.example.demo.jpa.repo.AlertRepository;
import com.example.demo.jpa.repo.BannerRepository;
import com.example.demo.jpa.repo.RulerTemplateRepository;
import com.example.demo.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

/**
 * RulerManager用法
 */

@SpringBootApplication
public class RulerManagerApplication {

    //--从Spring Boot 2.6.0版本起,默认禁止了循环引用--
    public static void main(String[] args) {
        //SpringApplication.run(RulerManagerApplication.class, args);
        new SpringApplicationBuilder(RulerManagerApplication.class)
                .allowCircularReferences(true) // 允许循环引用
                .run(args);
    }


    @Autowired
    private AlertRepository alertRepository; //①每条记录中存了一个规则模板名字,标识要使用该规则
    @Autowired
    private BannerRepository bannerRepository; //②每条记录中存了一个规则模板名字,标识要使用该规则
    @Autowired
    private RulerTemplateRepository rulerTemplateRepository; //③定义规则模板

    @PostConstruct
    public void initDataBase() {
        RulerTemplate rulerTemplate1 = new RulerTemplate();
        rulerTemplate1.setName("n1");
        rulerTemplate1.setContent("is_cust_type_zq | in_g5_root_pkg_config | date_between(2020,2021)");
        rulerTemplateRepository.save(rulerTemplate1);

        RulerTemplate rulerTemplate2 = new RulerTemplate();
        rulerTemplate2.setName("n2");
        rulerTemplate2.setContent("offer_id_contains_one_of | has_tag_one_of | date_between(2020,2021)");
        rulerTemplateRepository.save(rulerTemplate2);

        Alert alert = new Alert();
        alert.setName("弹窗1");
        alert.setImg("图片1");
        alert.setPriority(1);
        alert.setRulers("{n1}"); //必须要写{},因为程序里使用该括号处理，n1对应上边定义的规则模板
        alertRepository.save(alert);

        Banner banner = new Banner();
        banner.setName("弹窗1");
        banner.setImg("图片1");
        banner.setPriority(1);
        banner.setRulers("{n2}"); //必须要写{},因为程序里使用该括号处理，n2对应上边定义的规则模板
        bannerRepository.save(banner);
    }
}
