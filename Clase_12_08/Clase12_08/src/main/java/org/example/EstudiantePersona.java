package org.example;

public class EstudiantePersona extends Persona {

    private String carrera;
    private int mensualidad;

    public EstudiantePersona(String carrera, int mensualidad) {
        this.carrera = carrera;
        this.mensualidad = mensualidad;
    }

    public EstudiantePersona(String nombre, String apellido, int edad, String carrera, int mensualidad) {
        super(nombre, apellido, edad);
        this.carrera = carrera;
        this.mensualidad = mensualidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(int mensualidad) {
        this.mensualidad = mensualidad;
    }

    @Override
    public String toString() {
        return "EstudiantePersona{" +
                "carrera='" + carrera + '\'' +
                ", mensualidad=" + mensualidad +  + '\'' +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
