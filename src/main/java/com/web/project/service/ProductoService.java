package com.web.project.service;

import com.web.project.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public void save(Producto producto);

    public boolean existsById(int id);

    public Optional<Producto> getOne(int id);

    public void delete(int id);

    public List<Producto> list();

}
