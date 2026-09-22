package org.ejemploexception;

public class StockInsuficienteException extends Exception {

    public StockInsuficienteException(String message) {
        super(message);
    }
}
