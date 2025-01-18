package com.service.users.infrastucture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient restaurantWebClient() {
        return WebClient.builder().baseUrl("http://localhost:8085/api/restaurants/").build();
    }

}