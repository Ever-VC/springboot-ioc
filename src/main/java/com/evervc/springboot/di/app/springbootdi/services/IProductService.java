package com.evervc.springboot.di.app.springbootdi.services;

import com.evervc.springboot.di.app.springbootdi.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
