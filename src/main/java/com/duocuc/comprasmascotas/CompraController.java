package com.duocuc.comprasmascotas;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


@RestController
public class CompraController {
    private List<OrdenCompra> compras = new ArrayList<>();
    public CompraController(){

        compras.add(new OrdenCompra(1,
            Arrays.asList(new Cliente("15940700-4", "Angelo","Benvenuto")),
            Arrays.asList(new Producto(3001,"Juguete Gato",15990, 3), 
                          new Producto(3002, "Juguete Perro", 19990, 4)),
            "21-03-2026"
        ));

        compras.add(new OrdenCompra(2,
            Arrays.asList(new Cliente("9843565-4", "Maria","Quilobran")),
            Arrays.asList(new Producto(3001,"Juguete Gato",15990, 4), 
                          new Producto(3003, "Cama felpa Gato", 79990, 1)),
            "22-03-2026"
        ));

        compras.add(new OrdenCompra(3,
            Arrays.asList(new Cliente("8560050-8", "Miguel","Molina")),
            Arrays.asList(new Producto(3004,"Peine Perro",7990, 3), 
                          new Producto(3002, "Juguete Perro", 19990, 10)),
            "23-03-2026"
        ));

        compras.add(new OrdenCompra(4,
            Arrays.asList(new Cliente("19938883-1", "Josseline","Molina")),
            Arrays.asList(new Producto(3005,"Cama felpa Perro",95990, 1), 
                          new Producto(3002, "Juguete Perro", 19990, 2)),
            "24-03-2026"
        ));

        compras.add(new OrdenCompra(5,
            Arrays.asList(new Cliente("16787333-1", "Laura","Benvenuto")),
            Arrays.asList(new Producto(3003,"Cama felpa Gato",79990, 3), 
                          new Producto(3006, "Peine Gato", 6990, 1)),
            "25-03-2026"
        ));

    }

    //MUESTRA TODAS LAS ORDENES DE COMPRA"
    @GetMapping("/listar_ordenes")
    public List<OrdenCompra> obtenerCompras() {
        return compras;
    }

    //MUESTRA DETALLE DE COMPRA POR ID ORDEN DE COMPRA"
    @GetMapping("/orden_de_compra/{idOrdenCompra}")
    public OrdenCompra buscarIdOrdenCompra(@PathVariable Integer idOrdenCompra) {
        for (OrdenCompra compra : compras){
            if (compra.getIdOrdenCompra() == idOrdenCompra){
                return compra;
            }
        }
        return null;
    }

    //MUESTRA TOTAL A PAGAR POR ID ORDEN DE COMPRA
    @GetMapping("/totalpagar/{idOrdenCompra}")
    public String totalPagar(@PathVariable int idOrdenCompra) {
        Integer total = 0;
        String clientecompra = "";
        for (OrdenCompra compra : compras){
            if(compra.getIdOrdenCompra() == idOrdenCompra){
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

    //MUESTRA DETALLE ORDEN DE COMPRAS DE CLIENTES POR RUT"
    @GetMapping("/cliente/{rut}")
    public List<OrdenCompra> buscarCompraCliente(@PathVariable String rut) {
        List<OrdenCompra> compraEncontrada = new ArrayList<>();
        for (OrdenCompra compra : compras) {
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
