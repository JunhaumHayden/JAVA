package domain.alunos;
import domain.conteudos.*;

import java.util.*;

//Classe Dev
/**
* <h1>Dev</h1>
* A Classe Dev é a classe usada para instanciar alunos.
* <p>
* <b>Note:</b> <p>Implementado LinkedHashSet para salvar na ordem em que for sendo incrementado</p>
* <p>Foi utilizado {@code Set} ao invés de {@code List} para que não seja permitido a repetição de itens</p>
*
* @author  Carlos Hayden
* @version 1.0
* @since   30/05/2024
*/
public class Dev 

{
    /**
    * <h2>Atributos</h2>
    * nome; conteudosInscritos; conteudosConcluidos.
    */
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    /**
    * <h2>Métodos</h2>
    */
    /**
    * Adiciona um bootcamp na lista {@code conteudosInscritos}
    * @param bootcamp O nome do bootcamp para realizar a inscrição
    * @return void
    */
    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }
    
    /**
    * <p> Adiciona o primeiro item na lista {@code conteudosInscritos}  na lista {@code conteudosConcluidos}.</p>
    * <p> Renove este item da lista {@code conteudosInscritos}.</p>
    * <p> Ou apresenta a mensagem caso alista esteja vazia.</p>
    */
    
    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }
    
    /**
    * <p> Calcula o XP do aluno.</p>
    * @return a soma do total de cada item da lista {@code conteudosInscritos}.
    */
    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) 
    //Metodo equals
/**
* <h2>Equals</h2>
* Metodo implementado devido ser necessário para o uso de LinkedHashSet.
*/
{
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() 
        //Metodo hashCode
/**
* <h2>hashCode</h2>
* Metodo implementado devido ser necessário para o uso de LinkedHashSet.
*/
{
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
