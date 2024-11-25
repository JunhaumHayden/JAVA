package dio.springboot.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Classe de configuracao do Spring
 * gera a dependencia instanciando um novo objetos onde houver as Annotations @Bean e @Autowared.
 * A estrategia tomada neste exemplo foi instanciar um objeto padrao e alterar os valores dos atributos quando for instanciado.
 * Nesse contexto, sem a Annotation @Scope("prototype") todos os objetos terao a mesma referencia na memoria, mesmo estando criados em variaveis diferentes. E na estrategia tomada aqui, ao se setar o atributo em um objeto referenciado em uma variavel, a alteracao será refletida para as demais devido o metodo de construçao da classe.
 * Para evitar esse problema usa-se a construcao @Scope("prototype") no spring, ou seja cada instancia do objeto terá um escopo.
 * @see metodo SistemaMensagem.enviarConfirmacaoCadastro()
 * @see metodo SistemaMensagem.enviarMensagemBoasVindas()
 */
@Configuration
public class Beans {
    @Bean
    @Scope("prototype")
    public Remetente remetente(){
        System.out.println("CRIANDO UM OBJETO REMETENTE");
        Remetente remetente = new Remetente();
        remetente.setEmail("noreply@dio.com.br");
        remetente.setNome("Digital Innovation One");
        return remetente;
    }
}
