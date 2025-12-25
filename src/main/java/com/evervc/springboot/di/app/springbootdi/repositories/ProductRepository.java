package com.evervc.springboot.di.app.springbootdi.repositories;

import com.evervc.springboot.di.app.springbootdi.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria Kingston", 200L),
            new Product(2L, "Teclado Redragon fits pro3", 4000L),
                new Product(3L, "Procesador Intel Core i5 11400H", 250L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        //return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
