package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.model.Persona;
import cl.duoc.miprimerproyectojavafx.repository.PersonaRepository;
import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BuscarController {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cmbTipoPersona;

    private final PersonaRepository repository = PersonaRepository.getInstancia();

    @FXML
    private void buscarRegistro(){
        try {
            Persona persona = repository.buscarPorRut(txtRut.getText());

            if(persona == null){
                mostrarAlerta(Alert.AlertType.WARNING,"Busqueda","No existe una persona con ese rut");
                limpiarControles();
                return;
            }

            txtNombre.setText(persona.getNombre());
            txtApellido.setText(persona.getApellido());
            dpFechaNacimiento.setValue(persona.getFechaNacimiento());
            cmbTipoPersona.getItems().setAll("Alumno", "Profesor");
            cmbTipoPersona.getSelectionModel().select(persona.getTipo());

        } catch (IllegalArgumentException e) {

        }
    }

    private void limpiarControles(){
        txtRut.clear();
        txtNombre.clear();
        txtApellido.clear();
        dpFechaNacimiento.setValue(null);
        cmbTipoPersona.getSelectionModel().selectFirst();
        txtRut.requestFocus();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    protected void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu Principal");
    }
}
