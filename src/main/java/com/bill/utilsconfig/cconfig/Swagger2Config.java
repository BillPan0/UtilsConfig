package com.bill.utilsconfig.cconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Swagger 2.x 配置类
 * @author Bill
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    //配置Swagger的实例Bean
    @Bean
    public Docket docketApi2(){
        Contact contact = new Contact("", "", "");
        ApiInfo apiInfo = new ApiInfo("CustomTitle",
                "CustomDescription",
                "CustomVersion",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
        return new Docket(DocumentationType.SWAGGER_2)
                //配置页面详情信息
                .apiInfo(apiInfo)
                //控制开关
                .enable(false)

                .select()
                //配置接口扫描方式：全部
                .apis(RequestHandlerSelectors.any())
                //配置路径过滤：全部配置
                .paths(PathSelectors.any())
                .build()
                //配置安全认证方式，基本身份认证（用户名/密码）、Api（token）、OAUTH授权三种
                .securitySchemes(securitySchemes())
                //配置安全认证范围
                .securityContexts(securityContexts())
                ;
    }

    //header内添加token属性作为认证API的方式
    private List<SecurityScheme> securitySchemes() {
        return new ArrayList<>(
                Collections.singleton(new ApiKey("Authorization", "token", "header")));
    }

    private List<SecurityContext> securityContexts() {
        return new ArrayList<>(
                Collections.singleton(SecurityContext.builder()
                        //使securityScheme定义的认证方式和安全域对应
                        .securityReferences(defaultAuth())
                        //添加所有路径
                        //方法过时但替代方法还没有具体示例
                        .forPaths(PathSelectors.regex("/.*"))
                        .build())
        );
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return new ArrayList<>(
                Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
    }
}
