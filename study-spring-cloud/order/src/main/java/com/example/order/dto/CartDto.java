package com.example.order.dto;


public class CartDto {

    //商品id
    private String productId;
    //商品数量
    private Integer productQuantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    //无参数构造方法用于反序列化
    public CartDto(){}


    //假如你不写构造方法，java自带一个无参数构造方法，你写了这个构造方法，又加了@Data注解，它的无参构造方法就没了，所以会导致反序列化错误
    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
