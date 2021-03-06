package com.example.order.converter;

import com.example.order.dataobject.OrderDetail;
import com.example.order.dto.OrderDto;
import com.example.order.enums.ResultEnum;
import com.example.order.exception.OrderException;
import com.example.order.from.OrderFrom;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;

import java.util.List;

/**
 * Gson转换工具
 */
public class OrderForm2OrderDtoConverter {

    private static Logger log;

    public static OrderDto convert(OrderFrom orderFrom) {
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderFrom.getName());
        orderDto.setBuyerPhone(orderFrom.getPhone());
        orderDto.setBuyerAddress(orderFrom.getAddress());
        orderDto.setBuyerOpenid(orderFrom.getOpenid());

        List<OrderDetail> orderDetailList;

        Gson gson = new Gson();
        try {
            //第一个参数字符串，第二个参数是你要转换的类型
            orderDetailList = gson.fromJson(orderFrom.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("【json转换】错误，string={}", orderFrom.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }

        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }
}
