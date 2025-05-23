package com.web.project.dto;

public class InventarioDTO {

    private int producto_id;
    private int cantidad;

    public InventarioDTO() {
    }

    public InventarioDTO(int producto_id, int cantidad) {
        this.producto_id = producto_id;
        this.cantidad = cantidad;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
