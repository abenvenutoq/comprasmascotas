package com.duocuc.comprasmascotas;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"idCompra", "cliente", "producto", "fechaCompra"})
public class Compra {

    private int idCompra;
    private List<Cliente> cliente;
    private List<Producto> producto;
    private String fechaCompra;

    public Compra (int idCompra, List<Cliente> cliente, List<Producto> producto, String fechaCompra){
        this.idCompra = idCompra;
        this.cliente = cliente;
        this.producto = producto;
        this.fechaCompra = fechaCompra;
    }

    public Integer getIdCompra(){
        return idCompra;
    }

    public List<Cliente> getCliente(){
        return cliente;
    }

    public List<Producto> getProducto(){
        return producto;
    }

    public String getFechaCompra(){
        return fechaCompra;
    }
 
}
