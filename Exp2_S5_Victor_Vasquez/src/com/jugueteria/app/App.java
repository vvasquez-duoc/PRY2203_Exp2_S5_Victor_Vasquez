package com.jugueteria.app;

import com.jugueteria.modelo.Inventario;
import com.jugueteria.modelo.Producto;
import com.jugueteria.utilitarios.Utilitarios;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static ArrayList<String> itemsMenu = new ArrayList<>();
    static Inventario inventario = new Inventario();
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        itemsMenu.add("AGREGAR PRODUCTO");
        itemsMenu.add("BUSCAR PRODUCTO");
        itemsMenu.add("ELIMINAR PRODUCTO");
        itemsMenu.add("LISTAR PRODUCTOS");
        itemsMenu.add("Salir");
        
        Utilitarios.limpiaPantalla();
        menuPrincipal();
    }
    
    static void menuPrincipal(){
        int opcion = 0;
        
        try{
            do{
                System.out.println("BIENVENIDO JUGUETERIA");
                System.out.println("");
                System.out.println("SELECCIONE UNA OPCION");
                for(int i=0; i<itemsMenu.size(); i++){
                    System.out.println("["+(i + 1)+"] "+itemsMenu.get(i));
                }
                opcion = teclado.nextInt();
                if(opcion < 1 || opcion > itemsMenu.size()){
                    Utilitarios.limpiaPantalla();
                    System.out.println("-- LA OPCION ("+opcion+") NO ES VALIDA --");
                    System.out.println("");
                }
            }while(opcion < 1 || opcion > itemsMenu.size());
        }catch(Exception e){
            Utilitarios.limpiaPantalla();
            System.out.println("ERROR: LA OPCION INGRESADA NO ES UN NUMERO");
            System.out.println("");
            menuPrincipal();
        }
        
        if(opcion == 1){
            Utilitarios.limpiaPantalla();
            agregarProducto();
        }
        
        if(opcion == 2){
            Utilitarios.limpiaPantalla();
            buscarProducto();
        }
        
        if(opcion == 3){
            Utilitarios.limpiaPantalla();
            eliminarProducto();
        }
        
        if(opcion == 4){
            Utilitarios.limpiaPantalla();
            listarProductos();
        }
        
        if(opcion == 5){
           Utilitarios.limpiaPantalla();
           System.out.println("GRACIAS POR USAR SISTEMA ADMIN JUGUETERIA");
        }
    }
    
    static void agregarProducto() {
        System.out.println("INGRESE EL CODIGO DEL PRODUCTO:");
        int codigo = teclado.nextInt();
        System.out.println("INGRESE EL NOMBRE DEL PRODUCTO: ");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        System.out.println("INGRESE LA DESCRIPCION DEL PRODUCTO: ");
        String descripcion = teclado.nextLine();
        System.out.println("INGRESE EL PRECIO DEL PRODUCTO: ");
        int precio = teclado.nextInt();
        System.out.println("INGRESE EL STOCK DEL PRODUCTO: ");
        int cantidadStock = teclado.nextInt();

        Producto nuevoProducto = new Producto(codigo, nombre, descripcion, precio, cantidadStock);
        inventario.agregarProducto(nuevoProducto);
        
        System.out.println("PRODUCTO AGREGADO");
        System.out.println("Presione ENTER para continuar...");
        teclado.nextLine();
        teclado.nextLine();
        Utilitarios.limpiaPantalla();
        menuPrincipal();
    }
    
    static void buscarProducto() {
        System.out.print("INGRESE EL NOMBRE DEL PRODUCTO: ");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        List<Producto> resultados = inventario.buscarProductosPorNombre(nombre);
        if(resultados.isEmpty()){
            System.out.println("NO SE ENCONTRARON PRODUCTOS CON EL NOMBRE: "+nombre);
        } else {
            for (Producto producto : resultados) {
                System.out.println(producto.obtenerProducto());
            }
        }
        System.out.println("Presione ENTER para continuar...");
        teclado.nextLine();
        teclado.nextLine();
        Utilitarios.limpiaPantalla();
        menuPrincipal();
    }
    
    static void eliminarProducto() {
        System.out.print("INGRESE EL CODIGO DEL PRODUCTO A ELIMINAR: ");
        int codigo = teclado.nextInt();
        if (inventario.eliminarProducto(codigo)) {
            System.out.println("PRODUCTO ELIMINADO.");
        } else {
            System.out.println("NO SE ENCONTRO EL PRODUCTO CON CODIGO: "+codigo);
        }
        System.out.println("Presione ENTER para continuar...");
        teclado.nextLine();
        teclado.nextLine();
        Utilitarios.limpiaPantalla();
        menuPrincipal();
    }

    static void listarProductos() {
        List<Producto> productos = inventario.listarProductos();
        if (productos.isEmpty()) {
            System.out.println("NO HAY PRODUCTOS EN EL INVENTARIO");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto.obtenerProducto());
                System.out.println("--------------------");
            }
        }
        System.out.println("Presione ENTER para continuar...");
        teclado.nextLine();
        teclado.nextLine();
        Utilitarios.limpiaPantalla();
        menuPrincipal();
    }
}
