package com.web.project.service.impl;

import com.web.project.model.Inventario;
import com.web.project.repository.InventarioRepository;
import com.web.project.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    @Override
    public void save(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    @Override
    public boolean existsById(int id) {
        return inventarioRepository.existsById(id);
    }

    @Override
    public Optional<Inventario> getOne(int id) {
        return inventarioRepository.findById(id);
    }

}
