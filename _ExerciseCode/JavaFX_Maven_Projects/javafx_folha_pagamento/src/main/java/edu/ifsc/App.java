package edu.ifsc;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hayden
 * Necessario extender de Application
 */
public class App extends Application
{
    
    /*
     * Necessário implementar o metodo start da classe Application instanciando um objeto do tipo Stage (javafx.stage.Stage;)
     */
    @Override
    public void start (Stage stage) {
        /*
         * Necessario instanciar um objeto do tipo Parent por causa do escopo do try/catch
         * O objet Parent vai instanciar com as configuracoes do arquivo fxml. 
         */
        Parent root = null;
        try {
            /*
             * Tenta atribuir ao objeto do tipo Parent
             * Um um objeto do tipo FXMLLoader 
             * e passa no argumento o caminho onde encontra-se o arquivo .fxml no projeto
             */
            
            root = FXMLLoader.load(getClass().getResource("/view/FXMLCalculoSalarios.fxml"));
            /*
             * Em caso de erro lancar uma excecão do tipo IOException (java.io.IOException) que são excecoes de I/O
             */
        } catch (IOException ex) {
            // LogSystem.adicionarLog("Falha ao carregar o programa.");
            System.out.println("Falha ao carregar o programa.\n Já abriu um chamado?");
        }
        /*
         * O objeto do tipo Scene irá conter as configuracoes utilizadas para renderizar a janela
         */
        Scene cena = new Scene(root, 379, 250);
        // stage.getIcons().add(Utils.APPLICATION_ICON);
        stage.setTitle("Calculadora de Salario - IFSC");
        stage.setScene(cena);
        stage.setResizable(true);
        stage.show();
    } 
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        launch(args);
        // LogSystem.adicionarLog("Sistema inicializado com sucesso");
    }
}
