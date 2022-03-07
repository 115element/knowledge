package com.example.lambda_flatmap_reduce;

import java.io.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamOther {

    public static void main(String[] args) throws FileNotFoundException {

        //1.1 使用Stream中的静态方法：of(),iterator(),generate()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> limit = Stream.iterate(0, x -> x + 2).limit(6);
        Stream<Double> limit1 = Stream.generate(Math::random).limit(2);


        //1.2 使用BufferedReader.lines()方法，将每行内容转成流
        BufferedReader reader = new BufferedReader(new FileReader("F:\\test.txt"));
        Stream<String> lines = reader.lines();

        //1.3 使用Pattern.splitAsStream()方法，将字符串分割成流
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");

        //1.4 使用sorted排序
        //sorted()：自然排序，流中元素需实现Comparable接口
        //sorted(Comparator com)：定制排序，自定义Comparator排序器
    }
}
