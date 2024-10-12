package edu.ifsc.javafx_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javafx.application.Application;
import javafx.stage.Stage;
@EnableScheduling
@SpringBootApplication
		/*
		 * Ajuste na classe Application do Spring Boot
		 *	A classe criada precisa ser iniciada a partir do aplicativo Spring Boot.
		 *
		 * Em vez de usar org.springframework.boot.SpringApplication para executar o aplicativo, usar a classe javafx.application.Application e chamar launch com a classe que é nossa classe JavaFX a FxMainApplication e passando os argumentos da aplicação.
		 * Este metodo padrão de inicializar pelo Spring deve ser substituido pelo metodo launch() do Java Fx (inicia pelo Java Fx)
		 */ 
public class JavafxSpringApplication {

	public static void main(String[] args) {
		/*
		 * Este metodo padrão de inicializar pelo Spring deve ser substituido pelo metodo launch() do Java Fx (iniciar pelo Java Fx)
		 */
		//SpringApplication.run(JavafxSpringApplication.class, args);
		Application.launch(FxMainApplication.class, args);
	}

}
