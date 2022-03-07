package com.example.aatestweb.controller.localdatetime_demo;


import com.example.aatestweb.controller.localdatetime_demo.entity.Output;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class LocalDateTimeOutputController {

    //http://localhost:8080/a1
    @GetMapping("a1")
    @ResponseBody
    public Output a1() {
        return new Output()
                .setId("1")
                .setLocalTime(LocalTime.now())
                .setLocalDate(LocalDate.now())
                .setLocalDateTime(LocalDateTime.now());
    }

//    {
//      "id": "1",
//      "localTime": "19:08:24",
//      "localDate": "2021-07-29",
//      "localDateTime": "2021-07-29 19:08:24"
//    }
}
