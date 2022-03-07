package com.example.logmonitor.controll;


import com.example.logmonitor.impl.LogMonitoringImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/stat")
public class GatewayController {

    @Autowired
    LogMonitoringImpl logMonitoring;


    //http://127.0.0.1:9111/api/v1/stat/test02
    @GetMapping("/test02")
    public void test() throws Exception {
        logMonitoring.findname();
    }


}





