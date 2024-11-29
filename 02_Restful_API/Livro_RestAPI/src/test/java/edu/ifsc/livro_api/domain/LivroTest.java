package edu.ifsc.livro_api.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    private Livro livro;

    @BeforeEach
    public void setup() {
        // Inicializando o livro antes de cada teste
        livro = new Livro();
        livro.setId(1);
        livro.setIsbn(1234);
        livro.setTitulo("Livro A");
        livro.setAutor("Autor A");
        livro.setEditora("Editora A");
        livro.setPreco(100.0);
    }

    @Test
    public void testReajustarPreco() {
        // Preço original
        double precoOriginal = livro.getPreco();

        // Taxa de reajuste de 10%
        livro.reajustarPreco(10);

        // Esperamos que o preço seja reajustado para 110.0 (100 + 10% de 100)
        assertEquals(precoOriginal * 1.1, livro.getPreco(), "O preço não foi reajustado corretamente");
    }

    @Test
    public void testReajustarPrecoSemAlterar() {
        // Preço original
        double precoOriginal = livro.getPreco();

        // Taxa de reajuste de 0%
        livro.reajustarPreco(0);

        // O preço não deve mudar
        assertEquals(precoOriginal, livro.getPreco(), "O preço não deveria ser alterado com taxa 0%");
    }

    @Test
    public void testLivroValoresIniciais() {
        // Verificando os valores iniciais do livro
        assertEquals(1, livro.getId());
        assertEquals(1234, livro.getIsbn());
        assertEquals("Livro A", livro.getTitulo());
        assertEquals("Autor A", livro.getAutor());
        assertEquals("Editora A", livro.getEditora());
        assertEquals(100.0, livro.getPreco());
    }
}

