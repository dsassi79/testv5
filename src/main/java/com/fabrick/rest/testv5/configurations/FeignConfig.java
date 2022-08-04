package com.fabrick.rest.testv5.configurations;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(
        basePackages = {
                "com.fabrick.rest.testv5.clients"
        }
)
@EnableCircuitBreaker
public class FeignConfig {
}
