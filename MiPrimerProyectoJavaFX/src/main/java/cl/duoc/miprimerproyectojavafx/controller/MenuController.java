package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.Navegacion;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController {

    @FXML
    protected void onCrearButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"crear-view.fxml","Crear Persona");
    }

    @FXML
    private void onSalirButtonClick(ActionEvent event) throws IOException {
        Platform.exit();
    }
}
