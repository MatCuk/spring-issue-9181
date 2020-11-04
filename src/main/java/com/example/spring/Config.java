package com.example.spring;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.time.Instant;
import java.util.HashMap;

@Configuration
public class Config {

    @Bean
    public JwtDecoder provideJwtDecoder() {
        return s -> Jwt.withTokenValue("fakeToken").expiresAt(Instant.MAX).header("Authorization", "Bearer fake").build();
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        //Limit file upload to 10mb
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofMegabytes(10));
        factory.setMaxRequestSize(DataSize.ofMegabytes(10));
        return factory.createMultipartConfig();
    }
}
