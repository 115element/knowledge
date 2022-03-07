package com.example;

import com.alibaba.fastjson.JSONObject;
import lombok.val;

public class JsonPrinciple {

    public JsonPrinciple() {
        System.out.println("构造方法调用");
    }

    private String s;

    public String getS() {
        System.out.println("get方法调用...");
        return s;
    }

    public void setS(String s) {
        System.out.println("set方法调用...");
        this.s = s;
    }

    public static void main(String[] args) {
        final JsonPrinciple a = new JsonPrinciple();
        a.setS("哈哈");

        System.out.println("=======================================[json序列化,会调用get方法]");
        val s = JSONObject.toJSONString(a);
        System.out.println("json序列化值："+s);

        System.out.println("=======================================[json反序列化,会调用构造方法，以及set方法]");
        JSONObject jsonObject = JSONObject.parseObject(s);
        val a1 = JSONObject.toJavaObject(jsonObject, JsonPrinciple.class);
        System.out.println("json反序列化值："+a1);
    }
}
