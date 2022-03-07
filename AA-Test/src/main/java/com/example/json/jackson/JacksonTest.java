package com.example.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

    public static String json1 = "{\n" +
            "  \"employee\": {\n" +
            "    \"id\": \"1212\",\n" +
            "    \"fullName\": \"John Miles\",\n" +
            "    \"age\": 34\n" +
            "  }\n" +
            "}";

    public static String json2 = "{\n" +
            "  \"employee\": {\n" +
            "    \"id\": \"1212\",\n" +
            "    \"age\": 34,\n" +
            "    \"fullName\": \"John Miles\"\n" +
            "  }\n" +
            "}";

    public static void main(String[] args) throws JsonProcessingException {
        equalsJson();
    }


    //比较两个json是否相同,虽然两个json字符串中的内容顺序不同，但是二者依然是相同的
    public static void equalsJson() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        JsonNode jsonNode1 = om.readTree(json1);
        JsonNode jsonNode2 = om.readTree(json2);
        System.out.println(jsonNode1.equals(jsonNode2));
    }


    //使用自定义比较器1
    public static void eqDiy1() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        NumericNodeComparator cmp = new NumericNodeComparator();
        JsonNode jsonNode1 = om.readTree(json1);
        JsonNode jsonNode2 = om.readTree(json2);
        System.out.println(jsonNode1.equals(cmp, jsonNode2));
    }

    //使用自定义比较器2
    public static void eqDiy2() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        TextNodeComparator tnc = new TextNodeComparator();
        JsonNode jsonNode1 = om.readTree(json1);
        JsonNode jsonNode2 = om.readTree(json2);
        System.out.println(jsonNode1.equals(tnc, jsonNode2));
    }
}
