package com.dzcorp.service.config;

import com.dzcorp.persistence.StockGateway;
import com.dzcorp.core.usecase.CreationOrderInputBoundary;
import com.dzcorp.core.usecase.CreationOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public CreationOrderInputBoundary useCase(StockGateway stockGateway){
        return new CreationOrderUseCase(stockGateway);
    }


}
