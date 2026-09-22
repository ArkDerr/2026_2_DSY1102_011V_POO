package org.ejemploexception;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Producto p = new Producto("Pila", 10);

            System.out.println(p.toString());

            p.descontarStock(20);

            System.out.println(p.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (StockInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}