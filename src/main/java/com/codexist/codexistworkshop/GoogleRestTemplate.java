package com.codexist.codexistworkshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GoogleRestTemplate {

    @Bean("googleRestTemp")
    RestTemplate restTemplate(){


        return new RestTemplate();
    }
}
