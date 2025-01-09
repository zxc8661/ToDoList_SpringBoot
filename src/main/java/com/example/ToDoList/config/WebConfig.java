package com.example.ToDoList.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/app/**")
                        .allowedOrigins("http://localhost:3000")  // 리액트 기본 포트
                        .allowedMethods("GET", "POST","DELETE","PUT")
                        .allowedHeaders("*")
                        .allowCredentials(true);

            }
        };
    }
}