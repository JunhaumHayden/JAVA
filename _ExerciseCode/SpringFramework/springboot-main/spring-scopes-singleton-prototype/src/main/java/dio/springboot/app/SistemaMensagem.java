package dio.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * O sistema deve conter os dois emails que enviarao as mensagens (Dois objetos do tipo Remetente)
 */
@Component //annotation para informar ao spring que essa classe é um componente do container
public class SistemaMensagem {
    @Autowired //para informar ao spring a injecao de dependencia de um objeto noreplay do tipo Remetente de forma não explicita (Sem o uso de new para instanciar)
    private Remetente noreply; // Objeto com o email 01
    @Autowired //para informar ao spring a injecao de dependencia de um objeto noreplay do tipo Remetente de forma não explicita
    private Remetente techTeam; // Objeto com o email 02
   public void enviarConfirmacaoCadastro(){
       System.out.println(noreply);
       System.out.println("Seu cadastro foi aprovado");
   }
    public void enviarMensagemBoasVindas(){
        techTeam.setEmail("tech@dio.com.br"); //Setando para o email correto para este fim
        System.out.println(techTeam);
        System.out.println("Bem-vindo à Tech Elite");
    }
}
