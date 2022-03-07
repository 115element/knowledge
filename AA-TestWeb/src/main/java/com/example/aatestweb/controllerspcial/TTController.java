package com.example.aatestweb.controllerspcial;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class TTController {


    @GetMapping("/t/t")
    public Object get(){
        return "演示响应统一包装处理";
    }
}
