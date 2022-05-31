package com.globalbilgi.restservice.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
     private static final String ALLOWED_PATHS = "/api/.*";
    private static final String GROUP_NAME = "ivr-restservice-call";
    private static final String TITLE = "IVR RestService Call API Documentation";
    private static final String DESC = "172.20.27.70 Tomcat uzerinden rest servise istek atmak icin kullanılan web servistir";
    private static final String VERS = "1.0.0";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESC)
                .version(VERS)
                .build();
    }

    @Bean
    public Docket docketApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(GROUP_NAME)
                .useDefaultResponseMessages(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.global"))
                .build()
                .pathMapping("/");
    }

}