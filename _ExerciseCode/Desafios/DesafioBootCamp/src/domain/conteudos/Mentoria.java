package domain.conteudos;

import java.time.LocalDate;

public class Mentoria extends Conteudo
//Classe Publica
/**
* <h1>Mentoria</h1>
* A Classe Mentoria é a classe para instanciar as mentorias.
* <p>
* <b>Note:</b> Esta clase herda da classe Conteudo
* Recebe 3 parametros.    
* @author  Carlos Hayden
* @version 1.0
* @since   30/05/2024
*/ 
{
    private LocalDate data;

    //metodos
    @Override
    public double calcularXp() 
    {
        return XP_PADRAO + 20d;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Mentoria: \ndata=" + data + "\nTitulo=" + getTitulo() + "\nDescricao=" + getDescricao() + "\n";
    }
}
