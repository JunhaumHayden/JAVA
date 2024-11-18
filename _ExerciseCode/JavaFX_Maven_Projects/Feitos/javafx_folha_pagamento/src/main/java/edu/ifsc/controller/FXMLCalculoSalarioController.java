/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.ifsc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import edu.ifsc.model.Funcionario;
import edu.ifsc.service.CalculoSalarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author hayden
 */
public class FXMLCalculoSalarioController implements Initializable {

    @FXML
    private TextField tfNome;
    @FXML
    private Spinner<Integer> spIdependente;
    @FXML
    private TextField tfsalario;
    @FXML
    private Button btCalcular;
    @FXML
    private Button btNovo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Definição dos valores do Spinner por meio de um SpinnerValueFactory
        //O primeiro e o segundo parâmetro é a faixa de valores, o terceiro, o valor padrão
        SpinnerValueFactory<Integer> valueFactory = 
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 15, 0);
        spIdependente.setValueFactory(valueFactory);
    }    

    @FXML
    private void handleBtCalcular(ActionEvent event) {
        String nome = tfNome.getText();
        Integer dependente = spIdependente.getValue();
        double salario = Double.parseDouble(tfsalario.getText().replace(",", "."));
        Funcionario funcionario = new Funcionario(nome, salario, dependente);
        
        apresentarResultado(funcionario);
    }

    @FXML
    private void handleBtNovo(ActionEvent event) {
        tfNome.setText(null);
        tfsalario.setText(null);
        spIdependente.getValueFactory().setValue(0);
        tfNome.requestFocus();        
    }

    private void apresentarResultado(Funcionario funcionario) {
        Alert dlgResultado = new Alert(Alert.AlertType.INFORMATION);
        dlgResultado.setTitle("Salario Calculado...");
        dlgResultado.setHeaderText(" Resumo: " + funcionario.getNome());
        // dlgResultado.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog_css.css").toExternalForm());
        dlgResultado.getDialogPane().getStyleClass().add("myDialog");
        dlgResultado.setContentText("Valor do Salario: R$" + String.format("%.2f", new CalculoSalarioService().calcularSalarioLiquido(funcionario)));
        dlgResultado.showAndWait();        
    }
    
}

