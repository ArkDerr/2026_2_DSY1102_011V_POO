package org.example;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*
        Vehiculo vehiculo = new Vehiculo("AABB11","Kia",1000);
        vehiculo.mostrarDatos();
        System.out.println("Valor total del arriendo= "+vehiculo.calcularArriendo(10));
        vehiculo.calcularArriendov2(20);
        Auto auto = new Auto("CCDD22", "Jac", 5000, "Rojo");
        System.out.println("Valor total del arriendo="+auto.calcularArriendo(10, 500));
        System.out.println("Valor total del arriendo="+auto.calcularArriendo(10));
        */

        //Objeto para capturar por teclado
        Scanner sc = new Scanner(System.in);

        //Objeto Vacio
        Auto auto = null;

        //Variable opciones
        int opcion = 0;

        while(opcion!=5){

            System.out.println();
            System.out.println("===== ARRIENDO DE VEHICULOS =====");
            System.out.println("1. Ingresar datos del auto");
            System.out.println("2. Mostrar datos del auto");
            System.out.println("3. Calcular valor del arriendo");
            System.out.println("4. Calcular valor del arriendo con descuento");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion:");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    System.out.println("Ingresar datos del auto");
                    System.out.println("Ingresar patente");
                    String patente = sc.nextLine();
                    System.out.println("Ingresar marca del auto");
                    String marca = sc.nextLine();
                    System.out.println("Ingresar valor del arriendo");
                    int valor = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresar color del auto");
                    String color = sc.nextLine();

                    auto = new Auto(patente,marca,valor,color);
                    System.out.println("Auto se registro correctamente");

                    break;
                case 2:
                    if (auto != null){
                        auto.mostrarDatos();
                    } else {
                        System.out.println("No existe el auto");
                    }
                    break;
                case 3:
                    if (auto != null){
                        System.out.println("Ingresar cantidad de dias en arriendo:");
                        int dias = sc.nextInt();
                        sc.nextLine();
                        System.out.println("El valor total del arriendo es:"+auto.calcularArriendo(dias));
                    } else {
                        System.out.println("No existe el auto");
                    }
                    break;
                case 4:
                    if (auto != null){
                        System.out.println("Ingresar cantidad de dias en arriendo:");
                        int dias = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese el descuento:");
                        int descuento = sc.nextInt();
                        sc.nextLine();
                        System.out.println("El valor total del arriendo es:"+auto.calcularArriendo(dias,descuento));
                    } else {
                        System.out.println("No existe el auto");
                    }
                    break;
                case 5:
                    System.out.println("Gracias por utilizar mi super APP");
                    break;
            }
        }
    }
}