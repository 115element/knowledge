package com.example.jpacollege.return_custom_entity.model;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class Other1 {

    BigDecimal flow;
    BigDecimal bandWidth;

    public Other1(BigDecimal flow, BigDecimal bandWidth) {
        this.flow = flow;
        this.bandWidth = bandWidth;
    }
}
