package edu.ifsc.livro_api.datasource;

import edu.ifsc.livro_api.domain.Livro;
import edu.ifsc.livro_api.dto.LivroDTO;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component // Permite que o Spring gerencie esta classe
public class LivroDataSource {
    private final List<Livro> livros = new ArrayList<>();

    @PostConstruct // Annotation para executar automaticamente o metodo após a construção do bean
    // inicializar a lista com dados mock
    public void criarLista() {
        livros.add(new Livro(1, 1111, "Almas", "Ana Amalia", "Editora A", 11.90));
        livros.add(new Livro(2, 2222, "Barito", "Bia Bianch", "Editora B", 22.90));
        livros.add(new Livro(3, 3333, "Compostela", "Clara camoes", "Editora C", 33.90));
        livros.add(new Livro(4, 444, "Dome", "Dani Duarte", "Editora D", 44.90));
    }

    public Livro adicionar(Livro livro) {
        livros.add(livro);
        return livro;
    }

    public List<Livro> getAll() {
        return new ArrayList<>(livros);
    }

    public Optional<Livro> getPorIsbn(int isbn) {
        // Pode conter o objeto Livro correspondente ao ISBN fornecido ou estar vazio se nenhum livro for encontrado. é uma classe que ajuda a lidar com valores que podem ser null, evitando NullPointerException
        return livros.stream() //Inicia um fluxo (stream) da lista livros. Isso permite realizar operações como filtragem, mapeamento e coleta.
                .filter(livro -> livro.getIsbn() == isbn)
                .findFirst(); //Retorna o primeiro elemento do Stream resultante que é um objeto do tipo Optional<Livro> e se não houver nenhum elemento (nenhum livro com o ISBN fornecido), retorna um Optional.empty().
    }

    public List<Livro> getPorAutor(String autor) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor)) // Filtra pelo autor (ignora maiúsculas/minúsculas)
                .toList(); // Coleta os resultados em uma lista
    }

    public Optional<Livro> getPorTitulo(String titulo) {
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    public LivroDTO getPorIsbnDTO(int isbn) {
        return getPorIsbn(isbn)
                .map(livro -> new LivroDTO(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco()))
                .orElse(null);
    }

    public List<LivroDTO> getAllDTO() {
        List<LivroDTO> dtos = new ArrayList<>();
        for (Livro livro : livros) {
            dtos.add(new LivroDTO(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco()));
        }
        return dtos;
    }

    public void reajustarPrecoPorId(int id, int taxa) {
        livros.stream()
                .filter(livro -> livro.getId() == id)
                .forEach(livro -> livro.reajustarPreco(taxa));
    }

    public void reajustarPreco(int taxa) {
        livros.forEach(livro -> livro.reajustarPreco(taxa));
    }
}
