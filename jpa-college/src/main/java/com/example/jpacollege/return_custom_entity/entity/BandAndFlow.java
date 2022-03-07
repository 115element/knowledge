package com.example.jpacollege.return_custom_entity.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "t_band_and_flow")
@Entity
public class BandAndFlow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDateTime recordTime;
    BigDecimal bandWidth;
    BigDecimal flow;
    String domain;
    String provider;
}
