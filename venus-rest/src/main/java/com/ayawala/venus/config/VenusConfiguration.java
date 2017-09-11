package com.ayawala.venus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="venus")
public class VenusConfiguration {

    private String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(final String message) {
        this.message = message;
    }
}