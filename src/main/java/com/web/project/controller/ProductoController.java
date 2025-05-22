package com.web.project.controller;

import com.web.project.dto.Mensaje;
import com.web.project.dto.ProductoDTO;
import com.web.project.model.Producto;
import com.web.project.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductoDTO productoDTO){

        Producto producto = new Producto(productoDTO.getNombre(), productoDTO.getPrecio());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("Producto creado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id){

        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);

        Producto producto = productoService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProductoDTO productoDTO){

        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);

        Producto producto = productoService.getOne(id).get();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("Producto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){

        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);

        productoService.delete(id);
        return new ResponseEntity(new Mensaje("Producto eliminado"), HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> list(){
        List<Producto> list = productoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

}
