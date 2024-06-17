package ListsInJava;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas 
/**
 * Gera a lista de Tarefas.
 */
{
    //Atritubos
    private List<Tarefas> tarefalist;

    //Metodo Construtor
    public ListaTarefas() 
    {
        this.tarefalist = new ArrayList<>();
    }

    //Metodos da classe
    public void adicionarTarefa(String descricao)
    /**
    * Adiciona uma tarefa na lista de tarefas.
    *
    * @param descricao informar qual a terefa a ser inclusa
    * @return Sem retorno
    */
    {
        tarefalist.add(new Tarefas(descricao));
    }

    public void removerTarefa(String descricao)
    /**
    * Remove uma tarefa na lista de tarefas.
    *
    * @param descricao informar qual a terefa a ser excluida
    * @return Sem retorno
    */
    {
        List<Tarefas> tarefasParaRemover = new ArrayList<>();
        //Criar uma lista de tareas para remover
        for (Tarefas t : tarefalist) 
        {
            if (t.getDescricao().equalsIgnoreCase(descricao))
            {
                tarefasParaRemover.add(t);
            }
        }
        //Com a lista feita, remover da lista de tarefas
        tarefalist.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas()
        /**
    * Conta o numero de tarefas dentro da lista de tarefas.
    *
    * @return Um numero que representa o total de tarefas contidas na lista de tarefas.
    */
    {
        return tarefalist.size();
    }

    public List<Tarefas> obterDescricoesTarefas()
        /**
    * Informa a descrcao das tarefas na lista de tarefas.
    * @return A lista de tarefas
    */
    {
        return tarefalist;
    }

    public static void main(String[] args) 
    {
        ListaTarefas listaTarefas = new ListaTarefas();

        System.out.println("O numero de total de elementos na lista é:" + listaTarefas.obterNumeroTotalTarefas()
        );

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Comprar pão");
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios");

        // Obtendo e imprimindo descrições das tarefas
        List<Tarefas> tarefas = listaTarefas.obterDescricoesTarefas();
        System.out.println("Lista de Tarefas:");
        for (Tarefas tarefa : tarefas) {
            System.out.println(tarefa);
        }
        System.out.println("___________________________________________\nO numero de total de elementos na lista é:" + listaTarefas.obterNumeroTotalTarefas()+"\n___________________________________________"
        );
    }
    
    
}