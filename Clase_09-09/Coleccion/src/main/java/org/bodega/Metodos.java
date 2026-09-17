package org.bodega;

import java.util.List;

public class Metodos {

    public Producto BuscarProducto(int id, List<Producto> productos) {
        for (Producto p : productos) {
            if (id == p.getCodigo()) {
                return p;
            }
        }
        return null;
    }
}
