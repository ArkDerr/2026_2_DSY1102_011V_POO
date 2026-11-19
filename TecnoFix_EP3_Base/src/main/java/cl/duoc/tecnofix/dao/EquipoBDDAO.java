package cl.duoc.tecnofix.dao;

import cl.duoc.tecnofix.config.conexionBD;
import cl.duoc.tecnofix.model.Equipo;
import cl.duoc.tecnofix.model.Monitor;
import cl.duoc.tecnofix.model.Notebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoBDDAO implements EquipoDAO {

    @Override
    public List<Equipo> obtenerTodos() {
        List<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT id, nombre, edad, peso, tipo, marca, diagnosticado, reventa, intensivo FROM equipo";
        try(Connection con= conexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                double peso = rs.getDouble("peso");
                String tipo = rs.getString("tipo");

                if ("Notebook".equals(tipo)) {
                    String marca = rs.getString("marca");
                    boolean diagnosticado = rs.getBoolean("diagnosticado");
                    boolean reventa = rs.getBoolean("reventa");
                    Notebook notebook = new Notebook(nombre, edad, peso, marca, diagnosticado);
                    equipos.add(notebook);
                } else if ("Monitor".equals(tipo)) {
                    boolean intensivo = rs.getBoolean("intensivo");
                    Monitor monitor = new Monitor(nombre, edad, peso, intensivo);
                    equipos.add(monitor);
                } else {
                    throw new SQLException("Tipo desconocido: " + tipo);
                }
            }
            return equipos;
        }  catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void insertar(Equipo equipo) {
        String sql = "INSERT INTO equipo " +
                "(nombre, edad, peso, tipo, marca, diagnosticado, reventa, intesivo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = conexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            if (equipo instanceof Notebook notebook) {
                ps.setString(1, equipo.getNombre());
                ps.setInt(2,equipo.getEdad());
                ps.setDouble(3,equipo.getPeso());
                ps.setString(4,"Notebook");
                ps.setString(5,((Notebook) equipo).getMarca());

                if(((Notebook) equipo).isDiagnosticado()){
                    ps.setInt(6,1);
                } else {
                    ps.setInt(6,0);
                }

                if (((Notebook) equipo).estaDisponibleParaReventa()){
                    extracted(ps);
                } else {
                    ps.setInt(7,0);
                }

                ps.setInt(8,0);
            } else if (equipo instanceof Monitor monitor) {
                ps.setString(1, equipo.getNombre());
                ps.setInt(2,equipo.getEdad());
                ps.setDouble(3,equipo.getPeso());
                ps.setString(4,"Notebook");
                ps.setString(5,((Notebook) equipo).getMarca());

                ps.setInt(6,0);
                ps.setInt(7,0);

                if(((Monitor) equipo).isIntensivo()){
                    ps.setInt(8,1);
                } else {
                    ps.setInt(8,0);
                }
            } else {
                throw new IllegalArgumentException("Tipo de material no válido.");
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public void actualizar(Equipo equipo) {

    }

    @Override
    public void eliminar(int id) {

    }
}
