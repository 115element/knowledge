package com.example.lambda_flatmap_reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapStudy {

    public static void main(String[] args) {

        //TODO flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个新的流
        List<String> list = Arrays.asList("a,b,c", "1,2,3");

        Stream<String> stringStream = list.stream().flatMap(x -> {
            //将每一个元素转换成一个Stream
            String[] split = x.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        });

        stringStream.forEach(System.out::println);
        //a
        //b
        //c
        //1
        //2
        //3
    }
}
