package com.fabrick.rest.testv5.configurations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
@Getter
@Setter
public class HomeConfiguration {
    @Value("${fabrick.url}")
    private String fabrickUrl;
    @Value("${fabrick.authSchema}")
    private String authSchema;
    @Value("${fabrick.apikey}")
    private String apikey;
    @Value("${fabrick.timeZone}")
    private String timeZone;
}
