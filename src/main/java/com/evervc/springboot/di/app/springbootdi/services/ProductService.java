package com.evervc.springboot.di.app.springbootdi.services;

import com.evervc.springboot.di.app.springbootdi.models.Product;
import com.evervc.springboot.di.app.springbootdi.repositories.ProductRepository;

import java.util.List;

// Esta es la capa de negocios, donde se pueden modificar los datos obtenidos del repositorio, según se necesiten
public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        // Modificando el valor del precio para todos los objetos
        return repository.findAll().stream().map(product -> {
            Product p = new Product(product.getId(), product.getName(), product.getPrice());
            p.setPrice((long) (product.getPrice() * 1.25));
            return p;
        }).toList();
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
