package com.duocuc.comprasmascotas;

public class Producto {

    private int idProducto;
    private String nombreProducto;
    private int precio;
    private int cantidad;

    public Producto (int idProducto, String nombreProducto, int precio, int cantidad){

        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;

    }

    //GET

    public int getIdProducto(){

        return idProducto;

    }

    public String getNombreProducto(){

        return nombreProducto;

    }
    
    public int getPrecio(){

        return precio;

    }

    public int getCantidad(){

        return cantidad;

    }

}
