package org.arriendo;

import java.time.LocalDate;

public class Moto extends Vehiculo implements Arrendable, Mantenible{

    private int cilindrada;

    public Moto(String patente, String marca, int anio, double tarifaDiaria, LocalDate fechaRegistro, int cilindrada) {
        super(patente, marca, anio, tarifaDiaria, fechaRegistro);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularArriendo(int dias) {
        return (getTarifaDiaria() * dias) * 0.90;
    }

    @Override
    public void arrendar(){
        if (isDisponible()){
            setDisponible(false);
            System.out.println("La moto patente: " + getPatente() + " Fue arrendado");
        } else {
            System.out.println("La moto patente: " + getPatente() + " no esta disponible");
        }
    }

    @Override
    public void devolver(){
        if (!isDisponible()){
            setDisponible(true);
            System.out.println("La moto patente: " + getPatente() + " Fue devuelto");
        } else {
            System.out.println("La moto patente: " + getPatente() + " el auto ya fue devuelto");
        }
    }

    @Override
    public void realizarMantenimiento(){
        System.out.println("La moto patente: " + getPatente() + " Fue realizado el mantenimiento");
    }
}
