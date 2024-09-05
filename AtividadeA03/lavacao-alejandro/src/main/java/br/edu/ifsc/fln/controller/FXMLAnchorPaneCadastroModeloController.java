/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.ifsc.fln.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;import javafx.fxml.Initializable;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
/**
 * FXML Controller class
 *
 * @author Sentinel
 */
public class FXMLAnchorPaneCadastroModeloController implements Initializable {


    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> tableColumnId;
    @FXML
    private TableColumn<?, ?> tableColumnDescricao;
    @FXML
    private TableColumn<?, ?> tableColumnMarca;
    @FXML
    private Label lbModeloId;
    @FXML
    private Label lbModeloDescricao;
    @FXML
    private Label lbModeloMarca;
    @FXML
    private Button btInserir;
    @FXML
    private Button btAlterar;
    @FXML
    private Button btRemover;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleBtInserir(ActionEvent event) {
    }

    @FXML
    private void handleBtAlterar(ActionEvent event) {
    }

    @FXML
    private void handleBtRemover(ActionEvent event) {
    }

}
