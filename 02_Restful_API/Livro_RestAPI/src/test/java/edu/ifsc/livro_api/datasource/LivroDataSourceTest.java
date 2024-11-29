package edu.ifsc.livro_api.datasource;

import edu.ifsc.livro_api.domain.Livro;
import edu.ifsc.livro_api.dto.LivroDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LivroDataSourceTest {

    private LivroDataSource dataSource;

    @BeforeEach
    void setUp() {
        dataSource = new LivroDataSource();
        dataSource.criarLista(); // Inicializa os dados mock antes de cada teste
    }

    @Test
    void testCriarLista() {
        List<Livro> livros = dataSource.getAll();
        assertEquals(4, livros.size()); // Confirma que a lista contém 4 livros mock
    }

    @Test
    void testAdicionarLivro() {
        Livro novoLivro = new Livro(5, 5555, "Estrelas", "Ema Esteves", "Editora E", 55.90);
        dataSource.adicionar(novoLivro);

        List<Livro> livros = dataSource.getAll();
        assertEquals(5, livros.size()); // Confirma que o livro foi adicionado
        assertTrue(livros.contains(novoLivro)); // Verifica se o novo livro está na lista
    }

    @Test
    void testGetPorIsbn() {
        Optional<Livro> livro = dataSource.getPorIsbn(1111);
        assertTrue(livro.isPresent());
        assertEquals("Almas", livro.get().getTitulo());
    }

    @Test
    void testGetPorAutor() {
        List<Livro> livros = dataSource.getPorAutor("Ana Amalia");
        assertEquals(1, livros.size());
        assertEquals("Almas", livros.get(0).getTitulo());
    }

    @Test
    void testGetPorTitulo() {
        Optional<Livro> livro = dataSource.getPorTitulo("Dome");
        assertTrue(livro.isPresent());
        assertEquals(444, livro.get().getIsbn());
    }

    @Test
    void testGetPorIsbnDTO() {
        LivroDTO dto = dataSource.getPorIsbnDTO(1111);
        assertNotNull(dto);
        assertEquals("Almas", dto.getTitulo());
        assertEquals("Ana Amalia", dto.getAutor());
    }

    @Test
    void testGetAllDTO() {
        List<LivroDTO> dtos = dataSource.getAllDTO();
        assertEquals(4, dtos.size());
        assertEquals("Almas", dtos.get(0).getTitulo());
    }

    @Test
    void testReajustarPrecoPorId() {
        dataSource.reajustarPrecoPorId(1, 10); // Aumenta o preço em 10%
        Optional<Livro> livro = dataSource.getPorIsbn(1111);
        assertTrue(livro.isPresent());
        assertEquals(13.09, livro.get().getPreco(), 0.01);
    }

    @Test
    void testReajustarPreco() {
        dataSource.reajustarPreco(20); // Aumenta o preço de todos os livros em 20%
        List<Livro> livros = dataSource.getAll();
        assertEquals(14.28, livros.get(0).getPreco(), 0.01); // Verifica o preço do primeiro livro
    }
}

