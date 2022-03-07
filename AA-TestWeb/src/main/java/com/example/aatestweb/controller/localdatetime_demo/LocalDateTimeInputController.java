package com.example.aatestweb.controller.localdatetime_demo;

import com.example.aatestweb.controller.localdatetime_demo.entity.Input;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 使用LocalDateTime、LocalDate、LocalTime，接收前端参数。
 */

@Controller
public class LocalDateTimeInputController {


    //http://localhost:8080/a?l=11:11:11
    @GetMapping(value = "a")
    @ResponseBody
    public String a(@DateTimeFormat(pattern = "HH:mm:ss") LocalTime l) {
        return l.toString();
    }


    //http://localhost:8080/b?l=2021-07-29
    @GetMapping(value = "b")
    @ResponseBody
    public String b(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate l) {
        return l.toString();
    }


    //http://localhost:8080/c?l=2021-07-29 11:11:11
    @GetMapping(value = "c")
    @ResponseBody
    public String c(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime l) {
        return l.toString();
    }


    /**
     * 基础知识介绍：
     * HTTP 1.1标准中没有规定GET方法是否可以有请求体，因此GET方法也可以带请求体，完全符合标准。
     * elasticsearch中就是用GET方法的请求体传递搜索条件。为了兼容性考虑，elasticsearch也接受POST方法+请求体的搜索方式。
     */
    //TODO 后台实体方式，前端GET请求
    //http://localhost:8080/d?id=1&localTime=17:16:01&localDate=2021-07-29&localDateTime=2021-07-29 17:16:01
    @GetMapping(value = "d")
    @ResponseBody
    public String d(Input input) {
        return input.toString();
    }



    //设置请求体为 {"id":"1","localDate":"2021-07-29","localDateTime":"2021-07-29T17:16:01","localTime":"17:16:01"}
    //注意：localDateTime的时间中必须有T，否则将会转换失败。
    //解决此问题方法
    /**
     * 1.依赖添加
     *  <dependency>
     *       <groupId>com.fasterxml.jackson.datatype</groupId>
     *       <artifactId>jackson-datatype-jsr310</artifactId>
     *       <version>2.9.7</version>
     *  </dependency>
     * 2.修改jackson反序列化方式
     *  @Bean
     *  public ObjectMapper serializingObjectMapper() {
     *      JavaTimeModule module = new JavaTimeModule();
     *      LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
     *      module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
     *      ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
     *              .modules(module)
     *              .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
     *              .build();
     *      return objectMapper;
     *  }
     */
    @PostMapping(value = "f")
    @ResponseBody
    public String f(@RequestBody Input input) {
        return input.toString();
    }
}
