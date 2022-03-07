package com.example.demo.jpa.entity;

import com.example.demo.hook.BeanHook;
import com.example.demo.jpa.repo.RulerTemplateRepository;
import lombok.Data;
import lombok.var;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_ruler_template")
public class RulerTemplate implements Serializable {

    private static final long serialVersionUID = -7768338277585538696L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;


    public static RulerTemplateRepository repo() {
        return BeanHook.self().getApplicationContext()
                .getBean(RulerTemplateRepository.class);
    }

    public String getParsedContent() {
        while (content.contains("{") && content.contains("}")) {
            var index1 = content.indexOf("{");
            var index2 = content.indexOf("}");
            Assert.isTrue(index2 > index1, "规则配置错误");
            var templateName = content.substring(index1 + 1, index2);
            var templateContent = repo().findAll()
                    .stream()
                    .filter(x -> StringUtils.equals(x.getName(), templateName))
                    .findFirst()
                    .map(RulerTemplate::getParsedContent)
                    .orElse("无法找到" + templateName + "对应的模板");
            content = content.replace("{" + templateName + "}", templateContent);
        }
        return content;
    }
}
