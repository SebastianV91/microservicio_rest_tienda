package com.web.project.repository;

import com.web.project.model.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductoRepositoryTest {

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    void testSaveAndFindById() {
        Producto producto = new Producto("Laptop", 3000);
        Producto saved = productoRepository.save(producto);
        assertTrue(productoRepository.findById(saved.getId()).isPresent());
    }

    @Test
    void testExistsById() {
        Producto producto = new Producto("Tablet", 1500);
        Producto saved = productoRepository.save(producto);
        assertTrue(productoRepository.existsById(saved.getId()));
    }
}
