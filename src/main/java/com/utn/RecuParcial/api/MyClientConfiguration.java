package com.utn.RecuParcial.api;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyClientConfiguration {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}