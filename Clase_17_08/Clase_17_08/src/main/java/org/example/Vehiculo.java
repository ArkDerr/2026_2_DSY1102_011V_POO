package org.example;

public class Vehiculo {

    //Atributos
    protected String patente;
    protected String marca;
    protected int precioPorDia;

    //Constructor
    public Vehiculo(String patente, String marca, int precioPorDia) {
        this.patente = patente;
        this.marca = marca;
        this.precioPorDia = precioPorDia;
    }

    //Get y Set
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(int precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    //Metodos

    //Mostrar los datos del objeto
    public void mostrarDatos(){
        System.out.println("Patente: "+patente);
        System.out.println("Marca: "+marca);
        System.out.println("Precio por dia: "+precioPorDia);
    }

    //Calcular el valor del arriendo
    public int calcularArriendo(int dias){
        int total = precioPorDia*dias;
        return total;
    }

    public void calcularArriendov2(int dias){
        int total = precioPorDia*dias;
        System.out.println("Valor total del arriendov2= "+total);
    }
}
