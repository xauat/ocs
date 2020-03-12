package com.aerors.ocs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = {"com.aerors.ocs.controller"})
public class SwaggerConfig {
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		 .enable(true)
        		 .select()
                 .apis(RequestHandlerSelectors.any())
                 .paths(PathSelectors.any())
                 .build()
                 .apiInfo(apiInfo());
    }
	
    private ApiInfo apiInfo() {
        Contact contact = new Contact("测试", "swagger-ui", "tianw@spacestar.com.cn");
        return new ApiInfoBuilder()
                .title("接口控制列表")
                .description("XXXXXXXXXXXXXXXXX")
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
                .contact(contact)
                .version("1.0.0")
                .build();
    }

}
