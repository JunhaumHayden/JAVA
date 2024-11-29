package edu.ifsc.livro_api.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroDTOTest {

    @Test
    public void testLivroDTOCreation() {
        // Criar um objeto LivroDTO com todos os valores
        LivroDTO livroDTO = new LivroDTO("Clean Code", "Robert C. Martin", "Prentice Hall", 49.90);

        // Verificar se os valores foram atribuídos corretamente
        assertEquals("Clean Code", livroDTO.getTitulo());
        assertEquals("Robert C. Martin", livroDTO.getAutor());
        assertEquals("Prentice Hall", livroDTO.getEditora());
        assertEquals(49.90, livroDTO.getPreco());
    }

    @Test
    public void testLivroDTOSetters() {
        // Criar um objeto LivroDTO vazio
        LivroDTO livroDTO = new LivroDTO();

        // Configurar valores usando setters
        livroDTO.setTitulo("Refactoring");
        livroDTO.setAutor("Martin Fowler");
        livroDTO.setEditora("Addison-Wesley");
        livroDTO.setPreco(79.90);

        // Verificar se os valores foram atribuídos corretamente
        assertEquals("Refactoring", livroDTO.getTitulo());
        assertEquals("Martin Fowler", livroDTO.getAutor());
        assertEquals("Addison-Wesley", livroDTO.getEditora());
        assertEquals(79.90, livroDTO.getPreco());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Criar dois objetos com os mesmos valores
        LivroDTO livroDTO1 = new LivroDTO("Domain-Driven Design", "Eric Evans", "Addison-Wesley", 99.90);
        LivroDTO livroDTO2 = new LivroDTO("Domain-Driven Design", "Eric Evans", "Addison-Wesley", 99.90);

        // Verificar se equals e hashCode funcionam corretamente
        assertEquals(livroDTO1, livroDTO2);
        assertEquals(livroDTO1.hashCode(), livroDTO2.hashCode());
    }

    @Test
    public void testToString() {
        // Criar um objeto LivroDTO
        LivroDTO livroDTO = new LivroDTO("The Pragmatic Programmer", "Andy Hunt", "Addison-Wesley", 59.90);

        // Verificar a saída do método toString
        String expected = "LivroDTO(titulo=The Pragmatic Programmer, autor=Andy Hunt, editora=Addison-Wesley, preco=59.9)";
        assertEquals(expected, livroDTO.toString());
    }
}

