/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.ifsc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hayden
 */
public class FXML_iguess implements Initializable {

    /**
 * //Apondando o Label da view (fx:id deve estar apontado no controller)
 *
 * @author hayden
 */
       @FXML // fx:id="botton"
    private Button botton; // Value injected by FXMLLoader

    @FXML // fx:id="mensagem"
    private Label mensagem; // Value injected by FXMLLoader

    @FXML // fx:id="tf_idade"
    private TextField tf_idade; // Value injected by FXMLLoader

    @FXML // fx:id="tf_nome"
    private TextField tf_nome; // Value injected by FXMLLoader

    @FXML
    void actionBotton(ActionEvent event) {
        System.out.println("Calculando...!");
        mensagem.setText(tf_nome.getText() + " a sua idade é " + tf_idade.getText() + " anos");
    }
    
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
