package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Persona persona1 = new Persona("Daniel", "Riquelme", 18);
        EstudiantePersona estudiante1 = new EstudiantePersona("Alan", "Brito", 25, "Informatica", 500);

        System.out.println(estudiante1.toString());

        estudiante1.setCarrera("Mecanica");
        estudiante1.setEdad(19);

        System.out.println(estudiante1.toString());


        System.out.println(estudiante1.getNombre());

    }
}