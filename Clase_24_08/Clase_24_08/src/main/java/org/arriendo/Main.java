package org.arriendo;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Auto auto = new Auto(
                "AAAA-10",
                "Toyota",
                2024,
                30000,
                LocalDate.of(2026, 3, 15),
                4
        );

        Moto moto = new Moto(
                "BBBB-20",
                "Honda",
                2023,
                20000,
                LocalDate.of(2026, 5, 10),
                250
        );

        Scanner sc = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("#################################");
            System.out.println("##### Seleccione una opcion #####");
            System.out.println("1. Mostrar datos del auto");
            System.out.println("2. Mostrar datos de la moto");
            System.out.println("3. Calcular arriendo del auto");
            System.out.println("4. Calcular arriendo de la moto");
            System.out.println("5. Arrendar auto");
            System.out.println("6. Arrendar moto");
            System.out.println("7. Devolver auto");
            System.out.println("8. Devolver moto");
            System.out.println("9. Mantenimiento auto");
            System.out.println("10. Mantenimiento auto");
            System.out.println("0. Salir");
            System.out.println("#################################");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ingrese un valor numerico");
                sc.nextLine();
            }

            switch (opcion) {
                case 1:
                    auto.mostrarDatos();
                    break;
                case 2:
                    moto.mostrarDatos();
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad de dias: ");
                    int diasAuto = sc.nextInt();
                    sc.nextLine();
                    double totalArriendoAuto = auto.calcularArriendo(diasAuto);
                    System.out.println("El valor diario de arriendo es: " + auto.getTarifaDiaria());
                    System.out.println("El total del arriendo es: " + totalArriendoAuto);
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad de dias: ");
                    int diasMoto = sc.nextInt();
                    sc.nextLine();
                    double totalArriendoMoto = moto.calcularArriendo(diasMoto);
                    System.out.println("El valor diario de arriendo es: " + auto.getTarifaDiaria());
                    System.out.println("El total del arriendo es: " + totalArriendoMoto);
                    break;
                case 5:
                    auto.arrendar();
                    break;
                case 6:
                    moto.arrendar();
                    break;
                case 7:
                    auto.devolver();
                    break;
                case 8:
                    moto.devolver();
                    break;
                case 9:
                    auto.realizarMantenimiento();
                    break;
                case 10:
                    moto.realizarMantenimiento();
                    break;
                case 0:
                    System.out.println("Gracias por utilizar mi app");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }

        }
    }
}