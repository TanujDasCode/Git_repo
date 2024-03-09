package com.weather.weather.config;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomFeignConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new RetreiveMessageErrorDecoder();
    }
}