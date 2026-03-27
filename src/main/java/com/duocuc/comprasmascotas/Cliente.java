package com.duocuc.comprasmascotas;

public class Cliente {

    private String rutCliente;
    private String nombreCliente;
    private String apellidoCliente;

    public Cliente (String rutCliente, String nombreCliente, String apellidoCliente){

        this.rutCliente = rutCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;

    }

    // GET

    public Cliente() {
        
    }

    public String getRutCliente(){

        return rutCliente;

    }

    public String getNombreCliente(){

        return nombreCliente;

    }

    public String getApellidoCliente(){

        return apellidoCliente;

    }
    
}
