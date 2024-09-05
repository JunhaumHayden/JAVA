package br.edu.ifsc.fln.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class para cadastro de Serviço
 *
 * @author Sentinel
 */
public class FXMLAnchorPaneCadastroServicoController implements Initializable {

    @FXML
    private TableView<?> tableView;
    
    @FXML
    private TableColumn<?, ?> tableColumnId;
    
    @FXML
    private TableColumn<?, ?> tableColumnDescricao;
    
    @FXML
    private TableColumn<?, ?> tableColumnValor;
    
    @FXML
    private TableColumn<?, ?> tableColumnPontos;

    @FXML
    private Label lbServicoId;
    
    @FXML
    private Label lbServicoDescricao;
    
    @FXML
    private Label lbServicoValor;
    
    @FXML
    private Label lbServicoPontos;

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