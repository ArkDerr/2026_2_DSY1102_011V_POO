package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.model.Alumno;
import cl.duoc.miprimerproyectojavafx.model.Persona;
import cl.duoc.miprimerproyectojavafx.model.Profesor;
import cl.duoc.miprimerproyectojavafx.repository.PersonaRepository;
import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditarController implements Initializable {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cmbTipoPersona;

    private final PersonaRepository repository = PersonaRepository.getInstancia();

    private Persona persona;

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
            habilitarFormulario(false);
        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.WARNING,"Busqueda","No existe una persona con ese rut");
        }
    }

    @FXML
    protected void LimparControles(ActionEvent event) throws IOException {
        limpiarControles();
    }

    @FXML
    protected void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu Principal");
    }

    @FXML
    private void actualizarRegistro(){
        if(persona == null){
            mostrarAlerta(Alert.AlertType.WARNING,"Busqueda","No existe una persona con ese rut");
            return;
        }

        try {
            Persona personaActualizar;

            if("Profesor".equals(cmbTipoPersona.getSelectionModel().getSelectedItem())){
                personaActualizar = new Profesor(txtRut.getText(),txtNombre.getText(),txtApellido.getText(),dpFechaNacimiento.getValue());
            } else {
                personaActualizar = new Alumno(txtRut.getText(),txtNombre.getText(),txtApellido.getText(),dpFechaNacimiento.getValue());
            }

            repository.actualizar(personaActualizar);
            mostrarAlerta(Alert.AlertType.INFORMATION,"Actualizacion","Se realizo la actualizacion de manera exitosa.");
            limpiarControles();

        } catch(IllegalArgumentException e){
            mostrarAlerta(Alert.AlertType.ERROR,"Actualizar","No se pudo actualizar el registro");
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
