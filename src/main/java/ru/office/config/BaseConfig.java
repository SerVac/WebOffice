package ru.office.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class BaseConfig {
    public BaseConfig() {
    }

}