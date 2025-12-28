package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // 🔐 Security Scheme (JWT)
        SecurityScheme securityScheme = new SecurityScheme()
                .name("Authorization")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        // 🔐 Apply globally
        SecurityRequirement securityRequirement =
                new SecurityRequirement().addList("bearerAuth");

        return new OpenAPI()
                .info(new Info()
                        .title("Academic Calendar API")
                        .description("JWT Secured APIs")
                        .version("1.0"))
                .addSecurityItem(securityRequirement)
                .components(
                        new io.swagger.v3.oas.models.Components()
                                .addSecuritySchemes("bearerAuth", securityScheme)
                )
                .servers(List.of(
                        new Server().url("http://localhost:9001")
                ));
    }
}
