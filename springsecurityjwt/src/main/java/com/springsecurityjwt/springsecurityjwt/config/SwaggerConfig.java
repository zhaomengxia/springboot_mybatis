package com.springsecurityjwt.springsecurityjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * @author hahaha
 * @date 2018-08-06 17:02
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        List<Parameter> pars = new ArrayList<>();

            ParameterBuilder ticketPar = new ParameterBuilder();
            //swagger 增加头部信息token用于验证登陆

            //name表示名称，description表示描述
            ticketPar.name(HttpHeaders.AUTHORIZATION)
                    .description("用于校验token")
                    .required(true)
                    .modelRef(new ModelRef("string")).parameterType("header")
                    //required表示是否必填，defaultvalue表示默认值
                    //.defaultValue()
                    .build();
            //添加完此处一定要把下边的带***的也加上否则不生效
            pars.add(ticketPar.build());


        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springsecurityjwt.springsecurityjwt.controller"))
                .paths(PathSelectors.any())
                .build();

        if (!pars.isEmpty()) {
            docket.globalOperationParameters(pars);
        }

        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API接口文档")
                .description("restful接口")
                .version("1.0")
                .build();
    }

}
