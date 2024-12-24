package br.edu.ifsc.fln.model.dao.veiculos;

import br.edu.ifsc.fln.exceptions.ExceptionLavacao;
import br.edu.ifsc.fln.model.dao.clientes.ClienteDAO;
import br.edu.ifsc.fln.model.domain.cliente.Cliente;
import br.edu.ifsc.fln.model.domain.veiculos.Cor;
import br.edu.ifsc.fln.model.domain.veiculos.Modelo;
import br.edu.ifsc.fln.model.domain.veiculos.Veiculo;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para VeiculoDAO.
 *
 * @author
 * @version 1.0
 * @since 27/11/2024
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VeiculoDAOTest {

    private Connection connection;
    private VeiculoDAO veiculoDAO;
    private ClienteDAO clienteDAO;
    private ModeloDAO modeloDAO;
    private MarcaDAO marcaDAO;
    private CorDAO corDAO;

    private Cliente clienteTest;
    private Modelo modeloTest;
    private Cor corTest;

    @BeforeAll
    void setup() throws SQLException {
        // Configuração da conexão com o banco de dados
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "java", "java");
        veiculoDAO = new VeiculoDAO(connection);
        modeloDAO = new ModeloDAO(connection);
        marcaDAO = new MarcaDAO(connection);
        corDAO = new CorDAO(connection);
        clienteDAO = new ClienteDAO(connection);
    }

    @AfterAll
    void tearDownClass() throws SQLException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            fail("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }

    @Test
    @Order(1)
    void testInserirVeiculo() throws SQLException, ExceptionLavacao {
        // Configurando um Veículo para inserção
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC-1234");
        veiculo.setObservacoes("Carro do cliente");
        veiculo.setCliente(new Cliente(1));
        veiculo.setModelo(new Modelo(2));
        veiculo.setCor(new Cor(1));

        // Executando o método
        Veiculo resultado = veiculoDAO.inserir(veiculo);

        // Verificando os resultados
        assertNotNull(resultado);
        assertTrue(veiculo.getId() > 0, "ID do veículo deveria ter sido gerado.");
    }

//    @Test
//    @Order(2)
//    void testBuscarVeiculoPorId() throws SQLException {
//        int idTest = 1; // Assumindo que um veículo com ID 1 foi adicionado no banco
//        Veiculo veiculo = veiculoDAO.buscarVeiculoPorId(idTest);
//
//        assertNotNull(veiculo, "O veículo não deveria ser nulo.");
//        assertEquals("ABC-1234", veiculo.getPlaca(), "Placa deveria ser 'ABC-1234'.");
//    }
//
    @Test
    @Order(3)
    void testAtualizarVeiculo() throws SQLException, ExceptionLavacao {
        // Configurando um Veículo para inserção
        Veiculo veiculo = new Veiculo();
        veiculo.setId(14);
        veiculo.setPlaca("ABC-4321");
        veiculo.setObservacoes("Atualizado para teste");
        veiculo.setCliente(new Cliente(2));
        veiculo.setModelo(new Modelo(4));
        veiculo.setCor(new Cor(2));

        // Executando o método
        boolean sucesso = veiculoDAO.alterar(veiculo);

        // Verificando os resultados
        assertTrue(sucesso);

        Veiculo veiculoAtualizado = veiculoDAO.buscarVeiculo(14);
        assertEquals("Atualizado para teste", veiculoAtualizado.getObservacoes(), "Observação deveria ter sido atualizada.");
    }

    @Test
    @Order(4)
    void testListarVeiculo() throws SQLException {
        List<Veiculo> veiculo = veiculoDAO.listarVeiculo();
        assertFalse(veiculo.isEmpty(), "A lista de veículos não deveria estar vazia.");
    }

    @Test
    @Order(5)
    void testRemoverVeiculo() throws SQLException {
        Veiculo veiculo = veiculoDAO.buscarVeiculo(14);
        assertNotNull(veiculo, "O veículo deveria existir para ser removido.");

        veiculoDAO.removerVeiculo(veiculo);

        Veiculo veiculoRemovido = veiculoDAO.buscarVeiculo(14);
        assertNull(veiculoRemovido, "O veículo deveria ter sido removido.");
    }

    @AfterAll
    void closeDatabaseConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

