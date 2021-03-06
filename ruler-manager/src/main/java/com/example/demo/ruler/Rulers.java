package com.example.demo.ruler;

import lombok.NonNull;
import lombok.val;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class Rulers {
    // 设定定义域为固定字符串，并且需要根据环境判断是否
    public static Ruler newRuler(@NonNull String name, @NonNull Supplier<Boolean> test) {
        return new Ruler() {
            @Override
            public boolean isDefinedAt(String domain) {
                return Objects.equals(domain, name);
            }

            @Override
            public Boolean apply(String methodAndArgs) {
                return test.get();
            }
        };
    }

    public static Ruler newRuler(@NonNull String name, @NonNull Function<String, Boolean> test) {
        return new Ruler() {
            @Override
            public boolean isDefinedAt(String domain) { //date_between(2021,2022)
                System.out.println("name==" + name);
                System.out.println("domain==" + domain);
                val index1 = domain.indexOf("(");
                val index2 = domain.indexOf(")");
                boolean is = index1 > 0
                        && index2 > index1
                        && domain.trim().startsWith(name)
                        && name.length() + 1 == index1;
                return is;
            }

            @Override
            public Boolean apply(String methodAndArgs) {
                System.out.println("Function-apply参数：" + methodAndArgs);
                return test.apply(parseArg(methodAndArgs));
            }

        };
    }

    private static String parseArg(String string) {
        val index1 = string.indexOf("(");
        val index2 = string.indexOf(")");
        Assert.isTrue(index1 > 0, "参数不合法" + string);
        Assert.isTrue(index2 > index1, "参数不合法" + string);
        Assert.isTrue(index2 + 1 == string.length(), "参数不合法" + string);
        return string.substring(index1 + 1, index2);
    }
}
