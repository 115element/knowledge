package com.example.demo.usecontroller;


import com.example.demo.service.AlertService;
import com.example.demo.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 使用规则模板
 */

@Slf4j
@RestController
public class UseController {


    @Autowired
    private AlertService alertService;
    @Autowired
    private BannerService bannerService;


    @GetMapping("/getAlert")
    public String getAlert() {
        alertService.getAlert().ifPresent(alert -> {
                    System.out.println(alert.getName());
                    System.out.println(alert.getImg());
                }
        );
        return "演示Ruler用法";
    }


    @GetMapping("/getBanner")
    public String getBanner() {
        bannerService.getBanner().ifPresent(banner -> {
                    System.out.println(banner.getName());
                    System.out.println(banner.getImg());
                }
        );
        return "演示Ruler用法";
    }
}
