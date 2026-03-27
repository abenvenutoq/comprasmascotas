package com.duocuc.comprasmascotas;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"idCompra", "cliente", "producto", "total"})
public class Compra {

    private int idCompra;
    private List<Cliente> cliente;
    private List<Producto> producto;
    private int total;

    public Compra (int idCompra, List<Cliente> cliente, List<Producto> producto, int total){

        this.idCompra = idCompra;
        this.cliente = cliente;
        this.producto = producto;
        this.total = total;

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

    public Integer getTotal(){

        return total;

    }
 
}
