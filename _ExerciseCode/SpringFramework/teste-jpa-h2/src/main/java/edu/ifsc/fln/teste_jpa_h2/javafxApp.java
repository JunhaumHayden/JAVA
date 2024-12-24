package edu.ifsc.fln.teste_jpa_h2;

import atlantafx.base.theme.NordDark;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class javafxApp extends Application {
    @Override
    public void start(Stage primaryStage) {

        // Uso de temas CSS
        Application.setUserAgentStylesheet(new NordDark().getUserAgentStylesheet());

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/FXMLLabelMensagem.fxml"));
        } catch (IOException ex) {
            System.out.println("Não foi possível carregar a tela");
        }

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Meu Primeiro JavaFX");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
}
