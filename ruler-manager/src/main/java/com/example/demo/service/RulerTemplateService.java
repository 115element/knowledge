package com.example.demo.service;


import com.example.demo.jpa.entity.RulerTemplate;
import com.example.demo.jpa.repo.RulerTemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class RulerTemplateService {

    @Autowired
    private RulerTemplateRepository repository;

    public List<RulerTemplate> list(RulerTemplate rulerTemplate, LocalDateTime startTime, LocalDateTime endTime) {
        return repository.findAll(Example.of(rulerTemplate));
    }

    public RulerTemplate findOne(long id) {
        return repository.findById(id).orElse(null);
    }

    public RulerTemplate save(RulerTemplate rulerTemplate) {
        log.debug("rulerTemplate=" + rulerTemplate);
        return RulerTemplate.repo().save(rulerTemplate);
    }

}