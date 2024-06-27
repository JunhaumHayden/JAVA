package domain.conteudos;
//Classe Publica
/**
* <h2>Curso</h2>
* A Classe representa os Curso.
* <p>
* <b>Note:</b> Esta clase herda da classe Conteudo.</p>
* <p>Recebe 3 parametros:<br>
* titulo;<br>
* descricao;<br>
* cargaHoraria;
* </p>     
* @author  Carlos Hayden
* @version 1.0
* @since   30/06/2024
*/ 
public class Curso extends Conteudo
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
