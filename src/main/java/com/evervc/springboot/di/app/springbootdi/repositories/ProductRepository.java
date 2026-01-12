package com.evervc.springboot.di.app.springbootdi.repositories;

import com.evervc.springboot.di.app.springbootdi.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.List;

// Esta es la capa de acceso a datos (base de datos, arreglos, API REST, etc)
//@Primary //Define que este es el repositorio principal para hacer la inyeccion de depencias desde la interfaz y no el ProeductRepositoryFoo
//@RequestScope // Mutabilidad por http Request, es decir qie se modifican por cada usuario conectado
//@SessionScope // Scope de cada sesión (Los datos se restaurarán al cerrar el navegador)
@Repository("products")
public class ProductRepository implements IProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria Kingston", 200L),
            new Product(2L, "Teclado Redragon fits pro3", 4000L),
                new Product(3L, "Procesador Intel Core i5 11400H", 250L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        //return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
