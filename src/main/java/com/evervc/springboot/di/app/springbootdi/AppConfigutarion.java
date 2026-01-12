package com.evervc.springboot.di.app.springbootdi;

import com.evervc.springboot.di.app.springbootdi.repositories.IProductRepository;
import com.evervc.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfigutarion {
    @Bean("productsJson")
    IProductRepository productRepositoryJSON() {
        return new ProductRepositoryJson();
    }
}
