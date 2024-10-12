package edu.ifsc.javafx_spring;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/*
 * Classe que representa o aplicativo JavaFX
 * É necessário criar a classe que será responsável por iniciar a aplicação e que ela estenda javafx.application.Application:
 */

public class FxMainApplication extends Application {
    private ConfigurableApplicationContext applicationContext;
	
    /*
     * Metodo sobre escrito necessário para realizar os metdos da classe Application
     * Configurando o contexto da aplicação
     * Para controlar o ciclo de vida da aplicação publicar os eventos no contexto Spring. Para isso utiliz org.springframework.context. ConfigurableApplicationContext e criar os eventos da aplicação JavaFX:
     * Sobrepondo o método start():
     * * O método start (de `Aplication` do JavaFX) é chamado com um objeto `Stage` quando está pronto para ser usado. 
      * Utilizando o padrão do Spring podemos publicar o evento que de quando a aplicação está pronta. O método `start(Stage stage)`, chama o applicationContext.publishEvent() com um novo StageReadyEvent, que é construído com o Stage.
     */
	@Override
	public void start(Stage stage) {
        applicationContext.publishEvent(new StageReadyEvent (stage));
	}
        @Override
        public void init() {
        applicationContext =
                new SpringApplicationBuilder(JavafxSpringApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
        }

        @Override
        public void stop() {
        applicationContext.close();
        Platform.exit();
        }

}

