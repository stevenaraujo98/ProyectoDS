/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dbmanager.Procedure;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Contact;
import modelo.Empleado;
import vista.AdminView;

/**
 * FXML Controller class
 *
 * @author SSAM
 */
public class AsignacionAdminController implements Initializable {
    @FXML
    TableView<Empleado> tabla;
    @FXML
    TableColumn<Empleado, String> columnaCedula;
    @FXML
    TableColumn<Empleado, String> columnaNombres;
    @FXML
    TableColumn<Empleado, String> columnaApellidos;
    @FXML
    TableColumn<Empleado, String> columnaTelefono;
    @FXML
    TableColumn<Empleado, Double> columnaSalario;
    @FXML
    TableColumn<Empleado, String> columnaEmail;
    @FXML
    TableColumn<Empleado, Integer> columnaIdlocal;    
    @FXML
    TableColumn<Empleado, Integer> columnaTipoempleado;
    @FXML
    ComboBox<String> combolocales;
    @FXML
    Button botonasignar;
    @FXML
    Button botonquitarasigacion;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnaCedula.setCellValueFactory(new PropertyValueFactory<>("dni"));
        columnaNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        columnaApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnaSalario.setCellValueFactory(new PropertyValueFactory<>("sueldo"));
        columnaEmail.setCellValueFactory(new PropertyValueFactory<>("correo"));
        columnaTipoempleado.setCellValueFactory(new PropertyValueFactory<>("tipoDeEmpleado"));
        cargarDatos();
    }    
        
    public void cargarDatos(){
        String query = "select nombre from Locales";
        try {
            ResultSet rs = ConexionDB.getInstance().getStatement().executeQuery(query);
            if(rs != null){
                while(rs.next()){
                    combolocales.getItems().add(rs.getString(1));
                    combolocales.setOnAction(e -> {
                        String item = combolocales.getSelectionModel().getSelectedItem();
                        Procedure procedure = new Procedure("empleadosByIDLocal").addValue(item);
                        ResultSet consultaEmpleados;
                        try {
                            consultaEmpleados = ConexionDB.getInstance().executeProcedureResult(procedure);
                            agregarATabla(consultaEmpleados);
                        } catch (SQLException ex) {
                            Logger.getLogger(AsignacionAdminController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarATabla(ResultSet resultado) throws SQLException{
        ObservableList<Empleado> lista;
        lista = FXCollections.observableArrayList();
        while(resultado.next()){
            String cedula = resultado.getString(1);
            String nombres = resultado.getString(2);
            String apellidos = resultado.getString(3);
            String telefono = resultado.getString(4);
            Double salario  = (double)resultado.getFloat(5);
            String email = resultado.getString(6);
            Integer tipoempleado = resultado.getInt(8);
            //int id, String nombreUsuario, String clave, Empleado emp
            lista.add(new Empleado(cedula, nombres, apellidos, new Contact(email,telefono), salario, tipoempleado));
        }
        if(tabla.getItems().size() > 0){
            tabla.getItems().clear();
        }
        tabla.setItems(lista);
    }
}
