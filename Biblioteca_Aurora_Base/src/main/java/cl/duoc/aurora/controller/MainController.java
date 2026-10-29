package cl.duoc.aurora.controller;

import cl.duoc.aurora.model.Material;
import cl.duoc.aurora.model.Revista;
import cl.duoc.aurora.repository.MaterialRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //Registrar
    @FXML private ComboBox<String> cbxTipo;
    @FXML private TextField txtCodigo;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtDias;
    @FXML private TextField txtAutor;
    @FXML private CheckBox chkEspecial;
    @FXML private CheckBox chkNovedad;
    //Tabla
    @FXML private TableView<Material> tblMateriales;
    @FXML private TableColumn<Material, String> colTipo;
    @FXML private TableColumn<Material, String> colCodigo;
    @FXML private TableColumn<Material, String> colTitulo;
    @FXML private TableColumn<Material, String> colDias;
    @FXML private TableColumn<Material, String> colTarifa;
    //Mensaje
    @FXML private Label lblMensaje;

    private final MaterialRepository repository = new MaterialRepository();

    private final ObservableList<Material> listaMateriales = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbxTipo.getItems().addAll("Libro","Revista");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colDias.setCellValueFactory(new PropertyValueFactory<>("dias"));
        colTarifa.setCellValueFactory(new PropertyValueFactory<>("tarifa"));

        tblMateriales.setItems(listaMateriales);

        cbxTipo.setOnAction(event -> cambiarTipo());

        txtAutor.setDisable(true);
        chkEspecial.setDisable(true);
        chkNovedad.setDisable(true);

        try {
            listaMateriales.setAll(repository.listar());
            //mostrarMensaje("Materiales cargados correctamente.", false);
        } catch (RuntimeException e) {
            //mostrarMensaje(e.getMessage(), true);
        }
    }

    private void cambiarTipo() {
        String tipo = cbxTipo.getValue();
        boolean esLibro = "Libro".equals(tipo);
        boolean esRevista = "Revista".equals(tipo);

        txtAutor.setDisable(!esLibro);

        chkNovedad.setDisable(!esLibro);

        chkEspecial.setDisable(!esRevista);

    }
}
