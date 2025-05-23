package com.web.project.controller;

import com.web.project.dto.InventarioDTO;
import com.web.project.dto.Mensaje;
import com.web.project.model.Inventario;
import com.web.project.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    InventarioService inventarioService;

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody InventarioDTO inventarioDTO){

        Inventario inventario = inventarioService.getOne(id).get();
        inventario.setCantidad(inventarioDTO.getCantidad());
        inventarioService.save(inventario);
        return new ResponseEntity(new Mensaje("Cantidad inventario actualizado"), HttpStatus.OK);
    }

}
