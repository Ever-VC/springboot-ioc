package com.evervc.springboot.di.app.springbootdi;

import com.evervc.springboot.di.app.springbootdi.repositories.IProductRepository;
import com.evervc.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfigutarion {

    @Value("classpath:database/products.json")
    private Resource resource;

    @Bean("productsJson")
    IProductRepository productRepositoryJSON() {
        return new ProductRepositoryJson(resource);
    }
}
