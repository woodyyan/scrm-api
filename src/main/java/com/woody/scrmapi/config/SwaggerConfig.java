package com.woody.scrmapi.config;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("scrm")
                // 指定路径
//                .pathsToMatch("/api/users/**")
                // 指定特定的 API 文档信息
                .addOpenApiCustomiser(userApiCustomise())
                .build();
    }

    /**
     * 定义 OpenApiCustomiser ，用于指定的 group
     */
    public OpenApiCustomiser userApiCustomise() {
        return openApi -> openApi.info(new io.swagger.v3.oas.models.info.Info()
                .title("SCRM Api文档")
                .description("SCRM")
                .version("1.0")
                .contact(new io.swagger.v3.oas.models.info.Contact().name("Woody").email("woody@woody.com")));
    }
}
