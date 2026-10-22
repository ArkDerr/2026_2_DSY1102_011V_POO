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

    public Persona buscarPorRut(String rut) {
        if (rut == null || rut.isEmpty()) {
            throw new IllegalArgumentException("La rut no puede ser nulo o vacio.");
        }

        for (Persona p : personas) {
            if (p.getRut().equalsIgnoreCase(rut.trim())) {
                return p;
            }
        }

        return null;
    }

    public void actualizar(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nulo.");
        }
        for (Persona p : personas) {
            if (p.getRut().equalsIgnoreCase(persona.getRut())) {
                p.setNombre(persona.getNombre());
                p.setApellido(persona.getApellido());
                p.setFechaNacimiento(persona.getFechaNacimiento());
                return;
            }
        }
        throw new IllegalArgumentException("No existe una persona con ese rut.");
    }

    public void eliminar(String rut) {
        Persona p = buscarPorRut(rut);
        if (p == null) {
            throw  new IllegalArgumentException("No existe una persona con ese rut: " + rut);
        }
        personas.remove(p);
    }

}
