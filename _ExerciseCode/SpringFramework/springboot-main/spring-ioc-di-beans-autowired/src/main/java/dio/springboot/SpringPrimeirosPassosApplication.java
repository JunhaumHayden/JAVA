package dio.springboot;

import com.google.gson.Gson;
import dio.springboot.app.ConversorJson;
import dio.springboot.app.ViaCepResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringPrimeirosPassosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrimeirosPassosApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(ConversorJson conversor) throws Exception { //Implementado como Bean pois não há acesso ao codigo fonte. o Argumento do metodo run funciona como um @Autowired
		return args -> {
			String json = "{\"cep\": \"01001-000\",\"logradouro\": \"Praça da Sé\",\"localidade\": \"São Paulo\"}";
			ViaCepResponse response = conversor.converter(json);
			System.out.println("Dados do CEP: " + response);
		};
	}

	/**
	 * Esta é uma abordagem para se declarar uma dependencia externa (sem acesso ao codigo fonte). Declarando o metodo de execucao do Spring, porém é mais indicado criar uma classe para este fim, neste exemplo é a classe Beans.
	 * @see dio.springboot.app.Beans
	 * @return
	 */
//	@Bean
//	public Gson gson(){
//		return new Gson();
//	}

}
