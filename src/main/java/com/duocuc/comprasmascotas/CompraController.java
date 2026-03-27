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
            Arrays.asList(new Cliente("15940700-4", "Angelo", "Benvenuto")), 
            Arrays.asList(new Producto(3001, "Peine para Perros", 1990, 2)),
            3980)
        );

        compras.add(new Compra(2, 
            Arrays.asList(new Cliente("9843565-4", "Maria", "Quilobran")), 
            Arrays.asList(new Producto(3001, "Peine para Gatos", 1500, 5)),
            7500)
        );

        compras.add(new Compra(3, 
            Arrays.asList(new Cliente("8560050-8", "Miguel", "Molina")), 
            Arrays.asList(new Producto(3002, "Correa para Perro A1", 2990, 15)),
            44850)
        );

        compras.add(new Compra(4, 
            Arrays.asList(new Cliente("14541243-5", "Guillermo", "Soto")), 
            Arrays.asList(new Producto(3002, "Correa para Perro A2", 3290, 13)),
            42770)
        );

        compras.add(new Compra(5, 
            Arrays.asList(new Cliente("22333983-2", "Leila", "Carrasco")), 
            Arrays.asList(new Producto(3003, "Juguete para Gato A1", 5990,30)),
            179700)
        );

        compras.add(new Compra(6, 
            Arrays.asList(new Cliente("12339993-4", "Marco", "Miranda")), 
            Arrays.asList(new Producto(3004, "Jueguete para Gato A2", 4990, 20)),
            99800)
        );

        compras.add(new Compra(7, 
            Arrays.asList(new Cliente("19333222-2", "Marcelo", "Quintanilla")), 
            Arrays.asList(new Producto(3004, "Cama gato redonda A1", 7990, 100)),
            799000)
        );

        compras.add(new Compra(8, 
            Arrays.asList(new Cliente("18838822-3", "Victor", "Fuenzalida")), 
            Arrays.asList(new Producto(3005, "Cama perro cuadrada A1", 12990, 10)),
            129900)
        );

    }

    // Endpint para mostras todas las compras
    @GetMapping("/compras")
    public List<Compra> obtenerCompras() {
        return compras;
    }

    // Endpoint para buscar compras por ID producto
    @GetMapping("/idproducto/{idproducto}")
    public List<Compra> buscarIdCompraProd(@PathVariable int idproducto) {

        List<Compra> compraEncontrada = new ArrayList<>();

        for (Compra compra : compras) {

            for(Producto producto : compra.getProducto()){

                if (producto.getIdProducto() == idproducto) {
                    
                    compraEncontrada.add(compra);

                    break;

                }
             }

        }

        return compraEncontrada;

    }

    // Endpoint para buscar compras por cliente
    @GetMapping("/cliente/{rut}")
    public List<Compra> buscarIdCompraProd(@PathVariable String rut) {

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
