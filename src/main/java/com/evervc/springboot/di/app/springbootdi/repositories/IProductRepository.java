package com.evervc.springboot.di.app.springbootdi.repositories;

import com.evervc.springboot.di.app.springbootdi.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
