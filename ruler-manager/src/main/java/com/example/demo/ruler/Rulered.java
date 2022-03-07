package com.example.demo.ruler;

import com.example.demo.hook.BeanHook;
import com.example.demo.jpa.entity.RulerTemplate;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public interface Rulered {

    public static final Logger log = LoggerFactory.getLogger(Rulered.class);

    public String getRulers();

    public Long getId();

    public default String getParsedRulers() {
        return parse(getRulers());
    }

    // rulers宏展开
    public static String parse(String origin) {
        log.debug("beforeParse:{}", origin);
        while (origin.contains("{") && origin.contains("}")) {
            var index1 = origin.indexOf("{");
            var index2 = origin.indexOf("}");
            Assert.isTrue(index2 > index1, "规则配置错误");
            var templateName = origin.substring(index1 + 1, index2);

            //通过name,去获取数据库配置的内容
            var templateContent = BeanHook.self().getRulerTemplateRepository()
                    .findByName(templateName)
                    .map(RulerTemplate::getContent)
                    .orElse(null);
            if (templateContent == null) return "false";
            origin = origin.replace("{" + templateName + "}", templateContent);
        }
        log.debug("afterParse:{}", origin);
        return origin;
    }

    // 检查该条rulered是否匹配
    public default Boolean match() {
        //log.debug("Rulered实体id:{}",getId());
        return BeanHook.self().getRulerManager().match(getParsedRulers());
    }
}
