package br.edu.ifsc.fln.model.dao.ordemservicos;

import br.edu.ifsc.fln.model.dao.ordenservicos.ServicoDAO;
import br.edu.ifsc.fln.model.domain.ECategoria;
import br.edu.ifsc.fln.model.domain.ordemServicos.Servico;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServicoDAOTest {

    private ServicoDAO servicoDAO;
    private Connection connection;

    @BeforeAll
    void setupDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "java";
        String password = "java";

        connection = DriverManager.getConnection(url, user, password);
        servicoDAO = new ServicoDAO(connection);

        // Criação da tabela para testes
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS Servicos (
                id INT AUTO_INCREMENT PRIMARY KEY,
                descricao VARCHAR(255) NOT NULL,
                valor DECIMAL(10, 2) NOT NULL,
                categoria ENUM('PEQUENO', 'MEDIO', 'GRANDE', 'MOTO', 'PADRAO') NOT NULL,
                pontos INT
            ) ENGINE=InnoDB;
        """;

        connection.createStatement().execute(createTableSQL);
    }

    @AfterAll
    void teardownDatabase() throws SQLException {
        // Limpa a tabela após os testes
        connection.createStatement().execute("DROP TABLE IF EXISTS Servicos");
        connection.close();
    }

    @Test
    @Order(1)
    void testInserir() throws SQLException {
        Servico servico = new Servico("Lavagem Completa", BigDecimal.valueOf(100.00), 10, ECategoria.GRANDE);
        servicoDAO.inserir(servico);

        assertNotEquals(0, servico.getId(), "O ID do serviço não deve ser 0 após a inserção.");
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws SQLException {
        Servico servico = servicoDAO.buscarPorId(1);

        assertNotNull(servico, "O serviço com ID 1 deve existir.");
        assertEquals("Lavagem Completa", servico.getDescricao(), "A descrição do serviço deve ser 'Lavagem Completa'.");
    }

    @Test
    @Order(3)
    void testAtualizar() throws SQLException {
        Servico servico = servicoDAO.buscarPorId(1);
        assertNotNull(servico, "O serviço com ID 1 deve existir para ser atualizado.");

        servico.setDescricao("Lavagem Premium");
        servico.setValor(BigDecimal.valueOf(120.00));
        servicoDAO.alterar(servico);

        Servico servicoAtualizado = servicoDAO.buscarPorId(1);
        assertEquals("Lavagem Premium", servicoAtualizado.getDescricao(), "A descrição deve ser 'Lavagem Premium'.");
        assertEquals(BigDecimal.valueOf(120.00), servicoAtualizado.getValor(), "O valor deve ser 120.00.");
    }

    @Test
    @Order(4)
    void testListarTodos() throws SQLException {
        List<Servico> servicos = servicoDAO.listar();

        assertFalse(servicos.isEmpty(), "A lista de serviços não deve estar vazia.");
        assertEquals(1, servicos.size(), "A lista de serviços deve conter exatamente 1 serviço.");
    }

    @Test
    @Order(5)
    void testRemover() throws SQLException {
        servicoDAO.remover(1);

        Servico servico = servicoDAO.buscarPorId(1);
        assertNull(servico, "O serviço com ID 1 deve ser nulo após ser removido.");
    }
}

