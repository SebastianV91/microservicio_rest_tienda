package com.web.project.service.impl;

import com.web.project.model.Producto;
import com.web.project.repository.ProductoRepository;
import com.web.project.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public boolean existsById(int id) {
        return productoRepository.existsById(id);
    }

    @Override
    public Optional<Producto> getOne(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> list() {
        return productoRepository.findAll();
    }

}
