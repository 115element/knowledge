package com.example.demo.usecontroller;

import com.example.demo.jpa.entity.RulerTemplate;
import com.example.demo.service.RulerTemplateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 创建规则模板
 */

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("rulerTemplate")
public class RulerTemplateController {

    private final RulerTemplateService service;

    @GetMapping({"list", "index", "*", ""})
    public List<RulerTemplate> list(RulerTemplate rulerTemplate,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss") LocalDateTime startTime,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss") LocalDateTime endTime) {
        log.debug("rulerTemplate:{}", rulerTemplate);
        log.debug("startTime:{}", startTime);
        log.debug("endTime:{}", endTime);
        return service.list(rulerTemplate, startTime, endTime);
    }

    @GetMapping("show/{id}")
    public RulerTemplate show(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @PostMapping("create")
    public RulerTemplate create(RulerTemplate rulerTemplate) {
        return service.save(rulerTemplate);
    }
}