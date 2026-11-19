package cl.duoc.aurora.controller;

import cl.duoc.aurora.model.Libro;
import cl.duoc.aurora.model.Material;
import cl.duoc.aurora.model.Revista;
import cl.duoc.aurora.repository.MaterialRepository;
<<<<<<< HEAD
=======
import cl.duoc.aurora.services.MaterialService;
>>>>>>> a422829bbf796b7cd346c974a2b248ae077c6dd0
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //Controles Registrar
    @FXML private ComboBox<String> cbxTipo;
    @FXML private TextField txtCodigo;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtDias;
    @FXML private TextField txtAutor;
    @FXML private CheckBox chkEspecial;
    @FXML private CheckBox chkNovedad;

    //Controles Tabla
    @FXML private TableView<Material> tblMateriales;
    @FXML private TableColumn<Material, String> colTipo;
    @FXML private TableColumn<Material, String> colCodigo;
    @FXML private TableColumn<Material, String> colTitulo;
    @FXML private TableColumn<Material, String> colDias;
    @FXML private TableColumn<Material, String> colTarifa;

    //Mensaje
    @FXML private Label lblMensaje;

    private final MaterialRepository repository = new MaterialRepository();

    private final MaterialService service = new MaterialService();

    private final ObservableList<Material> listaMateriales = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbxTipo.getItems().addAll("Libro","Revista");

<<<<<<< HEAD
        try {
            repository.cargar();
        } catch (Exception e) {
            mostrarMensaje("No se pudo leer archivos JSON", true);
        }

=======
>>>>>>> a422829bbf796b7cd346c974a2b248ae077c6dd0
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colDias.setCellValueFactory(new PropertyValueFactory<>("dias"));
        //colTarifa.setCellValueFactory(new PropertyValueFactory<>("tarifa"));

        colTarifa.setCellValueFactory(datos -> new SimpleObjectProperty<>(datos.getValue().calcularTarifa()).asString());

        colTarifa.setCellValueFactory(datos -> new SimpleObjectProperty<>(datos.getValue().calcularTarifa()).asString());

        tblMateriales.setItems(listaMateriales);

        cbxTipo.setOnAction(event -> cambiarTipo());

        try {
            repository.cargar();
        } catch (IOException ex) {
            mostrarMensaje(ex.getMessage(), true);
        }

        txtAutor.setDisable(true);
        chkEspecial.setDisable(true);
        chkNovedad.setDisable(true);

