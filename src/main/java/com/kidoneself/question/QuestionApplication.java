package com.kidoneself.question;

import com.kidoneself.aio.common.knife4j.annotation.EnablePigeonKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnablePigeonKnife4j
public class QuestionApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class, args);
    }

    /**
     * https://www.xiaominfo.com/docs/faq/springboot-404
     * 解决doc.html 访问不到
     * @param registry
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
