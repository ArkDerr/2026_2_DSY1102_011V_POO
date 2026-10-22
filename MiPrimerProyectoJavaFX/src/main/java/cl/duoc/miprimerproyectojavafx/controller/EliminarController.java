package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.model.Persona;
import cl.duoc.miprimerproyectojavafx.repository.PersonaRepository;
import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EliminarController implements Initializable {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cmbTipoPersona;

    private final PersonaRepository repository = PersonaRepository.getInstancia();

    private Persona persona;

    @FXML
    private void eliminarRegistro(){
        if(persona == null){
            mostrarAlerta(Alert.AlertType.WARNING,"Eliminar","Primero realiza una busqueda antes de eliminar");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar Eliminación");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Realmente desea eliminar el registro?: " + persona.getNombre());
        Optional<ButtonType> respuesta = confirmacion.showAndWait();

        try{
            if(respuesta.isPresent() && respuesta.get() == ButtonType.OK){
                repository.eliminar(persona.getRut());
                mostrarAlerta(Alert.AlertType.INFORMATION,"Eliminar","Registro Eliminado.");
                limpiarControles();
            } else {
                limpiarControles();
            }
        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR,"Eliminar","Error al eliminar el registro: " + e.getMessage());
        }

    }

    @FXML
    private void buscarRegistro(){
        try {
            persona = repository.buscarPorRut(txtRut.getText());

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
            mostrarAlerta(Alert.AlertType.WARNING,"Busqueda","No existe una persona con ese rut");
        }
    }


    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarControles(){
        txtRut.clear();
        txtNombre.clear();
        txtApellido.clear();
        dpFechaNacimiento.setValue(null);
        cmbTipoPersona.getSelectionModel().selectFirst();
        txtRut.requestFocus();
    }

    @FXML
    protected void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu Principal");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbTipoPersona.getItems().addAll("Alumno", "Profesor");
        habilitarFormulario(true);
    }

    private void habilitarFormulario(boolean habilitar){
        txtNombre.setDisable(habilitar);
        txtApellido.setDisable(habilitar);
        dpFechaNacimiento.setDisable(habilitar);
        cmbTipoPersona.setDisable(habilitar);
    }
}
