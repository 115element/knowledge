package com.example.code.stringformat;


import org.junit.Test;

/**
 * String.format()方法差不多讲完了,仔细看JDK文档也会慢慢了解的
 *
 * 需要批量进行格式化时,考虑下DateFormat,MessageFormat,NumberFormat 把他们封装成一个静态工具类或许更好
 *
 * 毕竟调用String.format()方法是会new一个Formatter对象,虽然有GC帮忙,但是平时编程的时候还是要考虑这些因素的
 *
 * 尽量少的创建对象,节省资源.
 */

public class StringFormatChapter1 {

    /////////////////////////占位符////////////////////////
//                    %[argument_index$][flags][width]conversion
//    占位符完整格式为： %[argument_index$][标识]*[最小宽度][.精度]转换符 。
//
//    针对不同数据类型的格式化，占位符的格式将有所裁剪。
//
//    % ，占位符的起始字符，若要在占位符内部使用%，则需要写成 %% 。
//
//    [argument_index$] ，位置索引从1开始计算，用于指定对索引相应的实参进行格式化并替换掉该占位符。
//
//    [flag] ，用于增强格式化能力，可同时使用多个 [标识] ，但某些标识是不能同时使用的。
//
//    [width] ，用于设置格式化后的字符串最小长度，若使用 [最小宽度] 而无设置 [标识] ，那么当字符串长度小于最小宽度时，则以左边补空格的方式凑够最小宽度。
//
//    [.precision] ，对于浮点数类型格式化使用，设置保留小数点后多少位。
//
//    转换符 ，用于指定格式化的样式，和限制对应入参的数据类型。


    //TODO [argument_index$] 用法。
    @Test
    public void t() {
        //这里会按顺序分别把小明,小方填入到对应的%s中. 如果我们要把小方填在前面,小明填在后面,那该怎么做呢,[argument_index$]就派上用场了
        //String.format("我叫%2$s,她叫%1$s", "小明","小方"); // 我叫小方,她叫小明
        //依然是百分号%开头,中间多了个2$,1$

        String format = String.format("%2$s %1$s", "111", "222");
        System.out.println(format);
    }


    //TODO [标识]
//    conversion可以填s,那还有什么其它字母可以填呢,当然有的比如
//
//    o:结果被格式化为八进制整数
//
//    x:结果被格式化为十六进制
//
//    d:结果被格式化为十进制整数
    //更多的conversion类别可以参考JDK文档java.util.Formatter类
    @Test
    public void t1() {
        //格式化数字为八进制
        String format = String.format("%o", 11);
        System.out.println(format);

        //格式化数字为十六进制
        String format1 = String.format("%x", 11);
        System.out.println(format1);
    }


//    flag是用来控制输出格式的,比如左对齐,金额用逗号隔开等
//
//    width:表示最小宽度
//
//    先看个列子:
//            String.format("%1$,d", 12302562); // 12,302,562
//
//    这里多出一个逗号",",它就是flag,用于金额千分位隔开,当然写成"%,d"也是可以的
//
//    再一个列子:
//            String.format("%1$08d", 123456);// 00123456
//
//    这里0就是flag,表示结果将用零来填充,8就是width,表示最少要8位,d是conversion
//
//            至于其它的flag可以查阅JDK文档

    @Test
    public void t2() {
        String format = String.format("%1$,d", 123025888);
        System.out.println(format);
    }

    @Test
    public void t3() {
        //注意：width 表示是最小宽度，不是最大宽度

        String format1 = String.format("%02d", 1);
        System.out.println(format1);// 01

        String format = String.format("%02d", 111);
        System.out.println(format); // 111
    }


    //    接下来说下[.precision]
//
//    这个单词翻译下是精度的意思,我们发现了前面有个小数点".",因此不难联想到这个是关于浮点数类型的
//
//            只有当传入的数据是浮点数时这个才有用,整数或者日期类型的数据都不能用
//
//    比如我想要四舍五入保留两位小数,那么我可以这么写:
//
//            String.format("%1$.2f", 12.12555);// 12.13
//
//    这里f表示传入的数字是浮点型,如果传入的是整数,或者把f改成d都会抛出异常,JDK文档中有明确说明
//
//    对于浮点转换 'e'、'E' 和 'f'，精度是小数点分隔符后的位数。如果转换是 'g' 或 'G'，那么精度是舍入计算后所得数值的所有位数。如果转换是 'a' 或 'A'，则不必指定精度。
//
//    对于字符、整数和日期/时间参数类型转换，以及百分比和行分隔符转换，精度是不适用的；如果提供精度，则会抛出异常。
    @Test
    public void t4() {
        //保留两位小数的意思
        String format = String.format("%.2f", 12.12555);
        System.out.println(format); // 12.13
    }


    public void t5(){

    }

}
