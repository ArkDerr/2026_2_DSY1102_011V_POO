package org.example;


import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Alumno> Alumnos = new ArrayList<>();

        Alumno ana = new Alumno(111, "Ana");
        Alumnos.add(ana);

        Alumno juan = new Alumno(222, "Juan");
        Alumnos.add(juan);

        Alumno Pedro = new Alumno(333, "Pedro");
        Alumnos.add(Pedro);

        int rutbuscado = 222;

        for (Alumno alumno : Alumnos) {
            if (alumno.getRut() == rutbuscado) {
                System.out.println("El alumno existe en la coleccion y es: "+alumno.getNombre());
                System.out.println(alumno.getNombre());
                alumno.setNombre("Juanita");
                System.out.println(alumno.getNombre());
                Alumnos.remove(alumno);
            }
        }

        System.out.println(Alumnos);

    }
}