package edu.junhaum.lavacode.domain.ordemServicos;

import edu.junhaum.lavacode.domain.Ecategoria;

/**
* <h1>Servico</h1>
* Classe para tratar dos servicos existentes.<br>
*  
*
* 
* @author  Junhaum Hayden
* @version 1.0
* @since   07/08/2024
* 
*/
public class Servico {
    private static int ultimoId = 0;
    private int id;
    private String descricao;
    private Double valor;
    private int pontos;
    private Ecategoria categoria;

    //construtor padrao
    /**
     * Gera automaticamente um ID de servico unico a cada nova instancia da classe. 
     *
     * 
     * 
     */
    private Servico() {
        this.id = ++ultimoId; //Autoincemento do ID
    }

    //construtor sobrecarregado
    /**
     * Cria um servico com as informaçoes obrigatorias e chama, automaticamente o construtor padrao para gerar o ID unico.
     *
     * @param descricao Descreve o tipo de servico
     * @param vslor O valor unitário do servico
     * @param pontos A pontuacao associada ao servico
     * @param categoria Um serviço pode ter valor PADRAO, PEQUENTO,
MEDIO, GRANDE OU MOTO.
     * 
     */
    public Servico(String descricao, Double valor, int pontos, Ecategoria categoria) {
        this();
        this.descricao = descricao;
        this.valor = valor;
        this.pontos = pontos;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Ecategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Ecategoria categoria) {
        this.categoria = categoria;
    }
    

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", pontos=" + pontos +
                '}';
    }

   
    
}

