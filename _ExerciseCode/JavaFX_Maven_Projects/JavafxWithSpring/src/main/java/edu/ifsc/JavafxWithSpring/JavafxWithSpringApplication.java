package edu.ifsc.JavafxWithSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

//Inicio do SpringBoot
@SpringBootApplication
public class JavafxWithSpringApplication {

	public static void main(String[] args) {
		Application.launch(AplicacaoJavaFX.class);
	}

}