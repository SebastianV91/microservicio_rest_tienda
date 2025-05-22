package com.web.project.service.impl;

import com.web.project.model.Producto;
import com.web.project.repository.ProductoRepository;
import com.web.project.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

}
