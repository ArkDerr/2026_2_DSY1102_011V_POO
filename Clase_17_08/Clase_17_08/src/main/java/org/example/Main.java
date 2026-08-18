package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo = new Vehiculo("AABB11","Kia",1000);

        vehiculo.mostrarDatos();

        System.out.println("Valor total del arriendo= "+vehiculo.calcularArriendo(10));
        vehiculo.calcularArriendov2(20);
    }
}