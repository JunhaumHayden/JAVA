/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package br.edu.ifsc;

import atlantafx.base.theme.NordDark;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author Hayden
 * Necessario extender de Application
 */
public class Main extends Application {
    
/*
 *
 * Necessario sobre escrever o metodo start
 * Necessario implementar metodo start, que irá inicia a aplicaçao no javaFX
 */
    @Override
    public void start(Stage primaryStage) {

        // Uso de temas CSS
        Application.setUserAgentStylesheet(new NordDark().getUserAgentStylesheet());

        /**
        *
        * Instanciar um objeto do tipo Parent (Neste caso root).
        * Apartir desse objeto irá carregar as configuraçoes contidas no arquivo .FXML que deve esta na view do projeto.
        * Com getClass para usar o nome da class e getResource para capturar o caminho até onde esta o diretorio resources/view do projeto
        * O bloco try/cat para tratar a excessao caos nao seja encontrado o arquivo .FXML
        */
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/FXML_iguess.fxml"));
        } catch (IOException ex) {
            System.out.println("Não foi possível carregar a tela");
        }
        
        /**
         *
         * Agora instanciar um objeto do tipo Scene
         * Necessario setar o objeto com Parent criado anteriormente. 600, 400 são os paramentros de tamanho da janela
         */
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("Meu Primeiro JavaFX");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    /**
     * Para iniciar deve-se chamar o launch
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
