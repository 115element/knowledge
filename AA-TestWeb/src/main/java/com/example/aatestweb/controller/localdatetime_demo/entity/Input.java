package com.example.aatestweb.controller.localdatetime_demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *  注解@JsonFormat主要是后台到前台的时间格式的转换
 *
 *  注解@DataFormat主要是前后到后台的时间格式的转换
 */

@Accessors(chain = true)
@Data
public class Input {
    private String id;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime localTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;
}
