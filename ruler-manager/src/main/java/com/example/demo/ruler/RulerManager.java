package com.example.demo.ruler;

import com.example.demo.hook.CtlUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author weicl
 * date 2020/7/15 18:08
 */
@Slf4j
@Component
public class RulerManager {

    @Autowired
    private Set<Ruler> rulerSet;

    public boolean match(String format, Object... args) {
        return match(String.format(format, args));
    }

    public boolean match(String rulersString) {
        if (rulersString == null) return true;
        if (rulersString.startsWith("false")) return false;
        var resultString = Stream.of(rulersString)
                .map(x -> x.split("\\|"))
                //将上一个方法映射后得到的数组，重新转换为Stream流
                .flatMap(Arrays::stream)
                .map(x -> x.split("&"))
                .flatMap(Arrays::stream)
                .map(x -> x.split("\\["))
                .flatMap(Arrays::stream)
                .map(x -> x.split("]"))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotBlank)
                .distinct()
                .peek(x -> System.out.println("peek：" + x))
                .reduce(rulersString,
                        (string, singleRuler) -> {
                            System.out.println("first：" + rulersString);
                            System.out.println("reduce1：" + string);
                            System.out.println("reduce2：" + singleRuler);
                            return string.replace(singleRuler, matchSingle(singleRuler) + "");
                        },
                        (a, b) -> {
                            System.out.println("A：" + a);
                            System.out.println("B：" + b);
                            return null;
                        });
        return simplify(resultString);
    }

    // 求解基本命题
    private boolean matchSingle(String rulerString) {
        // 加了request级的缓存
        Boolean res = CtlUtils.getAttribute(rulerString);
        if (res != null) return res;
        res = matchSingle0(rulerString);
        CtlUtils.request().setAttribute(rulerString, res);
        return res;
    }

    // 求解基本命题
    private boolean matchSingle0(String rulerString) {
        if (rulerString == null) return true;
        if (rulerString.startsWith("!")) {
            return rulerSet.stream()
                    .filter(ruler -> ruler.isDefinedAt(rulerString.substring(1))) //如果为!开头，那么去掉开头的叹号
                    .map(Ruler::not)
                    .allMatch(ruler -> ruler.apply(rulerString.substring(1))); //如果为!开头，那么去掉开头的叹号
            //TODO 当数组为空时，allMatch会返回true，所以比较特殊
        }
        return rulerSet.stream()
                .filter(ruler -> ruler.isDefinedAt(rulerString))
                .peek(System.out::println)
                .allMatch(ruler -> ruler.apply(rulerString));
        //TODO 当数组为空时，allMatch会返回true，所以比较特殊
    }

    // 化简复合命题
    private static boolean simplify(String compoundProposition) {
        // valid
        var length = compoundProposition
                .replace("true", "")
                .replace("false", "")
                .replace("&", "")
                .replace("|", "")
                .replace("[", "")
                .replace("]", "")
                .length();
        if (length != 0) return false;
        return simplify0(compoundProposition);
    }

    private static final ScriptEngine JS_ENGINE =
            new ScriptEngineManager().getEngineByName("nashorn");

    @SneakyThrows
    private static boolean simplify0(String compound) {
        var res = JS_ENGINE.eval(compound).toString(); //执行表达式
        return Objects.equals(res, "true") || Objects.equals(res, "1");
    }
}
