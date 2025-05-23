package com.web.project.service;

import com.web.project.model.Producto;
import com.web.project.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductoServiceTest {

    @InjectMocks
    private ProductoService productoService;

    @Mock
    private ProductoRepository productoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveProducto() {
        Producto producto = new Producto("Teclado", 500);
        productoService.save(producto);
        verify(productoRepository, times(1)).save(producto);
    }

    @Test
    void testExistsById() {
        when(productoRepository.existsById(1)).thenReturn(true);
        boolean exists = productoService.existsById(1);
        assertTrue(exists);
    }

    @Test
    void testGetOne() {
        Producto producto = new Producto("Mouse", 200);
        when(productoRepository.findById(1)).thenReturn(Optional.of(producto));
        Optional<Producto> result = productoService.getOne(1);
        assertTrue(result.isPresent());
        assertEquals("Mouse", result.get().getNombre());
    }

}
