package dio.springboot.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Classe que representa um sistema de envio de mensagens
 * Deve enviar uma mensagem passando os parametros para dentro da mensagem e exibir.
 * A Anntotation @Value é uma maneira de atribuir valores de forma não explicita (evitando a utilizacao do operador "=")atraves do arquivo application.properties do spring 
 */
@Component
public class SistemaMensagem implements CommandLineRunner {
	@Value("${name:NoReply-JUNHAUM}") //Annotation para o spring procurar uma correspondencia no arquivo application.properties. No arguento reapassar a chave procurada (name) e caso nao escontrada usar um valor padrao (:NoReply-JUNHAUM) e atribui na variavel abaixo da notacao (neste exemplo o atributo "nome")
	private String nome;
	@Value("${email}")
	private String email;
	@Value("${telefones}")
	private List<Long> telefones =
			new ArrayList<>(Arrays.asList(new Long[]{11956781254L}));

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Mensagem enviada por: " + nome
				+ "\nE-mail:" + email
				+ "\nCom telefones para contato: " + telefones);
		System.out.println("Seu cadastro foi aprovado");
	}
}
