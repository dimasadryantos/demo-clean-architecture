package com.dzcorp.service.config;

import com.dzcorp.persistence.StockGateway;
import com.dzcorp.persistence.StockInMemoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {


    @Bean
    public StockGateway stockGateway() {
        return new StockInMemoryGateway();
    }

}
