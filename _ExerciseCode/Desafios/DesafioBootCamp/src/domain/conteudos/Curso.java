package domain.conteudos;

public class Curso extends Conteudo
//Classe Publica
/**
* <h1>Curso</h1>
* A Classe Curso é a classe para instanciar os Curso.
* <p>
* <b>Note:</b> Esta clase herda da classe Conteudo
* Recebe 3 parametros.</p>    
* @author  Carlos Hayden
* @version 1.0
* @since   30/05/2024
*/ 
{
    private int cargaHoraria;

    //construtor padrao
    public Curso()
    {}
    @Override
    public double calcularXp() 
    {
        return XP_PADRAO * cargaHoraria;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    @Override
    public String toString() {
        return "Curso: \ncargaHoraria=" + cargaHoraria + "\nTitulo=" + getTitulo() + "\nDescricao="
                + getDescricao() + "\n";
    }


}
