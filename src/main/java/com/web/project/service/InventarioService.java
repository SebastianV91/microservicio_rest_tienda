package com.web.project.service;

import com.web.project.model.Inventario;

import java.util.Optional;

public interface InventarioService {

    public void save(Inventario inventario);

    public boolean existsById(int id);

    public Optional<Inventario> getOne(int id);

}
