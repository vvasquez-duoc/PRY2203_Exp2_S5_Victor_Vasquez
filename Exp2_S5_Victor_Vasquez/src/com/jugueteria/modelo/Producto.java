package com.jugueteria.modelo;

import com.jugueteria.utilitarios.Utilitarios;

public class Producto {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int precio;
    private int cantidadStock;

    public Producto(int codigo, String nombre, String descripcion, int precio, int cantidadStock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    public int getCodigo() { 
        return codigo; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public String getDescripcion() { 
        return descripcion; 
    }
    public int getPrecio() { 
        return precio; 
    }
    public int getCantidadStock() { 
        return cantidadStock; 
    }

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }
    public void setPrecio(int precio) { 
        this.precio = precio; 
    }
    public void setCantidadStock(int cantidadStock) { 
        this.cantidadStock = cantidadStock; 
    }
    public void actualizarPrecio(int nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public String obtenerProducto() {
        return "CODIGO: "+codigo+"\nNOMBRE: "+nombre+"\nPRECIO: $"+Utilitarios.formateaMonto(precio)+"\nSTOCK: "+ cantidadStock+"\nDESCRIPCION: "+descripcion;
    }
}