package com.example.jpacollege.return_custom_entity.model;

import java.math.BigDecimal;

/**
 * Jpa返回自定义Model的用法
 * 1.定义接口，接口方法对应返回值
 */

public interface Other {
    long getTimestamp();
    BigDecimal getBandWidth();
    BigDecimal getFlow();
}
