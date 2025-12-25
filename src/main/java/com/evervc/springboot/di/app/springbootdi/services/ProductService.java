package com.evervc.springboot.di.app.springbootdi.services;

import com.evervc.springboot.di.app.springbootdi.models.Product;
import com.evervc.springboot.di.app.springbootdi.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Esta es la capa de negocios, donde se pueden modificar los datos obtenidos del repositorio, según se necesiten
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> findAll() {
        // Modificando el valor del precio para todos los objetos
        return repository.findAll().stream().map(product -> {
            //Product p = new Product(product.getId(), product.getName(), product.getPrice());
            Product p = (Product) product.clone();
            p.setPrice((long) (product.getPrice() * 1.25));
            return p;
        }).toList();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
