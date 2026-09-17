package org.bodega;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Colección para guardar productos
        List<Producto> productos = new ArrayList<>();

        Metodos metodos = new Metodos();

        //Scanner
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        while(opcion!=6){

            System.out.println("-----MENU-----");
            System.out.println("1. Crear un producto");
            System.out.println("2. Listar todos los productos");
            System.out.println("3. Buscar un producto");
            System.out.println("4. Editar un producto");
            System.out.println("5. Eliminar un producto");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el codigo del producto: ");
                    int codigoProducto = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombreProducto = sc.nextLine();
                    System.out.println("Ingrese la categoria del producto: ");
                    String categoriaProducto = sc.nextLine();
                    System.out.println("Ingrese la cantidad del producto: ");
                    int cantidadProducto = sc.nextInt();
                    sc.nextLine();

                    if (productos.isEmpty()){
                        Producto p = new Producto(codigoProducto, nombreProducto, categoriaProducto, cantidadProducto);
                        productos.add(p);
                        System.out.println("El producto creado con exito");

                    } else if (metodos.BuscarProducto(codigoProducto,productos)==null) {
                        Producto p = new Producto(codigoProducto, nombreProducto, categoriaProducto, cantidadProducto);
                        productos.add(p);
                        System.out.println("El producto creado con exito");

                    } else {
                        System.out.println("El producto Existe");
                    }


                    break;
                case 2:
                    System.out.println("Listado de productos registrados: ");
                    for(Producto producto: productos){
                        System.out.println(producto);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el codigo del producto que desea buscar: ");
                    int CogidoBuscado = sc.nextInt();
                    sc.nextLine();

                    Producto productoBuscado = metodos.BuscarProducto(CogidoBuscado,productos);

                    if(productoBuscado==null){
                        System.out.println("El producto no existe");
                    }  else {
                        System.out.println("El producto existe y sus datos son: ");
                        System.out.println(productoBuscado.toString());
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el codigo del producto que desea editar: ");
                    int CogidoEditado = sc.nextInt();
                    sc.nextLine();

                    Producto productoEditado = metodos.BuscarProducto(CogidoEditado,productos);

                    if(productoEditado==null){
                        System.out.println("El producto no existe");
                    }  else {
                        //Pregunta que edita
                        System.out.println("Ingrese el nombre del producto: ");
                        String nombreProductoEditar = sc.nextLine();
                        System.out.println("Ingrese la categoria del producto: ");
                        String categoriaProductoEditar = sc.nextLine();
                        System.out.println("Ingrese la cantidad del producto: ");
                        int cantidadProductoEditar = sc.nextInt();
                        sc.nextLine();
                        productoEditado.setNombre(nombreProductoEditar);
                        productoEditado.setCategoria(categoriaProductoEditar);
                        productoEditado.setCantidad(cantidadProductoEditar);
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el codigo del producto que desea eliminar: ");
                    int CogidoEliminar = sc.nextInt();
                    sc.nextLine();
                    Producto productoEliminar = metodos.BuscarProducto(CogidoEliminar,productos);
                    if(productoEliminar==null){
                        System.out.println("El producto no existe");
                    } else {
                        productos.remove(productoEliminar);
                        System.out.println("El producto eliminado con exito");
                    }
                    break;
                case 6:
                    System.out.println("Cerrando el programa...");
                    break;
                default:
                    System.out.println("Ingrese una opción entre 1 y 6");
                    break;
            }
        }
    }
}