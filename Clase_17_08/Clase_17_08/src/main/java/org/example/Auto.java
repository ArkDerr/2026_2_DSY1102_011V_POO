package org.example;

public class Auto extends Vehiculo {
    //Atributo
    protected String color;

    //Constructor
    public Auto(String patente, String marca, int precioPorDia, String color) {
        super(patente, marca, precioPorDia);
        this.color = color;
    }

    //Get y Set
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //Metodos
    //(Polimorfismo)
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Color: "+color);
    }

    //Calcular el valor del arriendo con descuento
    //Sobrecarga
    public int calcularArriendo(int dias, int descuento){
        int total = precioPorDia*dias;
        int totalConDescuento = total - descuento;
        return totalConDescuento;
    }
}
