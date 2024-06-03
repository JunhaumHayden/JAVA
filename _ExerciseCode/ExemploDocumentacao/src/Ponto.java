package java._ExerciseCode.ExemploDocumentacao.src;
/**
* <h1>Ponto</h1>
* Classe que representa um ponto no plano cartesiano.
* <p>
* <b>Note:</b> Leia atentamente a documentação desta classes
* para desfrutar dos recursos oferecidos pelo autor
* </p>
*
* @author  Junhaum Hayden
* @version 1.0
* @since   30/05/2024

 * @see Ponto#x
 * @see Ponto#y
 */

public class Ponto 
{
    private int x;
    private int y;

    /**
     * Cria um ponto com as coordenadas especificadas.
     *
     * @param x a coordenada X
     * @param y a coordenada Y
     */
    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retorna a coordenada X deste ponto.
     * A coordenada X é armazenada na variável {@link #x}.
     *
     * @return a coordenada X
     */
    public int getX() {
        return x;
    }

    /**
     * Retorna a coordenada Y deste ponto.
     * A coordenada Y é armazenada na variável {@link #y}.
     *
     * @return a coordenada Y
     */
    public int getY() {
        return y;
    }

    /**
     * Define a coordenada X deste ponto.
     *
     * @param x a nova coordenada X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Define a coordenada Y deste ponto.
     *
     * @param y a nova coordenada Y
     */
    public void setY(int y) {
        this.y = y;
    }
}
