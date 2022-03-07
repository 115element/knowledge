package com.example.json.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

//前两天我在处理业务的时候遇到一个问题，需要在定义好的实体类中动态添加一些客户自定义的字段，序列化为 JSON 字符串返回给前端使用。

public class DynamicPropagationField {


    /*
在 getCustomFields 方法上添加 @JsonAnyGetter 注解，在 setCustomFields 方法上添加 @JsonAnySetter，
这样不管是序列化为 JSON 字符串还是反序列化为 Java 对象都可以实现了。

需要注意 setCustomFields 方法的参数，不能是 customFields 字段，因为前端传过来的 JSON 字符串中没有这个字段，
所以只能提供两个参数 key 和 value，反序列化时，Jackson 会自动把自定义的属性添加到 customFields 字段中。
     */
    public static class Student {
        private String id;
        private String name;
        private Map<String, String> customFields = new HashMap<>();

        @JsonAnyGetter
        public Map<String, String> getCustomFields() {
            return customFields;
        }

        @JsonAnySetter
        public void setCustomFields(String key, String value) {
            this.customFields.put(key, value);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) throws JsonProcessingException {
        Student student = new Student();
        ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        student.setId("1");
        student.setName("张三");
        student.setCustomFields("age", "12");
        student.setCustomFields("address", "suzhou");
        String jsonStr = OBJECT_MAPPER.writeValueAsString(student);
        System.out.println(jsonStr);
        //{"id":"1","name":"张三","address":"suzhou","age":"12"}

        Student student1 = OBJECT_MAPPER.readValue(jsonStr, Student.class);
        Map<String, String> customFields = student1.getCustomFields();
        for(Map.Entry<String, String> entry : customFields.entrySet()) {
            System.out.println("key: "+ entry.getKey() + ", value: " + entry.getValue());
            //key: address, value: suzhou
            //key: age, value: 12
        }
    }

}
