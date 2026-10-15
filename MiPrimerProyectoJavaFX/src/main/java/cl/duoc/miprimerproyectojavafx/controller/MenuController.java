package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.util.Navegacion;
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
    protected void onBuscarButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"buscar-view.fxml","Buscar Persona");
    }

    @FXML
    protected void onListarButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"listar-view.fxml","Listar Personas");
    }

    @FXML
    protected void onEditarButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"editar-view.fxml","Editar Persona");
    }

    @FXML
    protected void onEliminarButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"eliminar-view.fxml","Eliminar Persona");
    }

    @FXML
    private void onSalirButtonClick(ActionEvent event) throws IOException {
        Platform.exit();
    }
}
