package com.example.json.fastjson_filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class FastJsonTest {


    public static String jsonString = "{\n" +
            "  \"store\": {\n" +
            "    \"book\": [\n" +
            "      {\n" +
            "        \"category\": \"reference\",\n" +
            "        \"author\": \"Nigel Rees\",\n" +
            "        \"title\": \"Sayings of the Century\",\n" +
            "        \"price\": 8.95\n" +
            "      },\n" +
            "      {\n" +
            "        \"category\": \"fiction\",\n" +
            "        \"author\": \"Evelyn Waugh\",\n" +
            "        \"title\": \"Sword of Honour\",\n" +
            "        \"price\": 12.99\n" +
            "      }\n" +
            "    ],\n" +
            "    \"bicycle\": {\n" +
            "      \"color\": \"red\",\n" +
            "      \"price\": 19.95\n" +
            "    }\n" +
            "  },\n" +
            "  \"expensive\": 10\n" +
            "}";


    public static void main(String[] args) {
        fastJ();
        levelJ();
    }


    //需求：需要过滤掉其中 "book" 的 "price" 属性。
    public static void fastJ() {
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("price");
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String s = JSON.toJSONString(jsonObject, filter);
        System.out.println(s);
        //查看 JSON 数据的过滤结果，发现 "bicycle" 中的 "price" 属性也被过滤掉了，不符合需求
    }



    //该自定义过滤器实现 PropertyPreFilter 接口，实现根据层级过滤 JSON 数据中的属性。
    public static void levelJ() {
        JSONObject jsonObject = JSON.parseObject(jsonString);
        LevelPropertyPreFilter propertyPreFilter = new LevelPropertyPreFilter();
        propertyPreFilter.addExcludes("store.book.price");
        String json2 = JSON.toJSONString(jsonObject, propertyPreFilter);
        System.out.println(json2);
    }
}
