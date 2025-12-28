package com.evervc.springboot.di.app.springbootdi.services;

import com.evervc.springboot.di.app.springbootdi.models.Product;
import com.evervc.springboot.di.app.springbootdi.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

// Esta es la capa de negocios, donde se pueden modificar los datos obtenidos del repositorio, según se necesiten
@Service
public class ProductService implements IProductService {

    private IProductRepository repository;

    @Autowired
    private Environment environment;

    public ProductService(@Qualifier("products") IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        // Modificando el valor del precio para todos los objetos
        return repository.findAll().stream().map(product -> {
            //Product p = new Product(product.getId(), product.getName(), product.getPrice());

            Product p = (Product) product.clone();
            p.setPrice((long) (product.getPrice() * environment.getProperty("config.tax", Double.class, 1.25d)));
            return p;

            // Para mantener mutable los datos
            /*product.setPrice((long) (product.getPrice() * 1.25));
            return product;*/
        }).toList();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
