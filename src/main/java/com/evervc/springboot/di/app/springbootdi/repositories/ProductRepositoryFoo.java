package com.evervc.springboot.di.app.springbootdi.repositories;

import com.evervc.springboot.di.app.springbootdi.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepositoryFoo implements IProductRepository {

    @Override
    public List<Product> findAll() {
        return List.of(new Product(4L, "Laptop MSI", 999L), new Product(5L, "Smart TV", 450L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(6L, "Equipo de Sonido", 100L);
    }
}
