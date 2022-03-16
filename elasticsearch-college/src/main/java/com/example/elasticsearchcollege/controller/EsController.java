package com.example.elasticsearchcollege.controller;


import com.example.elasticsearchcollege.service.EsService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class EsController {

    @Autowired
    EsService esService;

    @SneakyThrows
    @GetMapping(value = "create")
    public String createIndex() throws IOException {
        esService.insert();
        return "ok";
    }


    @SneakyThrows
    @GetMapping(value = "search")
    public String searchIndex() throws IOException {
        esService.searchIndex();
        return "ok";
    }


}
