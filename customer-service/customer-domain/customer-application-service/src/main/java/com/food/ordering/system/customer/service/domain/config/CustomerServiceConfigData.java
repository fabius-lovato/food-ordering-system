package com.food.ordering.system.customer.service.domain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "customer-service")
public class CustomerServiceConfigData {
    private String customerTopicName;
}
