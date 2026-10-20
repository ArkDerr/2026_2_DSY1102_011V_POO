package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.model.Alumno;
import cl.duoc.miprimerproyectojavafx.model.Persona;
import cl.duoc.miprimerproyectojavafx.model.Profesor;
import cl.duoc.miprimerproyectojavafx.repository.PersonaRepository;
import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrearController implements Initializable {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cmbTipoPersona;

    private final PersonaRepository repository = PersonaRepository.getInstancia();

    @FXML
    protected void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu Principal");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbTipoPersona.getItems().addAll("Alumno", "Profesor");
        cmbTipoPersona.getSelectionModel().selectFirst();
    }

    @FXML
    protected void onGuardarButtonClick(ActionEvent event) throws IOException {
        try {

            Persona nuevaPersona;

            if("Profesor".equals(cmbTipoPersona.getSelectionModel().getSelectedItem())) {
                nuevaPersona = new Profesor(
                        txtRut.getText(),
                        txtNombre.getText(),
                        txtApellido.getText(),
                        dpFechaNacimiento.getValue()
                );
            } else {
                nuevaPersona = new Alumno(
                        txtRut.getText(),
                        txtNombre.getText(),
                        txtApellido.getText(),
                        dpFechaNacimiento.getValue()
                );
            }

            repository.agregar(nuevaPersona);

            limpiarControles();

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

    @FXML
    protected void onLimpiarButtonClick(ActionEvent event) throws IOException {
        limpiarControles();
    }
}
