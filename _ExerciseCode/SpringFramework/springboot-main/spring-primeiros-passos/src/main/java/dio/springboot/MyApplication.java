package dio.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Classe que será inicializada pelo Spring dentro do container da aplicação como se fosse o metodo main() sem o uso do SpringBoot.
 * Deve implementar CommandLineRunner que é a classe disponibilizada pelo Spring.
 * Como é uma interface deve-se implementar o metodo run() para executar.
 *
 */
@Component
public class MyApplication implements CommandLineRunner {
    @Autowired //Annotation para indicar a que a classe MyApplication precisa injetar dependencia da classe Calculadora (Sem o Spring seria o equivalente a instanciar o Objeto calculadora através do new Calculadora - dependencia explicita do objeto calculadora). O spring ja havia detectado que haverá um componente Calculadora no container, mas a classe MyAplication precisa informar ao Spring que necessita de injecao de dependencia atraves do @Autowired para essa classe.
    private Calculadora calculadora;


    @Override
    public void run(String... args) throws Exception {
        /**
         * Apartir desse ponto já usam-se os conceitos de inversao de controle e injecao de dependencias. Pode eliminar a existencia do "new" para instanciar um objeto é necessario informar ao Spring a existencia de Beans (Objetos Gerenciados pelo Spring).
         * Utiliza-se a Annotation @Component (org.springframework.stereotype.Component) na classe que irá inicializar através do spring (classe Myapplication) e nas classes que esta fará uso (neste exemplo a classe calculadora) para determinar o BEANS.
         * No atributo da classe informar a classe que irá ser instanciada pelo spring (atributo calculadora do tipo Calculadora)
         */
        System.out.println("###### O resultado é "+ calculadora.somar(2,7));
    }
}