package com.example.demo.service;


import com.example.demo.jpa.entity.Alert;
import com.example.demo.jpa.repo.AlertRepository;
import com.example.demo.ruler.Rulered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository alertRepository;

    public Optional<Alert> getAlert() {
        log.info("为{}推荐弹窗:", 123);
        return alertRepository.findAll()
                .stream()
                .filter(Rulered::match)
                .max(Comparator.comparing(Alert::getPriority)); //这一句相当于按照优先级排序
    }

}
