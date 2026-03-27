package com.duocuc.comprasmascotas;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"idOrdenCompra", "cliente", "producto", "fechaCreacion"})
public class OrdenCompra {

    private int idOrdenCompra;
    private List<Cliente> cliente;
    private List<Producto> producto;
    private String fechaCreacion;

    public OrdenCompra (int idOrdenCompra, List<Cliente> cliente, List<Producto> producto, String fechaCreacion){
        this.idOrdenCompra = idOrdenCompra;
        this.cliente = cliente;
        this.producto = producto;
        this.fechaCreacion = fechaCreacion;
    }

    //GET
    public Integer getIdOrdenCompra(){
        return idOrdenCompra;
    }

    public List<Cliente> getCliente(){
        return cliente;
    }

    public List<Producto> getProducto(){
        return producto;
    }

    public String getFechaCreacion(){
        return fechaCreacion;
    }
 
}
