package edu.ifsc.javafx_spring;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StageReadyEventListener implements ApplicationListener<StageReadyEvent> {

  @Value("${spring.application.ui.title}")
  private final String applicationTitle;

  @Override
  public void onApplicationEvent(StageReadyEvent event) {
    var stage = event.getStage();
    Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("/view/FXML_iguess.fxml"));
        } catch (IOException ex) {
            System.out.println("Não foi possível carregar a tela");
        }
    var scene = new Scene(parent);
    scene
        .getStylesheets()
        .add(
            Objects.requireNonNull(
                    StageReadyEventListener.class.getResource("multi-column-app.css"))
                .toExternalForm());
    
    stage.setScene(scene);
    stage.setTitle(applicationTitle);
    stage.centerOnScreen();
    stage.show();
  }
}
