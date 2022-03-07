package com.example.code.map_new;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void test1() {
        Map<String, String> map1 = new HashMap();
        map1.put("1","1");
        map1.put("2","2");
        map1.put("3","3");

        Map<String, String> map2 = new HashMap();
        map2.put("4","4");
        map2.put("5","5");

        /**
         * 只需返回新值即可覆盖旧值： (old, new) -> new
         * 只需返回旧值即可保留旧值：(old, new) -> old
         * 以某种方式合并两者，例如：(old, new) -> old + new
         * 甚至删除旧值：(old, new) -> null
         */
        map1.merge("3", "3", (v1, v2) -> v1+v2);
        System.out.println(map1); //{1=1, 2=2, 3=33}
    }

    @Test
    public void test2(){
        //创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 重新计算鞋子打了10%折扣后的值
        int newPrice = prices.compute("Shoes", (key, value) -> value - value * 10/100);
        System.out.println("Discounted Price of Shoes: " + newPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);
    }


    @Test
    public void test3(){
        //创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 重新计算鞋子打了10%折扣后的值
        // 方法的字面意思为：如果存在就进行compute(计算)
        int newPrice = prices.computeIfPresent("Shoes", (key, value) -> value - value * 10/100);
        System.out.println("Discounted Price of Shoes: " + newPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);
    }

    @Test
    public void test4(){
        Map<String, String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");

        // java8之前。从map中根据key获取value操作可能会有下面的操作
        String value = map.get("key");
        if (value == null) {
            map.put("key", "value");
            System.out.println(map);
        }

        // java8之后。上面的操作可以简化为一行，
        // 若key对应的value为空,会将第二个参数的返回值存入,并返回
        String value1 = map.computeIfAbsent("key1", k -> "value1");
        System.out.println(map);
        System.out.println(value1);
    }

    @Test
    public void test5(){
        // 创建一个 HashMap
        HashMap<Integer, String> sites = new HashMap<>();

        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        System.out.println("sites HashMap: " + sites);

        // 替换key为2的映射
        String value = sites.replace(2, "Wiki");

        System.out.println("Replaced Value: " + value);
        System.out.println("Updated HashMap: " + sites);
    }


    @Test
    public void test6(){
        // 创建一个 HashMap
        HashMap<Integer, String> sites = new HashMap<>();

        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        System.out.println("sites HashMap: " + sites);

        // 替换key为2的映射
        boolean value = sites.replace(2, "Runoob","SSS");
        System.out.println("Replaced Result: " + value);
        System.out.println("Updated HashMap: " + sites);
    }


    @Test
    public void test7(){
        Map<String,Integer> m = new HashMap<>();

        m.put("zhangsan", 19);
        m.put("lisi", 49);
        m.put("wangwu", 19);
        m.put("lisi",20);
        m.put("hanmeimei", null);
        System.out.println(m);

        //移除指定key
        System.out.println(m.remove("wangwu"));
        System.out.println(m);

        //移除指定key,value
        boolean list = m.remove("lisi", 20);
        System.out.println(list);

        //获取指定key的值，如果不存在返回默认值
        Integer orDefault = m.getOrDefault("kkkkk", 11111);
        System.out.println(orDefault);
    }
}
