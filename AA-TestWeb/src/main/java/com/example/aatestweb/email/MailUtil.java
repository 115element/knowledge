package com.example.aatestweb.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;


@Slf4j
@Component
@EnableAsync
public class MailUtil {

    @Value("${spring.mail.username}")
    private String from;
    @Value("${chengyu.logo.path}")
    private String imgPath;

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    TemplateEngine templateEngine;

    @Async
    public void warning(String toMail, String type) {
        Context context = new Context();
        StringBuilder stringBuilder = new StringBuilder(MailContent.typeMap.get(type));
        stringBuilder.append(MailContent.symbolMap.get("123"));
        stringBuilder.append("123");
        context.setVariable("domain", "123.com");
        context.setVariable("desc", stringBuilder.toString());
        String emailThymeleaf = templateEngine.process("WarningThymeleaf", context);
        this.sendEmail(toMail, MailContent.typeMap.get(type) + "预警", emailThymeleaf, "123.com");
    }

    @Async
    public void error(String toMail, String number, String text, String domain) {
        Context context = new Context();
        context.setVariable("domain", domain);
        context.setVariable("number", number);
        context.setVariable("text", text);
        String emailThymeleaf = templateEngine.process("ErrorThymeleaf", context);
        this.sendEmail(toMail, "错误预警", emailThymeleaf, domain);
    }

    @Async
    public void reset(String toMail, String type) {
        Context context = new Context();
        context.setVariable("domain", "123.com");
        StringBuilder stringBuilder = new StringBuilder(MailContent.typeMap.get(type));
        stringBuilder.append(MailContent.symbolMap.get("23"));
        stringBuilder.append("1233");
        context.setVariable("desc", stringBuilder);
        context.setVariable("reset", "已恢复");
        String emailThymeleaf = templateEngine.process("WarningThymeleaf", context);
        this.sendEmail(toMail, MailContent.typeMap.get(type) + "预警恢复", emailThymeleaf, "123.com");
    }

    /**
     * 发送邮件
     *
     * @param to      接收者
     * @param subject 主题
     * @param content 内容
     * @throws Exception
     */
    private void sendEmail(String to, String subject, String content, String taskName) {
        for (String mail : to.split(",")) {
            try {
                log.info("发送模板邮件开始：{},{}", mail, subject);
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
                mimeMessageHelper.setFrom(from);
                mimeMessageHelper.setTo(mail);
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(content, true);
                FileSystemResource fileSystemResource = new FileSystemResource(imgPath);
                mimeMessageHelper.addInline("logoImage", fileSystemResource);
                javaMailSender.send(mimeMessage);
                log.info("{},发送模板邮件成功,email:{}", taskName, JsonUtils.toJSONString(to));
            } catch (Exception e) {
                log.error("{}，邮件发送失败，{}", JsonUtils.toJSONString(to), e);
            }
        }
    }
}