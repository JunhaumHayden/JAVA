package edu.ifsc.Calculadora_exemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculadoraExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraExemploApplication.class, args);

		int resultado = Calculadora.soma(3, 3);
			System.out.println( "A soma de 2 e 3 deveria ser " + resultado);
	}

}
