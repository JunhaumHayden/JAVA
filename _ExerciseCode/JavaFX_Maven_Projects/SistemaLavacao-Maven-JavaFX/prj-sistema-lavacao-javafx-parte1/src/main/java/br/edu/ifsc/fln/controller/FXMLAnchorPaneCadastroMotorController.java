/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.fln.controller;

import br.edu.ifsc.fln.model.dao.EstoqueDAO;
import br.edu.ifsc.fln.model.database.Database;
import br.edu.ifsc.fln.model.database.DatabaseFactory;
import br.edu.ifsc.fln.model.domain.Modelo;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ifsc.fln.model.domain.veiculos.Modelo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author mpisching
 */
public class FXMLAnchorPaneCadastroMotorController implements Initializable {

    @FXML
    private Button btAlterar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btInserir;

    @FXML
    private Label lbModeloDescricao;

    @FXML
    private Label lbModeloId;

    @FXML
    private Label lbMotorId;

    @FXML
    private Label lbMotorPotencia;

    @FXML
    private TableColumn<Modelo, String> tableColumnModeloDescricao;

    @FXML
    private TableView<Modelo> tableViewModelos;

    @FXML
    void handleBtAlterar(ActionEvent event) {

    }

    @FXML
    void handleBtExcluir(ActionEvent event) {

    }

    @FXML
    void handleBtInserir(ActionEvent event) {

    }
    
    private List<Modelo> listaModelos;
    private ObservableList<Modelo> observableListModelos;

    //acesso ao banco de dados
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final EstoqueDAO estoqueDAO = new EstoqueDAO();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estoqueDAO.setConnection(connection);

        carregarTableView();

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableView(newValue));

    }

    public void carregarTableView() {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("estoque"));
        
        listaModelos = estoqueDAO.listar();
        
        observableListModelos = FXCollections.observableArrayList(listaModelos);
        tableView.setItems(observableListModelos);
    }
    
    public void selecionarItemTableView(Modelo produto) {
        DecimalFormat df = new DecimalFormat("0.00");
        if (produto != null) {
            lbModeloId.setText(Integer.toString(produto.getId()));
            lbModeloNome.setText(produto.getNome());
            lbModeloDescricao.setText(produto.getDescricao());
            lbModeloPreco.setText(df.format(produto.getPreco().doubleValue()));
            lbModeloQuantidade.setText(Integer.toString(produto.getEstoque().getQuantidade()));
            lbModeloQtdMinima.setText(Integer.toString(produto.getEstoque().getQtdMinima()));
            lbModeloQtdMaxima.setText(Integer.toString(produto.getEstoque().getQtdMaxima()));
            lbModeloSituacao.setText(produto.getEstoque().getSituacao().getDescricao());
        } else {
            lbModeloId.setText("");
            lbModeloNome.setText("");
            lbModeloDescricao.setText("");
            lbModeloPreco.setText("");
            lbModeloQuantidade.setText("");
            lbModeloQtdMinima.setText("");
            lbModeloQtdMaxima.setText("");
            lbModeloSituacao.setText("");
        }
    }
    

    @FXML
    public void handleBtRepor() throws IOException {
        Modelo produto = tableView.getSelectionModel().getSelectedItem();
        if (produto != null) {
            boolean buttonConfirmarClicked = showFXMLAnchorPaneProcessoEstoqueMovimentacaoDialog(produto, "Repor");
            if (buttonConfirmarClicked) {
                estoqueDAO.atualizar(produto.getEstoque());
                carregarTableView();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um produto na tabela ao lado.");
            alert.show();
        }
    }
    
    @FXML
    public void handleBtRetirar() throws IOException {
        Modelo produto = tableView.getSelectionModel().getSelectedItem();
        if (produto != null) {
            boolean buttonConfirmarClicked = showFXMLAnchorPaneProcessoEstoqueMovimentacaoDialog(produto, "Retirar");
            if (buttonConfirmarClicked) {
                estoqueDAO.atualizar(produto.getEstoque());
                carregarTableView();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um produto na tabela ao lado.");
            alert.show();
        }
    }
    
    @FXML
    public void handleBtAtualizar() throws IOException {
        Modelo produto = tableView.getSelectionModel().getSelectedItem();
        if (produto != null) {
            boolean buttonConfirmarClicked = showFXMLAnchorPaneProcessoEstoqueAtualizacaoDialog(produto);
            if (buttonConfirmarClicked) {
                estoqueDAO.atualizar(produto.getEstoque());
                carregarTableView();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um produto na Tabela.");
            alert.show();
        }    
    }
    
    public boolean showFXMLAnchorPaneProcessoEstoqueAtualizacaoDialog(Modelo produto) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneCadastroModeloDialogController.class.getResource(
                "/view/FXMLAnchorPaneCadastroEstoqueDialog.fxml"));
        AnchorPane page = (AnchorPane)loader.load();
        
        //criando um estágio de diálogo  (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Atualização do Estoque");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        //Setando o produto ao controller
        FXMLAnchorPaneProcessoEstoqueAtualizacaoController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setEstoque(produto.getEstoque());
        
        dialogStage.showAndWait();
        
        return controller.isButtonConfirmarClicked();
    }

    public boolean showFXMLAnchorPaneProcessoEstoqueMovimentacaoDialog(Modelo produto, String tipoMovimento) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneCadastroMotorDialogController.class.getResource(
            "/view/FXMLAnchorPaneProcessoEstoqueMovimentoDialog.fxml"));
        AnchorPane page = (AnchorPane)loader.load();
        
        //criando um estágio de diálogo  (Stage Dialog)
        Stage dialogStage = new Stage();
        if (tipoMovimento.equalsIgnoreCase("Repor")) {
            dialogStage.setTitle("Movimentação de Reposição: " + produto.getNome());
        } else {
            dialogStage.setTitle("Movimentação de Retirada: " + produto.getNome());
        }
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        //Setando o produto ao controller
        FXMLAnchorPaneCadastroMotorDialogController controller = loader.getController();
        controller.setTipoMovimento(tipoMovimento);
        controller.setDialogStage(dialogStage);
        controller.setEstoque(produto.getEstoque());
        
        
        dialogStage.showAndWait();
        
        return controller.isBtConfirmarClicked();
        
    }

}
