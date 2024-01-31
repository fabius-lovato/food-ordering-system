package com.food.ordering.system.customer.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.food.ordering.system.customer.service.domain.CustomerDomainService;
import com.food.ordering.system.customer.service.domain.CustomerDomainServiceImpl;

@Configuration
public class BeanConfiguration {

    @Bean
    public CustomerDomainService customerDomainService() {
        return new CustomerDomainServiceImpl();
    }
}
