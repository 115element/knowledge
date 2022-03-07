package com.example.code.stringformat;

import org.junit.Test;

import java.time.LocalDateTime;

public class StringFormatChapter2 {

    //TODO %[argument_index$][flags][width][.precision]conversion

    /////////////////////////占位符////////////////////////
//    占位符完整格式为： %[index$][标识]*[最小宽度][.精度]转换符 。
//
//    针对不同数据类型的格式化，占位符的格式将有所裁剪。
//
//    % ，占位符的起始字符，若要在占位符内部使用%，则需要写成 %% 。
//
//    [argument_index$] ，位置索引从1开始计算，用于指定对索引相应的实参进行格式化并替换掉该占位符。
//
//    [flags] ，用于增强格式化能力，可同时使用多个 [标识] ，但某些标识是不能同时使用的。
//
//    [width] ，用于设置格式化后的字符串最小长度，若使用 [最小宽度] 而无设置 [标识] ，那么当字符串长度小于最小宽度时，则以左边补空格的方式凑够最小宽度。
//
//    [.precision] ，对于浮点数类型格式化使用，设置保留小数点后多少位。
//
//    conversion ，用于指定格式化的样式，和限制对应入参的数据类型。


    @Test
    public void t1() {
        String property = System.getProperty("line.separator"); //微软： \r\n
        System.out.println("--" + property + "--");
    }

    //日期格式化
    @Test
    public void t2(){
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = String.format("%tF", localDateTime); //2021-11-23
        System.out.println(format);
//        c，星期六 十月 27 14:21:20 CST 2007
//        F，2007-10-27
//        D，10/27/07
//        r，02:25:51 下午
//        T，14:28:16
//        R，14:28
//        b, 月份简称
//        B, 月份全称
//        a, 星期简称
//        A, 星期全称
//        C, 年前两位（不足两位补零）
//        y, 年后两位（不足两位补零）
//        j, 当年的第几天
//        m, 月份（不足两位补零）
//        d, 日期（不足两位补零）
//        e, 日期（不足两位不补零）

//        H, 24小时制的小时（不足两位补零）
//        k, 24小时制的小时（不足两位不补零）
//        I, 12小时制的小时（不足两位补零）
//        i, 12小时制的小时（不足两位不补零）
//        M, 分钟（不足两位补零）
//        S, 秒（不足两位补零）
//        L, 毫秒（不足三位补零）
//        N, 毫秒（不足9位补零）
//        p, 小写字母的上午或下午标记，如中文为“下午”，英文为pm
//        z, 相对于GMT的时区偏移量，如+0800
//        Z, 时区缩写，如CST
//        s, 自1970-1-1 00:00:00起经过的秒数
//        Q, 自1970-1-1 00:00:00起经过的豪秒

        String format1 = String.format("%tr", localDateTime);
        System.out.println(format1);

        String format2 = String.format("%tT", localDateTime);
        System.out.println(format2);

        String format3 = String.format("%tF", localDateTime);
        System.out.println(format3);
    }



}
