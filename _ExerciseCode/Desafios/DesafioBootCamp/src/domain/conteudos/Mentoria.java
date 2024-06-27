package domain.conteudos;

import java.time.LocalDate;
/**
* <h2>Mentoria</h2>
* Classe que representa as mentorias.
* <p>
* <b>Note:</b> Esta clase herda da classe {@code Conteudo}
* </p>
* <p>Recebe 3 parametros:<br>
* titulo;<br>
* descricao;<br>
* date (gerado automaticamente)
* </p>    
*
* @author  Carlos Hayden
* @version 1.0
* @since   30/05/2024
*/ 
public class Mentoria extends Conteudo

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
