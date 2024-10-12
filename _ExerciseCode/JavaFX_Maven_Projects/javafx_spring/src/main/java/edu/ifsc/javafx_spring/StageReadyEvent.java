package edu.ifsc.javafx_spring;

import org.springframework.context.ApplicationEvent;

import javafx.stage.Stage;

/*
 * Classe para publicar um evento para o Spring quando o Java FX estiver pronto.
 *A classe StageReadyEvent que estende de org.springframework.context.ApplicationEvent:
 */

public class StageReadyEvent extends ApplicationEvent {
    public StageReadyEvent(Stage stage) {
      super(stage);
    }
  
    public Stage getStage() {
      return ((Stage) getSource());
    }
  }
  
