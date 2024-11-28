package com.amazona.amazona.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitindo todas as origens (apenas para testes, use com cautela em produção)
        registry.addMapping("/**")
                .allowedOrigins("*") // Coloque as URLs do seu front-end
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
