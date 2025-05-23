package com.web.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.project.dto.ProductoDTO;
import com.web.project.model.Producto;
import com.web.project.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductoController.class)
class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateProducto() throws Exception {
        ProductoDTO dto = new ProductoDTO("Monitor", 1000);

        mockMvc.perform(post("/producto/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje").value("Producto creado"));
    }

    @Test
    void testUpdateProducto_NotFound() throws Exception {
        ProductoDTO dto = new ProductoDTO("Monitor", 900);

        when(productoService.existsById(1)).thenReturn(false);

        mockMvc.perform(put("/producto/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.mensaje").value("No existe"));
    }

    @Test
    void testUpdateProducto_Success() throws Exception {
        ProductoDTO dto = new ProductoDTO("Monitor", 900);
        Producto producto = new Producto("Viejo", 800);
        producto.setId(1);

        when(productoService.existsById(1)).thenReturn(true);
        when(productoService.getOne(1)).thenReturn(Optional.of(producto));

        mockMvc.perform(put("/producto/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje").value("Producto actualizado"));
    }
}
