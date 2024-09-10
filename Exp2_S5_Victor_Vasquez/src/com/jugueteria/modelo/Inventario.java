package com.jugueteria.modelo;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private HashMap<Integer, Producto> productos;

    public Inventario() {
        productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto) {
        productos.put(producto.getCodigo(), producto);
    }

    public Producto buscarProductoPorCodigo(int codigo) {
        return productos.get(codigo);
    }

    public List<Producto> buscarProductosPorNombre(String nombre) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto producto : productos.values()) {
            if (producto.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

    public boolean eliminarProducto(int codigo) {
        return productos.remove(codigo) != null;
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos.values());
    }

}