package com.example.jpacollege.return_custom_entity.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;


@Data
@ToString
@NoArgsConstructor
public class UserName implements UserNameInterface {
    BigDecimal flow;
    BigDecimal bandWidth;
}
