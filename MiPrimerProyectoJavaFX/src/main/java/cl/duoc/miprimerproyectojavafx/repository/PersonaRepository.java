package cl.duoc.miprimerproyectojavafx.repository;

import cl.duoc.miprimerproyectojavafx.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

    private final List<Persona> personas = new ArrayList<>();

    private static final PersonaRepository instancia = new PersonaRepository();

    public PersonaRepository() {
    }

    public static PersonaRepository getInstancia() {
        return instancia;
    }

    public void agregar(Persona persona) {
        if(persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nulo.");
        }

        if (existeRut(persona.getRut())){
            throw new IllegalArgumentException("La persona ya existe");
        }

        personas.add(persona);
    }

    public List<Persona> ListarTodos() {
        return new ArrayList<>(personas);
    }

    private boolean existeRut(String rut) {
        for (Persona p : personas) {
            if (p.getRut().equalsIgnoreCase(rut.trim())) {
                return true;
            }
        }
        return false;
    }

}
