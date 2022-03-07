package com.example.logmonitor.entity;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResultltFlow {

    private String domain;
    private BigDecimal cdnflow;
    private BigDecimal apiFlow;

}