<<<<<<< HEAD
        try {
            listaMateriales.setAll(repository.listar());
            mostrarMensaje("Materiales cargados correctamente.", false);
        } catch (RuntimeException e) {
=======
        try{
            //listaMateriales.setAll(repository.listar());
            actualizarTablaDesdeBD();
            mostrarMensaje("Materiales Cargados", false);
        } catch (SQLException e) {
>>>>>>> a422829bbf796b7cd346c974a2b248ae077c6dd0
            mostrarMensaje(e.getMessage(), true);
        }
    }

    private void cambiarTipo(){
        String tipo = cbxTipo.getValue();

        boolean esLibro = "Libro".equals(tipo);
        boolean esRevista = "Revista".equals(tipo);

        txtAutor.setDisable(!esLibro);
        chkNovedad.setDisable(!esLibro);
        chkEspecial.setDisable(!esRevista);
    }

    private void mostrarMensaje(String mensaje, boolean error) {
        lblMensaje.setText(mensaje);
        if (error) {
            lblMensaje.setStyle("-fx-text-fill: red;");
        } else {
            lblMensaje.setStyle("-fx-text-fill: green;");
        }
    }

    @FXML
    private void guardar(){
        try {

            String tipo = cbxTipo.getValue();

            if (tipo == null) {
                throw new Exception("Debe seleccionar un tipo");
            }

            String codigo = txtCodigo.getText();
            String titulo = txtTitulo.getText();

            int dias;

            try {
                dias = Integer.parseInt(txtDias.getText());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Debe ingresar un valor numerico para dias");
            }

            Material material;

            if ("Libro".equals(tipo)) {
                material = new Libro(codigo,titulo,dias,txtAutor.getText(),chkNovedad.isSelected());
            } else {
                material = new Revista(codigo,titulo,dias,chkEspecial.isSelected());
            }

            repository.registar(material);

            listaMateriales.setAll(repository.listar());

            mostrarMensaje("Registro creado exitosamente.", false);

            limpiarFormulario();

        } catch (Exception e) {
            mostrarMensaje(e.getMessage(), true);
        }
    }

    private void limpiarFormulario() {
        txtCodigo.clear();
        txtTitulo.clear();
        txtDias.clear();
        cbxTipo.getSelectionModel().clearSelection();
        chkNovedad.setSelected(false);
        chkEspecial.setSelected(false);
        txtAutor.setDisable(true);
        chkEspecial.setDisable(true);
        chkNovedad.setDisable(true);
    }

    @FXML
    private void eliminar(){
        Material seleccionado = tblMateriales.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarMensaje("Seleccione un material para eliminar.", false);
            return;
        }

        try {
            repository.eliminar(seleccionado);
            listaMateriales.setAll(repository.listar());
            mostrarMensaje("Registro eliminado exitosamente.", false);
        } catch (Exception e) {
            mostrarMensaje(e.getMessage(), true);
        }

    }

    private void mostrarMensaje(String mensaje, boolean error){
        lblMensaje.setText(mensaje);

        if(error){
            lblMensaje.setStyle("-fx-text-fill: red;");
        } else {
            lblMensaje.setStyle("-fx-text-fill: green;");
        }
    }

    @FXML
    private void registrar(){
        try {
            String tipo = cbxTipo.getValue();

            if (tipo == null) {
                throw new IllegalArgumentException("El tipo de material no puede ser nulo");
            }

            String codigo = txtCodigo.getText();
            String titulo = txtTitulo.getText();

            int dias;

            try {
                dias = Integer.parseInt(txtDias.getText().trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Los deias deben ser numeros");
            }

            Material material;

            if("Libro".equals(tipo)){
                material = new Libro(codigo, titulo, dias,txtAutor.getText(), chkEspecial.isSelected());
            } else {
                material = new Revista(codigo,titulo,dias,chkNovedad.isSelected());
            }

            //Registro
            repository.registrar(material);
            service.registrar(material);

            //Actualizar tabla
            //listaMateriales.setAll(repository.listar());
            actualizarTablaDesdeBD();

            //Informar
            mostrarMensaje("Material Registrado", false);

            //Limpiar
            limpiarFormulario();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void eliminar(){
        Material seleccionado = tblMateriales.getSelectionModel().getSelectedItem();

        if(seleccionado == null){
            mostrarMensaje("Debe Seleccionar un material de la tabla para eliminar", true);
            return;
        }

        try {
            repository.eliminar(seleccionado);
            service.eliminar(seleccionado.getCodigo());
            //Actualizar tabla
            //listaMateriales.setAll(repository.listar());
            actualizarTablaDesdeBD();
            mostrarMensaje("Material Eliminado", false);
        }  catch (Exception e) {
            mostrarMensaje(e.getMessage(), true);
        }

    }


    private void limpiarFormulario(){
        cbxTipo.getSelectionModel().clearSelection();
        txtCodigo.clear();
        txtTitulo.clear();
        txtDias.clear();
        txtAutor.clear();

        chkEspecial.setSelected(false);
        chkNovedad.setSelected(false);

        txtAutor.setDisable(true);
        chkEspecial.setDisable(true);
        chkNovedad.setDisable(true);
    }

    private void actualizarTablaDesdeBD () throws SQLException {
        listaMateriales.setAll(service.listar());
    }
}
