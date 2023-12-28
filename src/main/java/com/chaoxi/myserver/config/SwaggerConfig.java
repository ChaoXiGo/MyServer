package com.chaoxi.myserver.config;

import lombok.var;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示swagger的环境
        Profiles profiles = Profiles.of("dev", "debug");
        // 判断当前配置文件是否是设置的环境
        boolean swagger = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swagger)
                // 添加分组信息
                .groupName("朝西")
                .select()
                // RequestHandlerSelectors配置api扫描的接口的方式
                // basePackage:指定要扫描的包
                // any():扫描全部
                // none():全不扫描
                // withClassAnnotation(RestController.class):扫描类上含RestController注解的
                // withMethodAnnotation():扫描方法上含注解的
                .apis(RequestHandlerSelectors.basePackage("com.chaoxi.myserver.controller"))
                // .paths()
                .build();
    }

    private ApiInfo apiInfo() {
        /*作者信息*/
        Contact contact = new Contact("朝西", "www.baidu.com", "351306651@qq.com");
        return new ApiInfo(
                "Swagger 测试接口文档",
                "Spring Boot 集成 Swagger 测试接口文档",
                "v1.0",
                "https://www.baidu.com",
                contact,
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
