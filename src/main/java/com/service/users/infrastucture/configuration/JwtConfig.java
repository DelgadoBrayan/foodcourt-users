package com.service.users.infrastucture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Configuration
public class JwtConfig {

    @Bean
    public byte[] secretKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
    }
}
