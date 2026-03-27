package com.duocuc.comprasmascotas;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


@RestController
public class CompraController {
    private List<Compra> compras = new ArrayList<>();
    public CompraController(){

        compras.add(new Compra(1,
            Arrays.asList(new Cliente("15940700-4", "Angelo","Benvenuto")),
            Arrays.asList(new Producto(3001,"Juguete Gato",15990, 3), 
                          new Producto(3002, "Juguete Perro", 19990, 4)),
            "21-03-2026"
        ));

        compras.add(new Compra(2,
            Arrays.asList(new Cliente("9843565-4", "Maria","Quilobran")),
            Arrays.asList(new Producto(3001,"Juguete Gato",15990, 4), 
                          new Producto(3003, "Cama felpa Gato", 79990, 1)),
            "22-03-2026"
        ));

        compras.add(new Compra(3,
            Arrays.asList(new Cliente("8560050-8", "Miguel","Molina")),
            Arrays.asList(new Producto(3004,"Peine Perro",7990, 3), 
                          new Producto(3002, "Juguete Perro", 19990, 10)),
            "23-03-2026"
        ));

        compras.add(new Compra(4,
            Arrays.asList(new Cliente("19938883-1", "Josseline","Molina")),
            Arrays.asList(new Producto(3005,"Cama felpa Perro",95990, 1), 
                          new Producto(3002, "Juguete Perro", 19990, 2)),
            "24-03-2026"
        ));

        compras.add(new Compra(5,
            Arrays.asList(new Cliente("16787333-1", "Laura","Benvenuto")),
            Arrays.asList(new Producto(3003,"Cama felpa Gato",79990, 3), 
                          new Producto(3006, "Peine Gato", 6990, 1)),
            "25-03-2026"
        ));

    }

    // Endpoint para mostras todas las compras - ej: "/totalpagar/1"
    @GetMapping("/compras")
    public List<Compra> obtenerCompras() {
        return compras;
    }

    // Endpoint para mostrar detalle compras por idCompra ej: "/compra/1"
    @GetMapping("/compra/{idCompra}")
    public Compra buscarIdCompra(@PathVariable Integer idCompra) {
        for (Compra compra : compras){
            if (compra.getIdCompra() == idCompra){
                return compra;
            }
        }
        return null;
    }

    // Endpoint para mostrar total a pagar por ID Compra
    @GetMapping("/totalpagar/{idCompra}")
    public String totalPagar(@PathVariable int idCompra) {
        Integer total = 0;
        String clientecompra = "";
        for (Compra compra : compras){
            if(compra.getIdCompra() == idCompra){
                for (Cliente cliente : compra.getCliente()){
                    clientecompra = cliente.getNombreCliente()+" "+cliente.getApellidoCliente();
                }
                for (Producto producto : compra.getProducto()){
                    total = total+producto.getCantidad()*producto.getPrecio();
                }
            }
        }
        if( total != 0 ){
            return "Total a pagar para el cliente: "+clientecompra+ " es de $"+ total;
        }
        else{
            return "No existe la compra buscada";
        }
    }

    // Endpoint para buscar compras por cliente ej: "/cliente/15940700-4"
    @GetMapping("/cliente/{rut}")
    public List<Compra> buscarCompraCliente(@PathVariable String rut) {
        List<Compra> compraEncontrada = new ArrayList<>();
        for (Compra compra : compras) {
            for(Cliente cliente : compra.getCliente()){
                if (cliente.getRutCliente().equals(rut)) {
                    compraEncontrada.add(compra);
                    break;
                }
             }
        }
        return compraEncontrada;
    }

    
}
